package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoEnchantsMod.MOD_ID)
public class BadDreamsCurseHelper {
    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();

        if (EnchantmentHelper.getTagEnchantmentLevel(
                MoEnchantsEnchantments.BAD_DREAMS_CURSE.get(),
                player.getItemBySlot(EquipmentSlot.HEAD)) != 0) {
            player.hurt(ModDamageSources.badDreams(player), player.getMaxHealth());
        }
    }
}
