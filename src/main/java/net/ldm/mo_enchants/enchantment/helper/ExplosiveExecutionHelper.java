package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Helper for both {@link net.ldm.mo_enchants.enchantment.UltimateFinishEnchantment} and
 * {@link net.ldm.mo_enchants.enchantment.DetonationEnchantment}.
 */
@EventBusSubscriber
public class ExplosiveExecutionHelper {
    private static final Set<UUID> ATTACKERS = new HashSet<>();

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;
        LivingEntity victim = event.getEntity();
        ItemStack weapon = attacker.getMainHandItem();

        if (weapon.getEnchantmentLevel(MoEnchantsEnchantments.ULTIMATE_FINISH.get()) > 0
            || weapon.getEnchantmentLevel(MoEnchantsEnchantments.DETONATION.get()) > 0) {
            ATTACKERS.add(attacker.getUUID());

            if (!victim.level().isClientSide()) {
                victim.level().explode(
                        attacker,
                        victim.getX(),
                        victim.getY(),
                        victim.getZ(),
                        3,
                        ExplosionInteraction.NONE);
            }
        }
    }

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        var attacker = event.getExplosion().getIndirectSourceEntity();
        if (attacker == null) return;

        if (ATTACKERS.remove(attacker.getUUID())) {
            event.getAffectedEntities().remove(event.getExplosion().getIndirectSourceEntity());
        }
    }
}
