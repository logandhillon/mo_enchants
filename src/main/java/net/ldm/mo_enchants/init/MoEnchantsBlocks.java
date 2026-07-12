package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.block.LiquefyingMagmaBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MoEnchantsBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MoEnchantsMod.MOD_ID);
	public static final RegistryObject<Block> LIQUEFYING_MAGMA_BLOCK = REGISTRY.register("liquefying_magma_block", LiquefyingMagmaBlock::new);
}
