package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModTags {
    public static final TagKey<EntityType<?>> BOSSES = tag(Registries.ENTITY_TYPE, "bosses");
    public static final TagKey<EntityType<?>> WATER_WEAK_MOBS = tag(Registries.ENTITY_TYPE, "water_weak_mobs");

    public static final TagKey<Item> TOTEM_OF_UNDYING           = tag(Registries.ITEM, "totem_of_undying");
    public static final TagKey<Item> RANGED_WEAPONS_ENCHANTABLE = tag(Registries.ITEM, "ranged_weapons_enchantable");

    public static final TagKey<Enchantment> EXCLUSIVE_BOW_MOD_ENCHANTMENTS = tag(Registries.ENCHANTMENT, "exclusive_bow_mod_enchantments");
    public static final TagKey<Enchantment> OP_WEAPON_ENCHANTMENTS = tag(Registries.ENCHANTMENT, "op_weapon_enchantments");
    public static final TagKey<Enchantment> CRITICAL_HIT_ENCHANTMENTS = tag(Registries.ENCHANTMENT, "critical_hit_enchantments");


    private static <T> TagKey<T> tag(ResourceKey<? extends Registry<T>> type, String id) {
        return TagKey.create(type, MoEnchants.modResource(id));
    }
}
