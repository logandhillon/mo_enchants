package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class DensityCurseHelper {
    private static final UUID DENSITY_UUID = UUID.fromString("703bede5-84db-4991-bbe9-3ac943c68fff");

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!(event.getSlot().equals(EquipmentSlot.HEAD) || event.getSlot().equals(EquipmentSlot.CHEST) ||
              event.getSlot().equals(EquipmentSlot.LEGS) || event.getSlot().equals(EquipmentSlot.FEET))) return;

        AttributeInstance gravity = event.getEntity().getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());
        if (gravity == null) return;

        if (gravity.getModifier(DENSITY_UUID) != null) {
            gravity.removePermanentModifier(DENSITY_UUID);
        }

        int level = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.DENSITY_CURSE.get());
        if (level <= 0) return;

        gravity.addPermanentModifier(new AttributeModifier(
                DENSITY_UUID,
                "mo_enchants:density_curse",
                0.025 * level,
                Operation.ADDITION
        ));
    }
}
