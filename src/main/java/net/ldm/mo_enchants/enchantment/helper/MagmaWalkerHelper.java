package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModBlocks;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * @author Logan Dhillon
 */
@EventBusSubscriber
public class MagmaWalkerHelper {
    @SubscribeEvent
    public static void onLivingTick(PlayerTickEvent.Post event) {
        LivingEntity entity = event.getEntity();
        if (!entity.onGround()) return;

        int enchLevel = entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(entity.level().holderOrThrow(ModEnchantments.MAGMA_WALKER));
        if (enchLevel < 1) return;

        BlockPos entityPos = entity.blockPosition();
        Level level = entity.level();

        BlockState magma = ModBlocks.LIQUEFYING_MAGMA_BLOCK.value().defaultBlockState();
        int i = Math.min(16, 2 + enchLevel);
        MutableBlockPos checkedPos = new MutableBlockPos();

        for (BlockPos pos: BlockPos.betweenClosed(entityPos.offset(-i, -1, -i), entityPos.offset(i, -1, i))) {
            if (pos.closerToCenterThan(entity.position(), i)) {
                checkedPos.set(pos.getX(), pos.getY() + 1, pos.getZ());

                if (!level.getBlockState(checkedPos).isAir()) continue;

                BlockState block = level.getBlockState(pos);
                if (block.is(Blocks.LAVA) && magma.canSurvive(level, pos) &&
                    level.isUnobstructed(magma, pos, CollisionContext.empty())) {
                    level.setBlockAndUpdate(pos, magma);
                }
            }
        }
    }
}
