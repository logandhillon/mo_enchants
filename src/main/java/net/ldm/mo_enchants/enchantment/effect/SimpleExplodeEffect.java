package net.ldm.mo_enchants.enchantment.effect;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

/**
 * @author Logan Dhillon
 */
public record SimpleExplodeEffect(
        boolean attributeToUser, LevelBasedValue radius, boolean createFire, ExplosionInteraction explosionInteraction
) implements EnchantmentEntityEffect {

    public static final MapCodec<SimpleExplodeEffect> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Codec.BOOL.optionalFieldOf("attribute_to_user", false).forGetter(SimpleExplodeEffect::attributeToUser),
            LevelBasedValue.CODEC.fieldOf("radius").forGetter(SimpleExplodeEffect::radius),
            Codec.BOOL.optionalFieldOf("create_fire", false).forGetter(SimpleExplodeEffect::createFire),
            ExplosionInteraction.CODEC.fieldOf("block_interaction").forGetter(SimpleExplodeEffect::explosionInteraction)
    ).apply(inst, SimpleExplodeEffect::new));

    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        level.explode(
                this.attributeToUser ? entity : null,
                origin.x, origin.y, origin.z,
                radius.calculate(enchantmentLevel),
                explosionInteraction
        );
    }

    public MapCodec<SimpleExplodeEffect> codec() {
        return CODEC;
    }
}