package net.ldm.mo_enchants.loot.condition;

import net.ldm.mo_enchants.MoEnchants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * @author Logan Dhillon
 */
public class ModLootItemConditions {
    public static final DeferredRegister<LootItemConditionType> REGISTRY =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MoEnchants.MOD_ID);

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> RANDOM_CHANCE =
            REGISTRY.register("random_chance", () -> new LootItemConditionType(RandomChanceCondition.CODEC));


}
