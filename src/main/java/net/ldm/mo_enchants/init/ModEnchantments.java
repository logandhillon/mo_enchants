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
            "Damages you when you damage any other mob.");

    public static final RegistryObject<Enchantment> ULTIMATE_FINISH = register(
            "ultimate_finish",
            UltimateFinishEnchantment::new,
            "Ultimate Finish",
            "When you kill a mob, create an explosion that damages everything around you except blocks and you.");

    public static final RegistryObject<Enchantment> SCORCHING_CURSE = register(
            "scorching_curse",
            ScorchingCurseEnchantment::new,
            "Curse of Scorching",
            "When you get hit, you get ignited on fire.");

    public static final RegistryObject<Enchantment> VENOMFANG = register(
            "venomfang",
            ToxicAspectEnchantment::new,
            "Venomfang",
            "Gives Poison I for 5 seconds (Venomfang I) or Poison II for 7.5 seconds (Venomfang II).");

    public static final RegistryObject<Enchantment> SMELTING_TOUCH = register(
            "smelting_touch",
            SmeltingTouchEnchantment::new,
            "Smelting Touch",
            "Automatically smelts any block you mine.");

    public static final RegistryObject<Enchantment> LIFE_STEAL = register(
            "life_steal",
            LifeStealEnchantment::new,
            "Life Steal",
            "Has a 10% chance of healing you, the chance of healing goes up as the enchantment level gets higher.");

    public static final RegistryObject<Enchantment> FREEZING_ASPECT = register(
            "freezing_aspect",
            FreezingAspectEnchantment::new,
            "Freezing Aspect",
            "Freezes mobs, which slows the mob by 15% * level.");

    public static final RegistryObject<Enchantment> LIFEFORCE_DISCHARGE_CURSE = register(
            "lifeforce_discharge_curse",
            LifeforceDischargeCurseEnchantment::new,
            "Lifeforce Discharge",
            "When you attack a mob, it drains some of your lifeforce, and gives it to the attacked mob.");

    public static final RegistryObject<Enchantment> PANIC = register(
            "panic",
            PanicEnchantment::new,
            "Panic",
            "When your health drops below 2 hearts, get regeneration and speed.");

    public static final RegistryObject<Enchantment> CONDUCTION = register(
            "conduction",
            ConductionEnchantment::new,
            "Conduction",
            "If a lightning storm is happening when you shoot a mob, the mob gets struck with lightning.");

    public static final RegistryObject<Enchantment> SAVING_GRACE = register(
            "saving_grace",
            SavingGraceEnchantment::new,
            "Saving Grace",
            "When you fall into the void, get launched back up.");

    public static final RegistryObject<Enchantment> FROST = register(
            "frost",
            FrostEnchantment::new,
            "Frost",
            "Freezes mobs, which slows the mob by 15% * level.");

    public static final RegistryObject<Enchantment> AQUA_SLASH = register(
            "aqua_slash",
            BonusDamageEnchantment::new,
            "Aqua Slash",
            "Does more damage to mobs with a water weakness (Blazes, Endermen, Magma Cubes)");

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
            "Makes you run 20% faster, per level.");

    public static final RegistryObject<Enchantment> BOILING_CURSE = register(
            "boiling_curse",
            BoilingCurseEnchantment::new,
            "Curse of Boiling",
            "When you are in a hot/dry biome or in the nether, you get set on fire.");

    public static final RegistryObject<Enchantment> FREEZING_CURSE = register(
            "freezing_curse",
            FreezingCurseEnchantment::new,
            "Curse of Freezing",
            "When you are in a freezing biome, your speed is lowered by 30%.");

    public static final RegistryObject<Enchantment> BAD_DREAMS_CURSE = register(
            "bad_dreams_curse",
            BadDreamsCurseEnchantment::new,
            "Curse of Bad Dreams",
            "Die of a bad dream, whenever you try to sleep.");

    public static final RegistryObject<Enchantment> ANGELS_BLESSING = register(
            "angels_blessing",
            AngelsBlessingEnchantment::new,
            "Angel's Blessing",
            "Gives your Totem of Undying extra uses, +1 use per every level.");

    public static final RegistryObject<Enchantment> ROCK_MENDING = register(
            "rock_mending",
            RockMendingEnchantment::new,
            "Rock Mending",
            "Has a chance (30%, 60%, 80%) of not damaging the tool when mining any sort of rock.");

    public static final RegistryObject<Enchantment> LEVITATING = register(
            "levitating",
            LevitatingEnchantment::new,
            "Levitating",
            "Shooting mobs with this enchantment makes them fly.");

    public static final RegistryObject<Enchantment> DETONATION = register(
            "detonation",
            DetonationEnchantment::new,
            "Detonation",
            "When you kill a mob, create an explosion that damages everything around the killed mob except blocks.");

    public static final RegistryObject<Enchantment> NIGHT_VISION = register(
            "night_vision",
            NightVisionEnchantment::new,
            "Night Vision",
            "Gives you night vision when equipped.");

    public static final RegistryObject<Enchantment> AQUAPHOBIA_CURSE = register(
            "aquaphobia_curse",
            AquaphobiaCurseEnchantment::new,
            "Curse of Aquaphobia",
            "Makes you take half a heart of damage every half-second while submerged.");

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
            "Allows you to jump higher, the level of the enchantment determines how high you jump.");

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
            "Makes you move 15% slower.");

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
            "When right-clicked with this enchantment, take 2.5 hearts in exchange for Strength and Speed for 12 " +
            "seconds.");

    public static final RegistryObject<Enchantment> REVENANT = register(
            "revenant",
            RevenantEnchantment::new,
            "Revenant",
            "Has a chance (1%, 2%) to instantly kill any undead mob.");

    public static final RegistryObject<Enchantment> MAGMA_WALKER = register(
            "magma_walker",
            MagmaWalkerEnchantment::new,
            "Magma Walker",
            "Allows you to walk on lava, simular to Frost Walker.");

    public static final RegistryObject<Enchantment> FIRE_COATING = register(
            "fire_coating",
            FireCoatingEnchantment::new,
            "Fire Coating",
            "Wearing a chestplate with this enchantment makes you immune to fire and lava.");

    public static final RegistryObject<Enchantment> GROWTH = register(
            "growth",
            () -> new AttributeModifierEnchantment(
                    Rarity.RARE,
                    EnchantmentCategory.ARMOR,
                    new EquipmentSlot[]{ EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS,
                                         EquipmentSlot.FEET },
                    UUID.fromString("1e2860e7-95fb-4b49-b617-ddd1da80c3d2"),
                    ForgeMod.BLOCK_REACH.get(),
                    "growth",
                    1f,
                    4,
                    new Enchantment[]{ Enchantments.ALL_DAMAGE_PROTECTION, Enchantments.PROJECTILE_PROTECTION,
                                       Enchantments.BLAST_PROTECTION, Enchantments.FALL_PROTECTION,
                                       Enchantments.FIRE_PROTECTION },
                    false, false, true),
            "Growth",
            "Adds half a heart to your max health for every level, up to IV.");

    public static final RegistryObject<Enchantment> DEVASTATION = register(
            "devastation",
            () -> new CriticalHitEnchantment(3),
            "Devastation",
            "Allows for the chance (10% x level) of critical hits, which do 150% damage.");

    public static final RegistryObject<Enchantment> FIRST_STRIKE = register(
            "first_strike",
            () -> new CriticalHitEnchantment(1),
            "First Strike",
            "Does 25% more damage if the hit is the first strike.");

    public static final RegistryObject<Enchantment> CAREFUL = register(
            "careful",
            () -> new CarefulEnchantment(EquipmentSlot.MAINHAND),
            "Careful",
            "Prevents you from mining crops that aren't fully grown, and stems.");

    private static RegistryObject<Enchantment> register(
            String id, Supplier<Enchantment> enchantment, String name, String description
    ) {
        TRANSLATIONS.add(new Translation(id, name, description));
        return ENCHANTMENTS.register(id, enchantment);
    }

    public record Translation(String id, String name, String description) {}
}
