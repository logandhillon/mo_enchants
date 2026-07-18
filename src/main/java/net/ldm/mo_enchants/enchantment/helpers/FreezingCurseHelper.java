package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;

public class FreezingCurseHelper {
	public static void onPlayerTick(LevelAccessor world, BlockPos pos, Player entity) {
		if (entity == null)
			return;
		Holder<Biome> biome = world.getBiome(pos);
		if (biome.is(Tags.Biomes.IS_COLD)
				&& ((EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.HEAD)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.CHEST)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.LEGS)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.FEET)) >= 1))) {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1, false, false));
		}
	}
}