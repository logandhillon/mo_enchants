package net.ldm.mo_enchants.enchantment.event;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Player.BedSleepingProblem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;

@EventBusSubscriber(modid = MoEnchants.MOD_ID)
public class InsomniaCurseHelper {
    @SubscribeEvent
    public static void onPlayerSleep(CanPlayerSleepEvent event) {
        Player player = event.getEntity();

        if (player.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(
                player.level().holderOrThrow(ModEnchantments.INSOMNIA_CURSE)) != 0) {
            event.setProblem(BedSleepingProblem.OTHER_PROBLEM);
            player.displayClientMessage(Component.translatable("message.mo_enchants.insomnia_curse"), true);
        }
    }
}
