package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.block.LiquefyingMagmaBlock;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MoEnchants.MOD_ID);

    public static final Holder<Block> LIQUEFYING_MAGMA_BLOCK = REGISTRY.register(
            "liquefying_magma_block", LiquefyingMagmaBlock::new);
}
