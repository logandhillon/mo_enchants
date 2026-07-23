package net.ldm.mo_enchants.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

/**
 * @author Logan Dhillon
 */
public class HealEntity implements EnchantmentEntityEffect {
    public static final MapCodec<HealEntity> CODEC = RecordCodecBuilder.mapCodec(
            inst ->
                    inst.group(LevelBasedValue.CODEC.fieldOf("amount").forGetter(effect -> effect.amount))
                        .apply(inst, HealEntity::new));

    private final LevelBasedValue amount;

    public HealEntity(LevelBasedValue amount) {
        this.amount = amount;
    }

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (entity instanceof LivingEntity living) {
            living.heal(amount.calculate(enchantmentLevel));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}