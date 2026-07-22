package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * @author Logan Dhillon
 */
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoEnchants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.LIQUEFYING_MAGMA_BLOCK.value(), cubeAll(ModBlocks.LIQUEFYING_MAGMA_BLOCK.value()));
    }
}
