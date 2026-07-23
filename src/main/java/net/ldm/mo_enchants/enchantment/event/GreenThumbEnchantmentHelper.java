package net.ldm.mo_enchants.enchantment.event;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber
public class GreenThumbEnchantmentHelper {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer().getMainHandItem().getEnchantmentLevel(event.getPlayer().level().holderOrThrow(ModEnchantments.GREEN_THUMB)) > 0
            && event.getState().is(BlockTags.CROPS)
            && event.getState().getValue(CropBlock.AGE) <= 6
        ) {
            event.setCanceled(true);
        }
    }
}