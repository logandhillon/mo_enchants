package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoEnchants.MOD_ID)
public class BadDreamsCurseHelper {
    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event) {
        Player player = event.getEntity();

        if (EnchantmentHelper.getTagEnchantmentLevel(
                ModEnchantments.INSOMNIA_CURSE.get(),
                player.getItemBySlot(EquipmentSlot.HEAD)) != 0) {
            player.hurt(ModDamageSources.of(ModDamageSources.BAD_DREAMS, player), Float.MAX_VALUE);
        }
    }
}
