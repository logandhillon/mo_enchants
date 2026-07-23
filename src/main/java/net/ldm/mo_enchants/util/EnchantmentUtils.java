package net.ldm.mo_enchants.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

/**
 * @author Logan Dhillon
 */
public class EnchantmentUtils {
    public static boolean hasArmorEnchantment(LivingEntity entity, ResourceKey<Enchantment> enchantment) {
        Holder<Enchantment> ench = entity.level().registryAccess().holderOrThrow(enchantment);

        for (EquipmentSlot slot: new EquipmentSlot[]{
                EquipmentSlot.HEAD,
                EquipmentSlot.CHEST,
                EquipmentSlot.LEGS,
                EquipmentSlot.FEET
        }) {
            if (entity.getItemBySlot(slot).getEnchantmentLevel(ench) > 0) {
                return true;
            }
        }
        return false;
    }
}
