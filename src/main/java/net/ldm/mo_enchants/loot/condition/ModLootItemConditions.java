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

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> ENTITY_IS_ANIMAL =
            REGISTRY.register("entity_is_animal", () -> new LootItemConditionType(EntityIsAnimalCondition.CODEC));

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> ENTITY_IS_UNHARMED =
            REGISTRY.register("entity_is_unharmed", () -> new LootItemConditionType(EntityIsUnharmedCondition.CODEC));

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> HEALTH_BELOW_THRESHOLD =
            REGISTRY.register("health_below_threshold", () -> new LootItemConditionType(HealthBelowThresholdCondition.CODEC));

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> ENTITY_IS_IN_WATER =
            REGISTRY.register("entity_is_in_water", () -> new LootItemConditionType(EntityIsInWaterCondition.CODEC));

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> RUN_EVERY_X_TICKS =
            REGISTRY.register("run_every_x_ticks", () -> new LootItemConditionType(RunEveryXTicksCondition.CODEC));
}
