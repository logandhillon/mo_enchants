package net.ldm.mo_enchants.loot.condition;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

/**
 * @author Logan Dhillon
 */
public class HealthBelowThresholdCondition implements LootItemCondition {
    public static final MapCodec<HealthBelowThresholdCondition> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst
                    .group(LevelBasedValue.CODEC.fieldOf("threshold").forGetter(c -> c.threshold))
                    .apply(inst, HealthBelowThresholdCondition::new));

    private final LevelBasedValue threshold;

    public HealthBelowThresholdCondition(LevelBasedValue threshold) {
        this.threshold = threshold;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.HEALTH_BELOW_THRESHOLD.get();
    }

    @Override
    public boolean test(LootContext context) {
        if (!(context.getParamOrNull(LootContextParams.THIS_ENTITY) instanceof LivingEntity entity)) return false;

        return entity.getHealth() <= this.threshold.calculate(context.getParam(LootContextParams.ENCHANTMENT_LEVEL));
    }

    public static Builder of(LevelBasedValue threshold) {
        return () -> new HealthBelowThresholdCondition(threshold);
    }
}
