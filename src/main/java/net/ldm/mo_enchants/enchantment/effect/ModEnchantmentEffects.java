package net.ldm.mo_enchants.enchantment.effect;

import com.mojang.serialization.MapCodec;
import net.ldm.mo_enchants.MoEnchants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * @author Logan Dhillon
 */
public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> REGISTRY =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MoEnchants.MOD_ID);

    public static final Holder<MapCodec<? extends EnchantmentEntityEffect>> HEAL_ENTITY =
            REGISTRY.register("heal_entity", () -> HealEntity.CODEC);

    public static final Holder<MapCodec<? extends EnchantmentEntityEffect>> CRITICALLY_DAMAGE_ENTITY =
            REGISTRY.register("critically_damage_entity", () -> CriticallyDamageEntity.CODEC);

    public static final Holder<MapCodec<? extends EnchantmentEntityEffect>> SIMPLE_EXPLODE_EFFECT =
            REGISTRY.register("simple_explode_effect", () -> SimpleExplodeEffect.CODEC);
}