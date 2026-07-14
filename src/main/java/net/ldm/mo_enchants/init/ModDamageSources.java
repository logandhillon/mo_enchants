package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.datagen.LangProvider.Translation;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;

/**
 * @author Logan Dhillon
 */
public class ModDamageSources {
    public static final ArrayList<Translation<String>> TRANSLATIONS = new ArrayList<>();

    public static final ResourceKey<DamageType> AQUAPHOBIA          = create(
            "aquaphobia",
            "%1$s forgot they were aquaphobic",
            "%1$s forgot they were aquaphobic and tried to escape %2$s");
    public static final ResourceKey<DamageType> BAD_DREAMS          = create(
            "bad_dreams",
            "%s had a bad dream",
            "%1$s had a bad dream whilst trying to escape %2$s");
    public static final ResourceKey<DamageType> FREEZING            = create(
            "freezing",
            "%1$s froze to death",
            "%1$s froze to death against %2$s");
    public static final ResourceKey<DamageType> GENERIC_CURSE       = create(
            "generic_curse",
            "%1$s was cursed",
            "%1$s died of a curse whilst in combat with %2$s");
    public static final ResourceKey<DamageType> HARMING_CURSE       = create(
            "harming_curse",
            "%1$s hit themself too hard",
            "%1$s hit themself too hard whilst trying to kill %2$s");
    public static final ResourceKey<DamageType> LIFEFORCE_DISCHARGE = create(
            "lifeforce_discharge",
            "%1$s got their lifeforce discharged",
            "%1$s got their lifeforce discharged by %2$s");
    public static final ResourceKey<DamageType> BLOODTHIRST         = create(
            "bloodthirst",
            "%1$s got too bloodthirsty",
            "%1$s got too bloodthirsty trying to kill %2$s");

    private static ResourceKey<DamageType> create(String name, String deathMsg, String playerDeathMsg) {
        TRANSLATIONS.add(new Translation<>("death.attack.mo_enchants." + name, deathMsg));
        TRANSLATIONS.add(new Translation<>("death.attack.mo_enchants." + name + ".player", playerDeathMsg));
        return ResourceKey.create(Registries.DAMAGE_TYPE, MoEnchantsMod.modResource(name));
    }

    public static DamageSource of(ResourceKey<DamageType> type, LivingEntity victim) {
        return new DamageSource(
                victim.level()
                      .registryAccess()
                      .registryOrThrow(Registries.DAMAGE_TYPE)
                      .getHolderOrThrow(type)
        );
    }
}
