package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.ModLootModifiers;
import net.ldm.mo_enchants.loot.SmeltingTouchLootModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

/**
 * @author Logan Dhillon
 */
public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output) {
        super(output, MoEnchantsMod.MOD_ID);
    }

    @Override
    protected void start() {
        assert ModLootModifiers.SMELTING_TOUCH.getId() != null;
        add(ModLootModifiers.SMELTING_TOUCH.getId().getPath(), new SmeltingTouchLootModifier(new LootItemCondition[]{}));
    }
}
