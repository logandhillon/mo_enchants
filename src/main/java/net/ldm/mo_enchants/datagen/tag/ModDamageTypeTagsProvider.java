package net.ldm.mo_enchants.datagen.tag;

import net.ldm.mo_enchants.MoEnchants;
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
    public ModDamageTypeTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
                                     @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, MoEnchants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        // optional as datapacks don't register lookups
        tag(DamageTypeTags.BYPASSES_ARMOR)
                .addOptional(ModDamageSources.AQUAPHOBIA.location())
                .addOptional(ModDamageSources.BAD_DREAMS.location())
                .addOptional(ModDamageSources.BLOODTHIRST.location())
                .addOptional(ModDamageSources.FREEZING.location())
                .addOptional(ModDamageSources.GENERIC_CURSE.location())
                .addOptional(ModDamageSources.HARMING_CURSE.location())
                .addOptional(ModDamageSources.LIFEFORCE_DISCHARGE.location());

        tag(DamageTypeTags.IS_FREEZING)
                .addOptional(ModDamageSources.FREEZING.location());
    }
}
