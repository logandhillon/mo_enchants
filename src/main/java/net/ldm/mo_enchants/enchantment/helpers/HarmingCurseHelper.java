package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class HarmingCurseHelper {
    public static void onEntityAttacked(LivingHurtEvent event, LivingEntity attacker) {
        if (attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.HARMING_CURSE.get()) > 0) {
            attacker.hurt(ModDamageSources.of(ModDamageSources.HARMING_CURSE, attacker), event.getAmount() / 2f);
        }
    }
}