package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;

public class AquaphobiaCurseHelper {
	public static void execute( LevelAccessor world, BlockPos pos, Entity entity) {
		if (entity == null) return;
		if (((world.getBlockState(pos)).getBlock() instanceof LiquidBlock _liquid
				? new ItemStack(_liquid.getFluid().getBucket())
				: ItemStack.EMPTY).getItem() == Items.WATER_BUCKET
				&& (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
						: ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
						: ItemStack.EMPTY)) != 0)) {

			if (entity.level().getGameTime() - entity.getPersistentData().getLong("aquaphobiaDamageTriggerTime")
					> 10) {
				entity.getPersistentData().putLong("aquaphobiaDamageTriggerTime", entity.level().getGameTime());
				if (entity instanceof LivingEntity _entity) {
                    // TODO: damage sources
//                    _entity.hurt(new DamageSource("curse.aquaphobia").bypassArmor(), 1);
                }
			}
		}
	}
}
