package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class ReachHelper {
    private static final UUID REACH_UUID = UUID.fromString("9964fc09-999f-47a5-bf38-76f714fb447c");

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!event.getSlot().equals(EquipmentSlot.MAINHAND)) return;

        AttributeInstance reach = event.getEntity().getAttributes().getInstance(ForgeMod.BLOCK_REACH.get());
        if (reach == null) return;

        if (reach.getModifier(REACH_UUID) != null) {
            reach.removePermanentModifier(REACH_UUID);
        }

        int level = event.getTo().getEnchantmentLevel(MoEnchantsEnchantments.WEIGHTLESS.get());
        if (level <= 0) return;

        reach.addPermanentModifier(new AttributeModifier(
                REACH_UUID,
                "mo_enchants:reach",
                level,
                Operation.ADDITION
        ));
    }
}