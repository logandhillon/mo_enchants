package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.LivingEntity;

public class LifeforceDischargeCurseHelper {
    public static void onEntityAttacked(LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(
                MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get());
        if (level < 1) return;

        attacker.hurt(ModDamageSources.of(ModDamageSources.LIFEFORCE_DISCHARGE, attacker), 1 + level);
    }
}