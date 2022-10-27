package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class LifeforceDischargeCurseHelper {
	public static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.lifeforce_discharge").bypassArmor(), 2);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.lifeforce_discharge").bypassArmor(), 3);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 3));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.lifeforce_discharge").bypassArmor(), 4);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 4));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 4) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.lifeforce_discharge").bypassArmor(), 5);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 5));
		}
	}
}