package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.enchantment.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantment.Rarity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Supplier;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(
            ForgeRegistries.ENCHANTMENTS, MoEnchants.MOD_ID);

    public static final ArrayList<Translation> TRANSLATIONS = new ArrayList<>();

    public static final RegistryObject<Enchantment> HARMING_CURSE = register(
            "harming_curse",
            HarmingCurseEnchantment::new,
            "Curse of Harming",
            "Take damage when you damage any other mob.");

    public static final RegistryObject<Enchantment> ULTIMATE_FINISH = register(
            "ultimate_finish",
            UltimateFinishEnchantment::new,
            "Ultimate Finish",
            "Enemies slain with this enchantment explode into pieces.");

    public static final RegistryObject<Enchantment> SCORCHING_CURSE = register(
            "scorching_curse",
            ScorchingCurseEnchantment::new,
            "Curse of Scorching",
            "Get ignited on fire when you're hurt.");

    public static final RegistryObject<Enchantment> VENOMFANG = register(
            "venomfang",
            ToxicAspectEnchantment::new,
            "Venomfang",
            "Poisons attacked enemies.");

    public static final RegistryObject<Enchantment> SMELTING_TOUCH = register(
            "smelting_touch",
            SmeltingTouchEnchantment::new,
            "Smelting Touch",
            "Automatically smelts any block you mine.");

    public static final RegistryObject<Enchantment> LIFE_STEAL = register(
            "life_steal",
            LifeStealEnchantment::new,
            "Lifesteal",
            "Gives you a chance to steal attacked enemies health.");

    public static final RegistryObject<Enchantment> FREEZING_ASPECT = register(
            "freezing_aspect",
            FreezingAspectEnchantment::new,
            "Ice Aspect",
            "Freezes attacked enemies.");

    public static final RegistryObject<Enchantment> LIFEFORCE_DISCHARGE_CURSE = register(
            "lifeforce_discharge_curse",
            LifeforceDischargeCurseEnchantment::new,
            "Curse of Sacrifice",
            "Heal enemies you attack with your health.");

    public static final RegistryObject<Enchantment> PANIC = register(
            "panic",
            PanicEnchantment::new,
            "Panic",
            "Get regeneration and speed when your health is critically low.");

    public static final RegistryObject<Enchantment> CONDUCTION = register(
            "conduction",
            ConductionEnchantment::new,
            "Conduction",
            "Conducts lightning to attacked enemies during storms.");

    public static final RegistryObject<Enchantment> SAVING_GRACE = register(
            "saving_grace",
            SavingGraceEnchantment::new,
            "Saving Grace",
            "When you fall into the void, get launched back up.");

    public static final RegistryObject<Enchantment> FROST = register(
            "frost",
            FrostEnchantment::new,
            "Frost",
            "Freezes attacked enemies.");

    public static final RegistryObject<Enchantment> AQUA_SLASH = register(
            "aqua_slash",
            BonusDamageEnchantment::new,
            "Aqua Slash",
            "Does more damage to aquaphobic mobs.");

    public static final RegistryObject<Enchantment> HUNTER = register(
            "hunter",
            BonusDamageEnchantment::new,
            "Hunter",
            "Does more damage to animals.");

    public static final RegistryObject<Enchantment> SWIFTNESS = register(
            "swiftness",
            () -> new AttributeModifierEnchantment(
                    Rarity.RARE,
                    EnchantmentCategory.ARMOR_FEET,
                    new EquipmentSlot[]{ EquipmentSlot.FEET },
                    UUID.fromString("1f13db16-606d-4ae9-97e0-aa856ae1ecb1"),
                    Attributes.MOVEMENT_SPEED,
                    "swiftness",
                    0.01f,
                    3,
                    new Enchantment[]{ Enchantments.SOUL_SPEED, PANIC.get() },
                    false, false, true),
            "Swiftness",
            "Increases movement speed.");

    public static final RegistryObject<Enchantment> BOILING_CURSE = register(
            "boiling_curse",
            BoilingCurseEnchantment::new,
            "Curse of Boiling",
            "Ignites you in hot or dry biomes.");

    public static final RegistryObject<Enchantment> FREEZING_CURSE = register(
            "freezing_curse",
            FreezingCurseEnchantment::new,
            "Curse of Frostbite",
            "Freezes you in cold biomes.");

    public static final RegistryObject<Enchantment> BAD_DREAMS_CURSE = register(
            "bad_dreams_curse",
            BadDreamsCurseEnchantment::new,
            "Curse of Insomnia",
            "Become unable to sleep due to nightmares.");

    public static final RegistryObject<Enchantment> ANGELS_BLESSING = register(
            "angels_blessing",
            AngelsBlessingEnchantment::new,
            "Angel's Blessing",
            "Gives your Totem of Undying extra uses, +1 use per every level.");

    public static final RegistryObject<Enchantment> ROCK_MENDING = register(
            "rock_mending",
            RockMendingEnchantment::new,
            "Rock Mending",
            "Has a chance of not damaging the tool when mining rocks.");

    public static final RegistryObject<Enchantment> LEVITATING = register(
            "levitating",
            LevitatingEnchantment::new,
            "Levitating",
            "Shooting mobs will make them fly.");

    public static final RegistryObject<Enchantment> DETONATION = register(
            "detonation",
            DetonationEnchantment::new,
            "Detonation",
            "Enemies shot with this weapon explode into pieces.");

    public static final RegistryObject<Enchantment> NIGHT_VISION = register(
            "night_vision",
            NightVisionEnchantment::new,
            "Night Vision",
            "Gives you night vision when equipped.");

    public static final RegistryObject<Enchantment> AQUAPHOBIA_CURSE = register(
            "aquaphobia_curse",
            AquaphobiaCurseEnchantment::new,
            "Curse of Aquaphobia",
            "Become afraid of water, taking damage while submerged.");

    public static final RegistryObject<Enchantment> WEIGHTLESS = register(
            "weightless",
            () -> new AttributeModifierEnchantment(
                    Rarity.RARE,
                    EnchantmentCategory.ARMOR_LEGS,
                    new EquipmentSlot[]{ EquipmentSlot.LEGS },
                    UUID.fromString("fe970a21-ad3e-4a00-886d-6119b8c5653a"),
                    ForgeMod.ENTITY_GRAVITY.get(),
                    "weightless",
                    -0.01f,
                    2,
                    new Enchantment[]{ Enchantments.THORNS },
                    false, false, true),
            "Weightless",
            "Decreases your gravity, allowing you to jump higher and fall slower.");

    public static final RegistryObject<Enchantment> DENSITY_CURSE = register(
            "density_curse",
            () -> new AttributeModifierEnchantment(
                    Rarity.VERY_RARE,
                    EnchantmentCategory.ARMOR,
                    new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
                                         EquipmentSlot.FEET },
                    UUID.fromString("3d4c9250-3ffd-48d8-92e8-6589ddf69a26"),
                    ForgeMod.ENTITY_GRAVITY.get(),
                    "density_curse",
                    0.025f,
                    1,
                    new Enchantment[]{},
                    true, true, false),
            "Curse of Density",
            "Increases your gravity, causing you to jump lower and fall faster.");

    public static final RegistryObject<Enchantment> REACH = register(
            "reach",
            () -> new AttributeModifierEnchantment(
                    Rarity.RARE,
                    EnchantmentCategory.DIGGER,
                    new EquipmentSlot[]{ EquipmentSlot.MAINHAND },
                    UUID.fromString("5c4c7797-5f49-4560-9035-8a2bf8836616"),
                    ForgeMod.BLOCK_REACH.get(),
                    "reach",
                    1f,
                    3,
                    new Enchantment[]{ Enchantments.SILK_TOUCH, Enchantments.BLOCK_FORTUNE, SMELTING_TOUCH.get() },
                    false, false, true),
            "Reach",
            "Gives you +1 block of mining reach per level.");

    public static final RegistryObject<Enchantment> BLOODTHIRST = register(
            "bloodthirst",
            BloodthirstEnchantment::new,
            "Bloodthirst",
            "Right-click this weapon to gain a temporary damage buff, in exchange for some health.");

    public static final RegistryObject<Enchantment> REVENANT = register(
            "revenant",
            RevenantEnchantment::new,
            "Revenant",
            "Has a chance to instantly kill any undead mob.");

    public static final RegistryObject<Enchantment> MAGMA_WALKER = register(
            "magma_walker",
            MagmaWalkerEnchantment::new,
            "Magma Walker",
            "Creates a path while walking on lava.");

    public static final RegistryObject<Enchantment> FIRE_COATING = register(
            "fire_coating",
            FireCoatingEnchantment::new,
            "Fireproofing",
            "Makes you immune to fire and lava.");

    public static final RegistryObject<Enchantment> GROWTH = register(
            "growth",
            () -> new AttributeModifierEnchantment(
                    Rarity.RARE,
                    EnchantmentCategory.ARMOR,
                    new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
                                         EquipmentSlot.FEET },
                    UUID.fromString("1e2860e7-95fb-4b49-b617-ddd1da80c3d2"),
                    Attributes.MAX_HEALTH,
                    "growth",
                    1f,
                    4,
                    new Enchantment[]{ Enchantments.ALL_DAMAGE_PROTECTION, Enchantments.PROJECTILE_PROTECTION,
                                       Enchantments.BLAST_PROTECTION, Enchantments.FALL_PROTECTION,
                                       Enchantments.FIRE_PROTECTION },
                    false, false, true),
            "Vitality",
            "Adds half a heart to your max health for each level.");

    public static final RegistryObject<Enchantment> DEVASTATION = register(
            "devastation",
            () -> new CriticalHitEnchantment(3),
            "Critical Blow",
            "Allows for the chance of critical hits, which do 150% damage.");

    public static final RegistryObject<Enchantment> FIRST_STRIKE = register(
            "first_strike",
            () -> new CriticalHitEnchantment(1),
            "First Strike",
            "Does 25% more damage on first strikes.");

    public static final RegistryObject<Enchantment> CAREFUL = register(
            "careful",
            () -> new CarefulEnchantment(EquipmentSlot.MAINHAND),
            "Green Thumb",
            "Prevents you from mining ungrown crops & stems.");

    private static RegistryObject<Enchantment> register(
            String id, Supplier<Enchantment> enchantment, String name, String description
    ) {
        TRANSLATIONS.add(new Translation(id, name, description));
        return ENCHANTMENTS.register(id, enchantment);
    }

    public record Translation(String id, String name, String description) {}
}
