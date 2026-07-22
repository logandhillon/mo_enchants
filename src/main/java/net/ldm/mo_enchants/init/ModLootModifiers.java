package net.ldm.mo_enchants.init;

import com.mojang.serialization.MapCodec;
import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.loot.SmeltingTouchLootModifier;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

/**
 * @author Logan Dhillon
 */
public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> REGISTRY = DeferredRegister.create(
            Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
            MoEnchants.MOD_ID);

    public static final Holder<MapCodec<? extends IGlobalLootModifier>> SMELTING_TOUCH =
            REGISTRY.register("smelting_touch", () -> SmeltingTouchLootModifier.CODEC);
}
