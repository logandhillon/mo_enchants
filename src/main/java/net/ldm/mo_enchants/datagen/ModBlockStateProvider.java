package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * @author Logan Dhillon
 */
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoEnchantsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get(), cubeAll(MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get()));
    }
}
