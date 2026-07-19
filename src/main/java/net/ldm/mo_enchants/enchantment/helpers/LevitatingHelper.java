package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class LevitatingHelper {
    public static void onEntityAttacked(LivingHurtEvent event, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.LEVITATING.get());
        if (level < 1) return;

        event.getEntity().addEffect(new MobEffectInstance(MobEffects.LEVITATION, level * 10, 0));
    }
}