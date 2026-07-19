package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

public class NightVisionHelper {
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getSlot() != EquipmentSlot.HEAD || !(event.getEntity() instanceof Player player)) return;

        boolean hadNightVision = event.getFrom().getEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get()) > 0;
        boolean hasNightVision = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get()) > 0;

        if (hasNightVision == hadNightVision) {
            return;
        }

        if (hasNightVision) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false, false));
        } else {
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }
}