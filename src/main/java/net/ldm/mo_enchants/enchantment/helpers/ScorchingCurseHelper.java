package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class ScorchingCurseHelper {
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (EnchantmentUtils.hasArmorEnchantment(event.getEntity(), MoEnchantsEnchantments.SCORCHING_CURSE.get())) {
			event.getEntity().setSecondsOnFire(5);
		}
	}
}