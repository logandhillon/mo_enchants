package net.ldm.mo_enchants.init;

import com.mojang.serialization.Codec;
import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.loot.SmeltingTouchLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Logan Dhillon
 */
public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(
            Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
            MoEnchants.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SMELTING_TOUCH =
            LOOT_MODIFIERS.register("smelting_touch", () -> SmeltingTouchLootModifier.CODEC);
}
