package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags.Blocks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RockMendingHelper {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        ItemStack stack = event.getPlayer().getMainHandItem();
        int level = stack.getEnchantmentLevel(MoEnchantsEnchantments.ROCK_MENDING.get());
        BlockState state = event.getState();

        if (level < 1 || state.is(Blocks.STONE) || stack.getDamageValue() >= stack.getMaxDamage()) return;

        if (!(Math.random() * 10 < level * 2)) return;

        if (stack.hurt(-1, RandomSource.create(), null)) {
            stack.shrink(1);
            stack.setDamageValue(0);
        }
    }
}