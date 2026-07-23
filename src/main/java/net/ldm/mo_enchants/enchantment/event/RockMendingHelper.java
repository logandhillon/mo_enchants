package net.ldm.mo_enchants.enchantment.event;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber
public class RockMendingHelper {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        ItemStack stack = event.getPlayer().getMainHandItem();
        int level = stack.getEnchantmentLevel(event.getLevel().holderOrThrow(ModEnchantments.ROCK_MENDING));
        BlockState state = event.getState();

        if (level < 1 || state.is(Blocks.STONE) || stack.getDamageValue() >= stack.getMaxDamage()) return;

        if (!(Math.random() * 10 < level * 2)) return;

        stack.hurtAndBreak(-1, event.getPlayer(), EquipmentSlot.MAINHAND);
    }
}