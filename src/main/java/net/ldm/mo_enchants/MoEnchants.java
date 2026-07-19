package net.ldm.mo_enchants;

import net.ldm.mo_enchants.init.ModBlocks;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModItems;
import net.ldm.mo_enchants.init.ModLootModifiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mo_enchants")
public class MoEnchants {
    public static final String MOD_ID = "mo_enchants";

    public MoEnchants(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        ModBlocks.REGISTRY.register(bus);
        ModItems.REGISTRY.register(bus);
        ModEnchantments.ENCHANTMENTS.register(bus);
        ModLootModifiers.LOOT_MODIFIERS.register(bus);
    }

    public static ResourceLocation modResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
