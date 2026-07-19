package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.LivingEntity;

public class LifeStealHelper {
    public static void onEntityAttacked(LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.LIFE_STEAL.get());
        if (level < 1 || Math.random() < level / 10f) return;

        attacker.setHealth(attacker.getHealth() + 1 + level);
    }
}