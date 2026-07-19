package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CarefulEnchantmentHelper {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer().getMainHandItem().getEnchantmentLevel(ModEnchantments.CAREFUL.get()) > 0
            && event.getState().is(BlockTags.CROPS)
            && event.getState().getValue(CropBlock.AGE) <= 6
        ) {
            event.setCanceled(true);
        }
    }
}