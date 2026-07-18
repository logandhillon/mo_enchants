package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DetonationHelper {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;
        LivingEntity victim = event.getEntity();

        if (attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.DETONATION.get()) > 0) {
            if (!victim.level().isClientSide)
                victim.level().explode(null, victim.getX(), victim.getY(), victim.getZ(), 3, ExplosionInteraction.NONE);
        }
    }
}
