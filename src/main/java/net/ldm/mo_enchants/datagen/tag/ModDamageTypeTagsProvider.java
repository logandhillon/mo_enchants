package net.ldm.mo_enchants.datagen.tag;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModDamageTypeTagsProvider extends DamageTypeTagsProvider {
    public ModDamageTypeTagsProvider(PackOutput pOutput,
                                     CompletableFuture<Provider> pLookupProvider,
                                     @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, MoEnchantsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        tag(DamageTypeTags.BYPASSES_ARMOR)
                .addOptional(ModDamageSources.BAD_DREAMS.location()); // optional as datapacks don't register lookups
    }
}
