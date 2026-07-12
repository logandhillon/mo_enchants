package net.ldm.mo_enchants.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.ldm.mo_enchants.MoEnchantsMod;

public class MoEnchantsItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MoEnchantsMod.MOD_ID);
	public static final RegistryObject<Item> LIQUEFYING_MAGMA_BLOCK = block(MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
