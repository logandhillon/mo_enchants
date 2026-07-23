package net.ldm.mo_enchants.datagen.tag;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pOutput,
                               CompletableFuture<Provider> pProvider,
                               ModBlockTagsProvider pBlockTagsProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, pBlockTagsProvider.contentsGetter(), MoEnchants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        tag(ModTags.TOTEM_OF_UNDYING).add(Items.TOTEM_OF_UNDYING);
    }
}
