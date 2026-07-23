package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;

@EventBusSubscriber(modid = MoEnchants.MOD_ID)
public class BadDreamsCurseHelper {
    @SubscribeEvent
    public static void onPlayerSleep(CanPlayerSleepEvent event) {
        Player player = event.getEntity();

        if (player.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(
                player.level().holderOrThrow(ModEnchantments.INSOMNIA_CURSE)) != 0) {
            player.hurt(ModDamageSources.of(ModDamageSources.BAD_DREAMS, player), Float.MAX_VALUE);
        }
    }
}
