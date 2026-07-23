package net.ldm.mo_enchants.loot.condition;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

/**
 * @author Logan Dhillon
 */
public class RandomChanceCondition implements LootItemCondition {
    public static final MapCodec<RandomChanceCondition> CODEC = RecordCodecBuilder.mapCodec(
            inst -> inst
                    .group(LevelBasedValue.CODEC.fieldOf("chance").forGetter(c -> c.chance))
                    .apply(inst, RandomChanceCondition::new));

    private final LevelBasedValue chance;

    public RandomChanceCondition(LevelBasedValue chance) {
        this.chance = chance;
    }

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.RANDOM_CHANCE.get();
    }

    @Override
    public boolean test(LootContext context) {
        int level = context.getParam(LootContextParams.ENCHANTMENT_LEVEL);
        float chanceValue = chance.calculate(level);

        return context.getRandom().nextFloat() < chanceValue;
    }

    public static LootItemCondition.Builder of(LevelBasedValue chance) {
        return () -> new RandomChanceCondition(chance);
    }
}
