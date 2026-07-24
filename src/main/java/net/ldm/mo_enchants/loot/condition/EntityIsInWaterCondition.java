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
public class EntityIsInWaterCondition implements LootItemCondition {
    public static final MapCodec<EntityIsInWaterCondition> CODEC = new MapCodec<>() {
        @Override
        public <T> DataResult<EntityIsInWaterCondition> decode(DynamicOps<T> ops, MapLike<T> input) {
            return DataResult.success(new EntityIsInWaterCondition());
        }

        @Override
        public <T> RecordBuilder<T> encode(EntityIsInWaterCondition value, DynamicOps<T> ops, RecordBuilder<T> prefix) {
            return prefix;
        }

        @Override
        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.empty();
        }
    };

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.ENTITY_IS_IN_WATER.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        var entity = lootContext.getParamOrNull(LootContextParams.THIS_ENTITY);
        return entity != null && entity.isInWater();
    }
}
