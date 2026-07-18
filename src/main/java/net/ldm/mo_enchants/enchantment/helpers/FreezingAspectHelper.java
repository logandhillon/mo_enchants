package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class FreezingAspectHelper {
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity livingEntity)) return;

        int level = Math.max(
                livingEntity.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.FREEZING_ASPECT.get()),
                livingEntity.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.FROST.get()));
        if (level < 1) return;

        event.getEntity().addEffect(new MobEffectInstance(
                MobEffects.MOVEMENT_SLOWDOWN,
                40 + (level - 1) * 35,
                level - 1,
                false,
                false));
    }
}