package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput pOutput,
                                CompletableFuture<Provider> pProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MoEnchantsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get());
    }
}
