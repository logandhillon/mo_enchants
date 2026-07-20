package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModBlocks;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;

public class MagmaWalkerEnchantment extends Enchantment {
    public MagmaWalkerEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return super.checkCompatibility(ench) && ench != Enchantments.FROST_WALKER;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    public static void onLivingTick(LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.onGround()) return;

        int enchLevel = entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(
                ModEnchantments.MAGMA_WALKER.get());
        if (enchLevel < 1) return;

        BlockPos entityPos = entity.blockPosition();
        Level level = entity.level();

        BlockState magma = ModBlocks.LIQUEFYING_MAGMA_BLOCK.get().defaultBlockState();
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
