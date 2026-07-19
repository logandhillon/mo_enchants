package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class ToxicAspectHelper {
    public static void onEntityAttacked(LivingEntity victim, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.VENOMFANG.get());
        victim.addEffect(new MobEffectInstance(MobEffects.POISON, 50 * (level + 1), level - 1, false, false));
    }
}
