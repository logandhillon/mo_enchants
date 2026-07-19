package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.enchantment.AttributeModifierEnchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * @author Logan Dhillon
 */
@EventBusSubscriber
public class AttributeModifierHelper {
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        ItemStack stack = event.getTo();

        for (Enchantment enchantment: stack.getAllEnchantments().keySet()) {
            if (!(enchantment instanceof AttributeModifierEnchantment modifier)) continue;

            modifier.updateAttribute(event);
        }
    }
}
