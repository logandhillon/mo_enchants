package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class WeightlessHelper {
    private static final UUID WEIGHTLESS_UUID = UUID.fromString("2af7cbaa-5fbe-4e0b-99e0-b73c60da33d7");

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!event.getSlot().equals(EquipmentSlot.LEGS)) return;

        AttributeInstance gravity = event.getEntity().getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());
        if (gravity == null) return;

        if (gravity.getModifier(WEIGHTLESS_UUID) != null) {
            gravity.removePermanentModifier(WEIGHTLESS_UUID);
        }

        int level = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.WEIGHTLESS.get());
        if (level <= 0) return;

        gravity.addPermanentModifier(new AttributeModifier(
                WEIGHTLESS_UUID,
                "mo_enchants:weightless",
                -0.01 * level,
                Operation.ADDITION
        ));
    }
}
