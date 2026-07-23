package net.ldm.mo_enchants.datagen.tag;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public ModEnchantmentTagsProvider(PackOutput pOutput,
                                      CompletableFuture<Provider> pProvider,
                                      @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MoEnchants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        ModEnchantments.TAGS.forEach(tag -> {
            if (tag.isCurse()) tag(EnchantmentTags.CURSE).addOptional(tag.key().location());
            if (tag.isTradeable()) tag(EnchantmentTags.TRADEABLE).addOptional(tag.key().location());

            if (tag.isTreasureOnly()) tag(EnchantmentTags.TREASURE).addOptional(tag.key().location());
            else tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(tag.key().location());
        });

        tag(EnchantmentTags.ARMOR_EXCLUSIVE);
    }
}
