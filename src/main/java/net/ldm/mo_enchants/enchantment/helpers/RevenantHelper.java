package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class RevenantHelper {
	public static void execute(Entity victim, Entity attacker) {
		if (victim == null || attacker == null)
			return;

		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(), (attacker instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (victim instanceof LivingEntity _livEnt && _livEnt.getMobType() == MobType.UNDEAD)
				&& !victim.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("mo_enchants","bosses")))) {
			if (Math.round(Math.random() * 100) < EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(),
					_livEnt.getMainHandItem()) + 1) {
                victim.hurt(victim.damageSources().genericKill(), _livEnt.getHealth());
			}
		}
	}
}