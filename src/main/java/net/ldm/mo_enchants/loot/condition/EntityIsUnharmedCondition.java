package net.ldm.mo_enchants.loot.condition;

import com.mojang.serialization.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

import java.util.stream.Stream;

/**
 * @author Logan Dhillon
 */
public class EntityIsUnharmedCondition implements LootItemCondition {
    public static final MapCodec<EntityIsUnharmedCondition> CODEC = new MapCodec<>() {
        @Override
        public <T> DataResult<EntityIsUnharmedCondition> decode(DynamicOps<T> ops, MapLike<T> input) {
            return DataResult.success(new EntityIsUnharmedCondition());
        }

        @Override
        public <T> RecordBuilder<T> encode(EntityIsUnharmedCondition value, DynamicOps<T> ops,
                                           RecordBuilder<T> prefix) {
            return prefix;
        }

        @Override
        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.empty();
        }
    };

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.ENTITY_IS_UNHARMED.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        if (!(lootContext.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof LivingEntity entity)) return false;
        return entity.getHealth() >= entity.getMaxHealth();
    }
}
