package net.ldm.mo_enchants.loot.condition;

import com.mojang.serialization.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

import java.util.stream.Stream;

/**
 * @author Logan Dhillon
 */
public class EntityIsAnimalCondition implements LootItemCondition {
    public static final MapCodec<EntityIsAnimalCondition> CODEC = new MapCodec<>() {
        @Override
        public <T> DataResult<EntityIsAnimalCondition> decode(DynamicOps<T> ops, MapLike<T> input) {
            return DataResult.success(new EntityIsAnimalCondition());
        }

        @Override
        public <T> RecordBuilder<T> encode(EntityIsAnimalCondition value, DynamicOps<T> ops, RecordBuilder<T> prefix) {
            return prefix;
        }

        @Override
        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.empty();
        }
    };

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.ENTITY_IS_ANIMAL.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        return lootContext.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof Animal;
    }
}
