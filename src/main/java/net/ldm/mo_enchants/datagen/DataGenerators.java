package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles the data generation step in the mods bundle packaging
 *
 * @author Logan Dhillon
 */
@Mod.EventBusSubscriber(modid = MoEnchantsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput pack = gen.getPackOutput();

        gen.addProvider(event.includeClient(), new LangProvider(pack));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(pack, event.getExistingFileHelper()));


    }
}
