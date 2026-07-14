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

    public static final ResourceKey<DamageType> BAD_DREAMS = create(
            "bad_dreams",
            "%s had a bad dream",
            "%s had a bad dream while trying to escape %s");

    private static ResourceKey<DamageType> create(String name, String deathMsg, String playerDeathMsg) {
        TRANSLATIONS.add(new Translation<>("death.attack.mo_enchants." + name, deathMsg));
        TRANSLATIONS.add(new Translation<>("death.attack.mo_enchants." + name + ".player", playerDeathMsg));
        return ResourceKey.create(Registries.DAMAGE_TYPE, MoEnchantsMod.modResource("bad_dreams"));
    }

    public static DamageSource badDreams(LivingEntity entity) {
        return new DamageSource(
                entity.level()
                      .registryAccess()
                      .registryOrThrow(Registries.DAMAGE_TYPE)
                      .getHolderOrThrow(BAD_DREAMS)
        );
    }
}
