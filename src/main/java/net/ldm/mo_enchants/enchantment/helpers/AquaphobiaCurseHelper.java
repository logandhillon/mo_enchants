package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class AquaphobiaCurseHelper {
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.side.isClient() || event.player == null || !event.player.isInWater() ||
            !EnchantmentUtils.hasArmorEnchantment(
                    event.player, MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get())) {
            return;
        }

        if (event.player.tickCount % 10 == 0) {
            event.player.hurt(ModDamageSources.of(ModDamageSources.AQUAPHOBIA, event.player), 1);
        }
    }
}
