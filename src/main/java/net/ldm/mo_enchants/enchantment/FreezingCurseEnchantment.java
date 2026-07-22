package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class FreezingCurseEnchantment extends Enchantment {
    public FreezingCurseEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, slots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onPlayerTickClient(PlayerTickEvent event) {
        Holder<Biome> biome = event.player.level().getBiome(event.player.blockPosition());

        if ((biome.is(Tags.Biomes.IS_COLD))
            && EnchantmentUtils.hasArmorEnchantment(event.player, ModEnchantments.FREEZING_CURSE.get())) {
            event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1, false, false));
        }
    }
}
