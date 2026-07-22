package net.ldm.mo_enchants;

import net.ldm.mo_enchants.init.ModBlocks;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModItems;
import net.ldm.mo_enchants.init.ModLootModifiers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("mo_enchants")
public class MoEnchants {
    public static final String MOD_ID = "mo_enchants";

    public MoEnchants(IEventBus bus) {
        ModBlocks.REGISTRY.register(bus);
        ModItems.REGISTRY.register(bus);
        ModEnchantments.ENCHANTMENTS.register(bus);
        ModLootModifiers.REGISTRY.register(bus);
    }

    public static ResourceLocation modResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
