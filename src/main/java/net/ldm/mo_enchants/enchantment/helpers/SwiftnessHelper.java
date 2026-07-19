package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class SwiftnessHelper {
    private static final UUID SWIFTNESS_UUID = UUID.fromString("7a738a54-6d1f-423d-ba6d-282c405c46ea");

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!event.getSlot().equals(EquipmentSlot.FEET)) return;

        AttributeInstance speed = event.getEntity().getAttributes().getInstance(Attributes.MOVEMENT_SPEED);
        if (speed == null) return;

        if (speed.getModifier(SWIFTNESS_UUID) != null) {
            speed.removePermanentModifier(SWIFTNESS_UUID);
        }

        int level = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.WEIGHTLESS.get());
        if (level <= 0) return;

        speed.addPermanentModifier(new AttributeModifier(
                SWIFTNESS_UUID,
                "mo_enchants:swiftness",
                0.01 * level,
                Operation.ADDITION
        ));
    }
}
