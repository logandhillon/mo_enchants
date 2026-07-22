package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class HarmingCurseEnchantment extends Enchantment {
    public HarmingCurseEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onEntityAttacked(LivingIncomingDamageEvent event, LivingEntity attacker) {
        if (attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.HARMING_CURSE.get()) > 0) {
            attacker.hurt(ModDamageSources.of(ModDamageSources.HARMING_CURSE, attacker), event.getAmount() / 2f);
        }
    }
}
