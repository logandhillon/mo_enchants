package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class FreezingAspectHelper {
    public static void onEntityAttacked(LivingIncomingDamageEvent event, LivingEntity attacker) {
        int level = Math.max(
                attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.ICE_ASPECT.get()),
                attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.FROST.get()));
        if (level < 1) return;

        event.getEntity().addEffect(new MobEffectInstance(
                MobEffects.MOVEMENT_SLOWDOWN,
                40 + (level - 1) * 35,
                level - 1,
                false,
                false));
    }
}