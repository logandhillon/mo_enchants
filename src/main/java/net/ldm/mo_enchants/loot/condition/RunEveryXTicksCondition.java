package net.ldm.mo_enchants.loot.condition;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

import java.util.Objects;

/**
 * @author Logan Dhillon
 */
public class RunEveryXTicksCondition implements LootItemCondition {
    public static final MapCodec<RunEveryXTicksCondition> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst
                    .group(LevelBasedValue.CODEC.fieldOf("tickRate").forGetter(c -> c.tickRate))
                    .apply(inst, RunEveryXTicksCondition::new));

    private final LevelBasedValue tickRate;

    public RunEveryXTicksCondition(LevelBasedValue tickRate) {
        this.tickRate = tickRate;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.RUN_EVERY_X_TICKS.get();
    }

    @Override
    public boolean test(LootContext context) {
        return Objects.requireNonNull(context.getParamOrNull(LootContextParams.THIS_ENTITY)).tickCount %
               tickRate.calculate(context.getParam(LootContextParams.ENCHANTMENT_LEVEL)) == 0;
    }

    public static Builder of(LevelBasedValue chance) {
        return () -> new RunEveryXTicksCondition(chance);
    }
}
