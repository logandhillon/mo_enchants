package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.datagen.datapack.DatapackEntryProvider;
import net.ldm.mo_enchants.enchantment.effect.CriticallyDamageEntity;
import net.ldm.mo_enchants.enchantment.effect.HealEntity;
import net.ldm.mo_enchants.loot.condition.EntityIsAnimalCondition;
import net.ldm.mo_enchants.loot.condition.RandomChanceCondition;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantment.EnchantmentDefinition;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootContext.EntityTarget;
import net.minecraft.world.level.storage.loot.predicates.AllOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.WeatherCheck;
import net.neoforged.neoforge.common.Tags.Biomes;

import java.util.ArrayList;

public class ModEnchantments implements DatapackEntryProvider<Enchantment> {
    public static final ArrayList<Translation> TRANSLATIONS = new ArrayList<>();
    public static final ArrayList<Tags>        TAGS         = new ArrayList<>();

    public static final ResourceKey<Enchantment> HARMING_CURSE = key(
            "harming_curse",
            "Curse of Harming",
            "Take damage when you damage any other mob.");

    public static final ResourceKey<Enchantment> ULTIMATE_FINISH = key(
            "ultimate_finish",
            "Ultimate Finish",
            "Enemies slain with this enchantment explode into pieces.");

    public static final ResourceKey<Enchantment> SCORCHING_CURSE = key(
            "scorching_curse",
            "Curse of Scorching",
            "Get ignited on fire when you're hurt.");

    public static final ResourceKey<Enchantment> VENOMFANG = key(
            "venomfang",
            "Venomfang",
            "Poisons attacked enemies.");

    public static final ResourceKey<Enchantment> SMELTING_TOUCH = key(
            "smelting_touch",
            "Smelting Touch",
            "Automatically smelts any block you mine.");

    public static final ResourceKey<Enchantment> LIFESTEAL = key(
            "life_steal",
            "Lifesteal",
            "Gives you a chance to steal attacked enemies health.");

    public static final ResourceKey<Enchantment> ICE_ASPECT = key(
            "freezing_aspect",
            "Ice Aspect",
            "Freezes attacked enemies.");

    public static final ResourceKey<Enchantment> SACRIFICE_CURSE = key(
            "lifeforce_discharge_curse",
            "Curse of Sacrifice",
            "Heal enemies you attack with your health.");

    public static final ResourceKey<Enchantment> PANIC = key(
            "panic",
            "Panic",
            "Get regeneration and speed when your health is critically low.");

    public static final ResourceKey<Enchantment> CONDUCTION = key(
            "conduction",
            "Conduction",
            "Conducts lightning to attacked enemies during storms.");

    public static final ResourceKey<Enchantment> SAVING_GRACE = key(
            "saving_grace",
            "Saving Grace",
            "When you fall into the void, get launched back up.");

    public static final ResourceKey<Enchantment> FROST = key(
            "frost",
            "Frost",
            "Freezes attacked enemies.");

    public static final ResourceKey<Enchantment> AQUA_SLASH = key(
            "aqua_slash",
            "Aqua Slash",
            "Does more damage to aquaphobic mobs.");

    public static final ResourceKey<Enchantment> HUNTER = key(
            "hunter",
            "Hunter",
            "Does more damage to animals.");

    public static final ResourceKey<Enchantment> SWIFTNESS = key(
            "swiftness",
//            () -> new AttributeModifierEnchantment(
//                    Rarity.RARE,
//                    EnchantmentCategory.ARMOR_FEET,
//                    new EquipmentSlot[]{ EquipmentSlot.FEET },
//                    UUID.fromString("1f13db16-606d-4ae9-97e0-aa856ae1ecb1"),
//                    Attributes.MOVEMENT_SPEED,
//                    "swiftness",
//                    0.01f,
//                    3,
//                    new Enchantment[]{ Enchantments.SOUL_SPEED, PANIC.get() },
//                    false, false, true),
            "Swiftness",
            "Increases movement speed.");

    public static final ResourceKey<Enchantment> BOILING_CURSE = key(
            "boiling_curse",
            "Curse of Boiling",
            "Ignites you in hot or dry biomes.");

    public static final ResourceKey<Enchantment> FROSTBITE_CURSE = key(
            "freezing_curse",
            "Curse of Frostbite",
            "Freezes you in cold biomes.");

    public static final ResourceKey<Enchantment> INSOMNIA_CURSE = key(
            "bad_dreams_curse",
            "Curse of Insomnia",
            "Become unable to sleep due to nightmares.");

    public static final ResourceKey<Enchantment> ANGELS_BLESSING = key(
            "angels_blessing",
            "Angel's Blessing",
            "Gives your Totem of Undying extra uses, +1 use per every level.");

    public static final ResourceKey<Enchantment> ROCK_MENDING = key(
            "rock_mending",
            "Rock Mending",
            "Has a chance of not damaging the tool when mining rocks.");

    public static final ResourceKey<Enchantment> LEVITATING = key(
            "levitating",
            "Levitating",
            "Shooting mobs will make them fly.");

    public static final ResourceKey<Enchantment> DETONATION = key(
            "detonation",
            "Detonation",
            "Enemies shot with this weapon explode into pieces.");

    public static final ResourceKey<Enchantment> NIGHT_VISION = key(
            "night_vision",
            "Night Vision",
            "Gives you night vision when equipped.");

    public static final ResourceKey<Enchantment> AQUAPHOBIA_CURSE = key(
            "aquaphobia_curse",
            "Curse of Aquaphobia",
            "Become afraid of water, taking damage while submerged.");

    public static final ResourceKey<Enchantment> WEIGHTLESS = key(
            "weightless",
//            () -> new AttributeModifierEnchantment(
//                    Rarity.RARE,
//                    EnchantmentCategory.ARMOR_LEGS,
//                    new EquipmentSlot[]{ EquipmentSlot.LEGS },
//                    UUID.fromString("fe970a21-ad3e-4a00-886d-6119b8c5653a"),
//                    ForgeMod.ENTITY_GRAVITY.get(),
//                    "weightless",
//                    -0.01f,
//                    2,
//                    new Enchantment[]{ Enchantments.THORNS },
//                    false, false, true),
            "Weightless",
            "Decreases your gravity, allowing you to jump higher and fall slower.");

    public static final ResourceKey<Enchantment> DENSITY_CURSE = key(
            "density_curse",
//            () -> new AttributeModifierEnchantment(
//                    Rarity.VERY_RARE,
//                    EnchantmentCategory.ARMOR,
//                    new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
//                                         EquipmentSlot.FEET },
//                    UUID.fromString("3d4c9250-3ffd-48d8-92e8-6589ddf69a26"),
//                    ForgeMod.ENTITY_GRAVITY.get(),
//                    "density_curse",
//                    0.025f,
//                    1,
//                    new Enchantment[]{},
//                    true, true, false),
            "Curse of Density",
            "Increases your gravity, causing you to jump lower and fall faster.");

    public static final ResourceKey<Enchantment> REACH = key(
            "reach",
//            () -> new AttributeModifierEnchantment(
//                    Rarity.RARE,
//                    EnchantmentCategory.DIGGER,
//                    new EquipmentSlot[]{ EquipmentSlot.MAINHAND },
//                    UUID.fromString("5c4c7797-5f49-4560-9035-8a2bf8836616"),
//                    ForgeMod.BLOCK_REACH.get(),
//                    "reach",
//                    1f,
//                    3,
//                    new Enchantment[]{ Enchantments.SILK_TOUCH, Enchantments.BLOCK_FORTUNE, SMELTING_TOUCH.get() },
//                    false, false, true),
            "Reach",
            "Gives you +1 block of mining reach per level.");

    public static final ResourceKey<Enchantment> BLOODTHIRST = key(
            "bloodthirst",
            "Bloodthirst",
            "Right-click this weapon to gain a temporary damage buff, in exchange for some health.");

    public static final ResourceKey<Enchantment> REVENANT = key(
            "revenant",
            "Revenant",
            "Has a chance to instantly kill any undead mob.");

    public static final ResourceKey<Enchantment> MAGMA_WALKER = key(
            "magma_walker",
            "Magma Walker",
            "Creates a path while walking on lava.");

    public static final ResourceKey<Enchantment> FIREPROOFING = key(
            "fire_coating",
            "Fireproofing",
            "Makes you immune to fire and lava.");

    public static final ResourceKey<Enchantment> VITALITY = key(
            "growth",
//            () -> new AttributeModifierEnchantment(
//                    Rarity.RARE,
//                    EnchantmentCategory.ARMOR,
//                    new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
//                                         EquipmentSlot.FEET },
//                    UUID.fromString("1e2860e7-95fb-4b49-b617-ddd1da80c3d2"),
//                    Attributes.MAX_HEALTH,
//                    "growth",
//                    1f,
//                    4,
//                    new Enchantment[]{ Enchantments.ALL_DAMAGE_PROTECTION, Enchantments.PROJECTILE_PROTECTION,
//                                       Enchantments.BLAST_PROTECTION, Enchantments.FALL_PROTECTION,
//                                       Enchantments.FIRE_PROTECTION },
//                    false, false, true),
            "Vitality",
            "Adds half a heart to your max health for each level.");

    public static final ResourceKey<Enchantment> CRITICAL_BLOW = key(
            "devastation",
//            () -> new CriticalHitEnchantment(3),
            "Critical Blow",
            "Allows for the chance of critical hits, which do 150% damage.");

    public static final ResourceKey<Enchantment> FIRST_STRIKE = key(
            "first_strike",
//            () -> new CriticalHitEnchantment(1),
            "First Strike",
            "Does 25% more damage on first strikes.");

    public static final ResourceKey<Enchantment> GREEN_THUMB = key(
            "careful",
            "Green Thumb",
            "Prevents you from mining ungrown crops & stems.");

    @Override
    public void bootstrap(BootstrapContext<Enchantment> ctx) {
        HolderGetter<Enchantment> enchantments = ctx.lookup(Registries.ENCHANTMENT);
        HolderGetter<DamageType> damageTypes = ctx.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Item> items = ctx.lookup(Registries.ITEM);
        HolderGetter<Biome> biomes = ctx.lookup(Registries.BIOME);
        HolderGetter<EntityType<?>> entityTypes = ctx.lookup(Registries.ENTITY_TYPE);

        register(
                ctx, new Tags(ANGELS_BLESSING, false, false, true),
                Enchantment.enchantment(definition(
                        items.getOrThrow(ModTags.TOTEM_OF_UNDYING),
                        Rarity.VERY_RARE,
                        1,
                        EquipmentSlotGroup.MAINHAND, EquipmentSlotGroup.OFFHAND
                ))
        );

        register(
                ctx, new Tags(AQUA_SLASH, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.UNCOMMON,
                                   4,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                           .withEffect(
                                   EnchantmentEffectComponents.DAMAGE,
                                   new AddValue(LevelBasedValue.perLevel(1.5f)),
                                   LootItemEntityPropertyCondition.hasProperties(
                                           EntityTarget.THIS,
                                           EntityPredicate.Builder.entity().of(ModTags.WATER_WEAK_MOBS)
                                   )
                           )
        );

        register(
                ctx, new Tags(HUNTER, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.UNCOMMON,
                                   4,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                           .withEffect(
                                   EnchantmentEffectComponents.DAMAGE,
                                   new AddValue(LevelBasedValue.perLevel(1.5f)),
                                   EntityIsAnimalCondition::new
                           )
        );

        register(
                ctx, new Tags(BLOODTHIRST, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   2,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(ModTags.OP_WEAPON_ENCHANTMENTS))
                // effect done in code
        );

        register(
                ctx, new Tags(CONDUCTION, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.BOW_ENCHANTABLE),
                                   Rarity.RARE,
                                   1,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(ModTags.EXCLUSIVE_BOW_MOD_ENCHANTMENTS))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.ATTACKER,
                                   EnchantmentTarget.VICTIM,
                                   new SummonEntityEffect(
                                           HolderSet.direct(EntityType.LIGHTNING_BOLT.builtInRegistryHolder()), false),
                                   AllOfCondition.allOf(
                                           WeatherCheck.weather().setThundering(true),
                                           LootItemEntityPropertyCondition.hasProperties(
                                                   LootContext.EntityTarget.THIS,
                                                   EntityPredicate.Builder
                                                           .entity()
                                                           .located(LocationPredicate.Builder.location()
                                                                                             .setCanSeeSky(true))
                                           ),
                                           LootItemEntityPropertyCondition.hasProperties(
                                                   LootContext.EntityTarget.DIRECT_ATTACKER,
                                                   EntityPredicate.Builder.entity().of(EntityType.ARROW)
                                           )
                                   ))
        );

        register(
                ctx, new Tags(CRITICAL_BLOW, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.UNCOMMON,
                                   3,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(ModTags.CRITICAL_HIT_ENCHANTMENTS))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.ATTACKER,
                                   EnchantmentTarget.VICTIM,
                                   new CriticallyDamageEntity(LevelBasedValue.constant(0.5f)), // additional 50%
                                   RandomChanceCondition.of(LevelBasedValue.perLevel(0.1f)))
        );

        register(
                ctx, new Tags(DETONATION, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ModTags.RANGED_WEAPONS_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(ModTags.EXCLUSIVE_BOW_MOD_ENCHANTMENTS))
                // effect done in code
        );

        register(
                ctx, new Tags(ULTIMATE_FINISH, true, false, false),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .exclusiveWith(enchantments.getOrThrow(ModTags.OP_WEAPON_ENCHANTMENTS))
                // effect done code
        );

        // ======== CURSES ========
        register(
                ctx, new Tags(AQUAPHOBIA_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        Rarity.VERY_RARE,
                        1,
                        EquipmentSlotGroup.ARMOR
                ))
                // effect done in code
        );

        register(
                ctx, new Tags(BOILING_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.ARMOR
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.TICK,
                                   new Ignite(LevelBasedValue.constant(3)),
                                   LocationCheck.checkLocation(LocationPredicate.Builder
                                                                       .location()
                                                                       .setBiomes(biomes.getOrThrow(Biomes.IS_HOT)))
                           )
        );

        register(
                ctx, new Tags(DENSITY_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.ARMOR
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.ATTRIBUTES,
                                   new EnchantmentAttributeEffect(
                                           MoEnchants.modResource("density_curse"),
                                           Attributes.GRAVITY,
                                           LevelBasedValue.constant(0.025f),
                                           Operation.ADD_VALUE
                                   ))
        );

        register(
                ctx, new Tags(FROSTBITE_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.ARMOR
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.TICK,
                                   new ApplyMobEffect(
                                           HolderSet.direct(MobEffects.MOVEMENT_SLOWDOWN),
                                           LevelBasedValue.constant(7), LevelBasedValue.constant(7),
                                           LevelBasedValue.constant(1), LevelBasedValue.constant(1)),
                                   LocationCheck.checkLocation(LocationPredicate.Builder
                                                                       .location()
                                                                       .setBiomes(biomes.getOrThrow(Biomes.IS_COLD)))
                           )
        );

        register(
                ctx, new Tags(HARMING_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.ATTACKER,
                                   EnchantmentTarget.ATTACKER,
                                   new DamageEntity(
                                           LevelBasedValue.constant(1),
                                           LevelBasedValue.constant(4),
                                           damageTypes.getOrThrow(ModDamageSources.HARMING_CURSE)))
        );

        register(
                ctx, new Tags(INSOMNIA_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                        items.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE),
                        Rarity.VERY_RARE,
                        1,
                        EquipmentSlotGroup.HEAD
                ))
                // effect done in code
        );

        register(
                ctx, new Tags(SACRIFICE_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.MAINHAND
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.ATTACKER,
                                   EnchantmentTarget.ATTACKER,
                                   new DamageEntity(
                                           LevelBasedValue.constant(1),
                                           LevelBasedValue.constant(4),
                                           damageTypes.getOrThrow(ModDamageSources.LIFEFORCE_DISCHARGE)))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.ATTACKER,
                                   EnchantmentTarget.VICTIM,
                                   new HealEntity(LevelBasedValue.perLevel(1)))
        );

        register(
                ctx, new Tags(SCORCHING_CURSE, false, true, true),
                Enchantment.enchantment(definition(
                                   items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                   Rarity.VERY_RARE,
                                   1,
                                   EquipmentSlotGroup.ARMOR
                           ))
                           .withEffect(
                                   EnchantmentEffectComponents.POST_ATTACK,
                                   EnchantmentTarget.VICTIM,
                                   EnchantmentTarget.VICTIM,
                                   new Ignite(LevelBasedValue.constant(3)))
        );
    }

    private static void register(BootstrapContext<Enchantment> context, Tags tags,
                                 Enchantment.Builder builder) {
        context.register(tags.key, builder.build(tags.key.location()));
        TAGS.add(tags);
    }

    private static ResourceKey<Enchantment> key(String id, String name, String description) {
        TRANSLATIONS.add(new Translation(id, name, description));
        return ResourceKey.create(Registries.ENCHANTMENT, MoEnchants.modResource(id));
    }

    public enum Rarity {
        COMMON,
        UNCOMMON,
        RARE,
        VERY_RARE
    }

    private static EnchantmentDefinition definition(
            HolderSet<Item> supportedItems,
            Rarity rarity,
            int maxLevel,
            EquipmentSlotGroup... slots
    ) {
        return switch (rarity) {
            case COMMON -> Enchantment.definition(
                    supportedItems,
                    10,
                    maxLevel,
                    Enchantment.dynamicCost(1, 11),
                    Enchantment.dynamicCost(21, 11),
                    1,
                    slots
            );

            case UNCOMMON -> Enchantment.definition(
                    supportedItems,
                    5,
                    maxLevel,
                    Enchantment.dynamicCost(5, 8),
                    Enchantment.dynamicCost(25, 8),
                    2,
                    slots
            );

            case RARE -> Enchantment.definition(
                    supportedItems,
                    2,
                    maxLevel,
                    Enchantment.dynamicCost(10, 8),
                    Enchantment.dynamicCost(30, 8),
                    4,
                    slots
            );

            case VERY_RARE -> Enchantment.definition(
                    supportedItems,
                    1,
                    maxLevel,
                    Enchantment.dynamicCost(20, 8),
                    Enchantment.dynamicCost(50, 8),
                    8,
                    slots
            );
        };
    }

    public record Translation(String id, String name, String description) {}

    public record Tags(ResourceKey<Enchantment> key, boolean isTradeable, boolean isCurse,
                       boolean isTreasureOnly) {}
}
