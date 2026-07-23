package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.datagen.datapack.ModDamageTypeProvider;
import net.ldm.mo_enchants.datagen.tag.*;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

/**
 * Handles the data generation step in the mods bundle packaging
 *
 * @author Logan Dhillon
 */
@EventBusSubscriber(modid = MoEnchants.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput pack = gen.getPackOutput();
        var lookup = event.getLookupProvider();
        var existingFiles = event.getExistingFileHelper();

        // client side data
        gen.addProvider(event.includeClient(), new ModLangProvider(pack));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(pack, existingFiles));

        // server side data
        gen.addProvider(event.includeServer(), new ModLootModifierProvider(pack, lookup));

        // datapack
        gen.addProvider(
                event.includeServer(), new DatapackBuiltinEntriesProvider(
                        pack, lookup,
                        new RegistrySetBuilder()
                                .add(Registries.DAMAGE_TYPE, new ModDamageTypeProvider()::bootstrap)
                                .add(Registries.ENCHANTMENT, new ModEnchantments()::bootstrap),
                        Set.of(MoEnchants.MOD_ID)
                ));

        // tags
        gen.addProvider(
                event.includeServer(),
                new ModEntityTypeTagsProvider(pack, lookup, existingFiles));
        var blockTags = new ModBlockTagsProvider(pack, lookup, existingFiles);
        gen.addProvider(
                event.includeServer(), blockTags);
        gen.addProvider(
                event.includeServer(),
                new ModDamageTypeTagsProvider(pack, lookup, existingFiles));
        gen.addProvider(
                event.includeServer(),
                new ModEnchantmentTagsProvider(pack, lookup, existingFiles));
        gen.addProvider(
                event.includeServer(),
                new ModItemTagsProvider(pack, lookup, blockTags, existingFiles));
    }
}
