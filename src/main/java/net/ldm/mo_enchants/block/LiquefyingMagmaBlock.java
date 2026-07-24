
package net.ldm.mo_enchants.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

public class LiquefyingMagmaBlock extends Block {
    public LiquefyingMagmaBlock() {
        super(Properties.of()
                        .mapColor(MapColor.NETHER)
                        .sound(SoundType.STONE)
                        .strength(0.5f)
                        .lightLevel(s -> 5)
                        .requiresCorrectToolForDrops()
                        .hasPostProcess((bs, br, bp) -> true)
                        .emissiveRendering((bs, br, bp) -> true)
                        .noLootTable());
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos,
                                       Player player) {
        return new ItemStack(Blocks.MAGMA_BLOCK);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        added(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level level, BlockPos pos, Player entity,
                                       boolean willHarvest, FluidState fluid) {
        boolean returnValue = super.onDestroyedByPlayer(blockstate, level, pos, entity, willHarvest, fluid);
        removed(level, pos.getX(), pos.getY(), pos.getZ());
        return returnValue;
    }

    private static void added(Level level, int x, int y, int z) {
        if (!level.isClientSide()) {
            level.playSound(
                    null, new BlockPos(x, y, z), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, (float)0.6,
                    1);
        }

        new Object() {
            private int   ticks = 0;
            private float waitTicks;
            private Level level;

            public void start(Level level, int waitTicks) {
                this.waitTicks = waitTicks;
                NeoForge.EVENT_BUS.register(this);
                this.level = level;
            }

            @SubscribeEvent
            public void tick(ServerTickEvent.Post event) {
                this.ticks += 1;
                if (this.ticks >= this.waitTicks) run();
            }

            private void run() {
                level.setBlock(new BlockPos(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
                if (!level.isClientSide()) {
                    level.playSound(
                            null, new BlockPos(x, y, z), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, (float)0.6,
                            1);
                }
                NeoForge.EVENT_BUS.unregister(this);
            }
        }.start(level, 80);
    }

    private static void removed(Level level, int x, int y, int z) {
        level.setBlock(new BlockPos(x, y, z), Blocks.LAVA.defaultBlockState(), 3);
        if (!level.isClientSide()) {
            level.playSound(
                    null, new BlockPos(x, y, z), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, (float)0.6, 1);
        }
    }
}
