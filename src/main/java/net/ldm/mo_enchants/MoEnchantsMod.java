package net.ldm.mo_enchants;

import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.MoEnchantsItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mo_enchants")
public class MoEnchantsMod {
    public static final String MOD_ID = "mo_enchants";

    public MoEnchantsMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MoEnchantsBlocks.REGISTRY.register(bus);
        MoEnchantsItems.REGISTRY.register(bus);

        MoEnchantsEnchantments.REGISTRY.register(bus);
    }
}
