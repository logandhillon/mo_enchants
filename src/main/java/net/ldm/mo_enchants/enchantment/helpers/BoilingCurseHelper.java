package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class BoilingCurseHelper {
    public static void onPlayerTick(PlayerTickEvent event) {
        Holder<Biome> biome = event.player.level().getBiome(event.player.blockPosition());

        if ((biome.is(Tags.Biomes.IS_HOT) || event.player.level().dimension() == Level.NETHER)
            && EnchantmentUtils.hasArmorEnchantment(event.player, MoEnchantsEnchantments.BOILING_CURSE.get())) {
            event.player.setSecondsOnFire(3);
        }
    }
}
