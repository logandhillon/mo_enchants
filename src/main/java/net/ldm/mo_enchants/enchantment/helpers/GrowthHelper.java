package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class GrowthHelper {
    private static final UUID GROWTH_UUID = UUID.fromString("4ff57341-51ff-4b44-a528-d667d28e6842");

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!event.getSlot().equals(EquipmentSlot.MAINHAND)) return;

        AttributeInstance growth = event.getEntity().getAttributes().getInstance(Attributes.MAX_HEALTH);
        if (growth == null) return;

        if (growth.getModifier(GROWTH_UUID) != null) {
            growth.removePermanentModifier(GROWTH_UUID);
        }

        int level = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.GROWTH.get());
        if (level <= 0) return;

        growth.addPermanentModifier(new AttributeModifier(
                GROWTH_UUID,
                "mo_enchants:growth",
                level,
                AttributeModifier.Operation.ADDITION
        ));
    }
}