package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {
    public static final TagKey<EntityType<?>> BOSSES = tag(Registries.ENTITY_TYPE, "bosses");
    public static final TagKey<EntityType<?>> WATER_WEAK_MOBS = tag(Registries.ENTITY_TYPE, "water_weak_mobs");

    private static <T> TagKey<T> tag(ResourceKey<? extends Registry<T>> type, String id) {
        return TagKey.create(type, ResourceLocation.fromNamespaceAndPath(MoEnchantsMod.MOD_ID, id));
    }
}
