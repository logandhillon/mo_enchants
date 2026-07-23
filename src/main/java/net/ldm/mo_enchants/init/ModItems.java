package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchants;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MoEnchants.MOD_ID);

    public static final Holder<Item> LIQUEFYING_MAGMA_BLOCK = REGISTRY.registerSimpleBlockItem(
            ModBlocks.LIQUEFYING_MAGMA_BLOCK);
}
