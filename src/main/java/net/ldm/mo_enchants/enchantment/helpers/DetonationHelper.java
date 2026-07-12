package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.LevelAccessor;

public class DetonationHelper {
	public static void execute(LevelAccessor world, BlockPos pos, Entity sourceEntity ) {
		if (sourceEntity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.DETONATION.get(),
				(sourceEntity instanceof LivingEntity livEnt ? livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3, ExplosionInteraction.NONE);
		}
	}
}
