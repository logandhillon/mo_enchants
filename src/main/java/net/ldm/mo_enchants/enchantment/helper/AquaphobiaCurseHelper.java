package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModDamageSources;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class AquaphobiaCurseHelper {
    @SubscribeEvent
    public static void onPlayerTickClient(PlayerTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide
            || !event.getEntity().isInWater()
            || !EnchantmentUtils.hasArmorEnchantment(event.getEntity(), ModEnchantments.AQUAPHOBIA_CURSE)) {
            return;
        }

        if (event.getEntity().tickCount % 10 == 0) {
            event.getEntity().hurt(ModDamageSources.of(ModDamageSources.AQUAPHOBIA, event.getEntity()), 1);
        }
    }
}
