package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.loot.SmeltingTouchLootModifier;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries, MoEnchants.MOD_ID);
    }

    @Override
    protected void start() {
        add("smelting_touch", new SmeltingTouchLootModifier(new LootItemCondition[]{}));
    }
}
