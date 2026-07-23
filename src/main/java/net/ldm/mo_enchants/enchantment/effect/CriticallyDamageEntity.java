package net.ldm.mo_enchants.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

/**
 * @author Logan Dhillon
 */
public class CriticallyDamageEntity implements EnchantmentEntityEffect {
    public static final MapCodec<CriticallyDamageEntity> CODEC = RecordCodecBuilder.mapCodec(
            inst ->
                    inst.group(LevelBasedValue.CODEC.fieldOf("multiplier").forGetter(effect -> effect.multiplier))
                        .apply(inst, CriticallyDamageEntity::new));

    private final LevelBasedValue multiplier;

    public CriticallyDamageEntity(LevelBasedValue multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (!(entity instanceof LivingEntity victim)) return;
        DamageSource damage = victim.getLastDamageSource();

        float bonus = victim.lastHurt * multiplier.calculate(enchantmentLevel);

        victim.hurt(damage == null ? level.damageSources().generic() : damage, bonus);

        level.playSound(
                null,
                victim.blockPosition(),
                SoundEvents.PLAYER_ATTACK_CRIT,
                SoundSource.PLAYERS,
                1.0f,
                0.75f
        );
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
