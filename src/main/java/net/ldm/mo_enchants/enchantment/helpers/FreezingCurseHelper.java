package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class FreezingCurseHelper {
    public static void onPlayerTick(PlayerTickEvent event) {
        Holder<Biome> biome = event.player.level().getBiome(event.player.blockPosition());

        if ((biome.is(Tags.Biomes.IS_COLD))
            && EnchantmentUtils.hasArmorEnchantment(event.player, MoEnchantsEnchantments.FREEZING_CURSE.get())) {
            event.player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1, false, false));
        }
    }
}