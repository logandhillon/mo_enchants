package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;

public class RevenantHelper {
    public static void onEntityAttacked(LivingEntity victim, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get());

        if (level < 1
            || victim.getMobType() != MobType.UNDEAD
            || victim.getType().is(ModTags.BOSSES)) {
            return;
        }

        if (Math.random() * 100 < level + 1) {
            victim.hurt(victim.damageSources().mobAttack(attacker), Float.MAX_VALUE);
        }
    }
}