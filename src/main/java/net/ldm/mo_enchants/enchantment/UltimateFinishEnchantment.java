package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.level.ExplosionEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UltimateFinishEnchantment extends Enchantment {
    private static final Set<UUID> ATTACKERS = new HashSet<>();

    public UltimateFinishEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == MoEnchantsEnchantments.LIFE_STEAL.get())
            return false;
        return ench != MoEnchantsEnchantments.REVENANT.get();
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onEntityDeath(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        if (EnchantmentHelper.getTagEnchantmentLevel(
                MoEnchantsEnchantments.ULTIMATE_FINISH.get(), attacker.getMainHandItem()) > 0) {
            ATTACKERS.add(attacker.getUUID());

            if (!attacker.level().isClientSide()) {
                attacker.level().explode(
                        attacker,
                        attacker.getX(),
                        attacker.getY(),
                        attacker.getZ(),
                        3,
                        ExplosionInteraction.NONE);
            }
        }
    }

    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        var attacker = event.getExplosion().getIndirectSourceEntity();
        if (attacker == null) return;

        if (ATTACKERS.remove(attacker.getUUID())) {
            event.getAffectedEntities().remove(event.getExplosion().getIndirectSourceEntity());
        }
    }
}
