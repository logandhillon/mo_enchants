package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.datagen.tag.ModBlockTagsProvider;
import net.ldm.mo_enchants.datagen.tag.ModDamageTypeTagsProvider;
import net.ldm.mo_enchants.datagen.tag.ModEntityTypeTagsProvider;
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
        gen.addProvider(
                event.includeServer(), new DatapackBuiltinEntriesProvider(
                        pack, lookup,
                        new RegistrySetBuilder()
                                .add(Registries.DAMAGE_TYPE, ModDamageTypeProvider::bootstrap),
                        Set.of(MoEnchants.MOD_ID)
                ));

        // tags
        gen.addProvider(
                event.includeServer(),
                new ModEntityTypeTagsProvider(pack, lookup, existingFiles));
        gen.addProvider(
                event.includeServer(),
                new ModBlockTagsProvider(pack, lookup, existingFiles));
        gen.addProvider(
                event.includeServer(),
                new ModDamageTypeTagsProvider(pack, lookup, existingFiles));
    }
}
