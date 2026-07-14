package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

/**
 * @author Logan Dhillon
 */
public class ModDamageTypeProvider {
    public static void bootstrap(BootstapContext<DamageType> ctx) {
        ctx.register(ModDamageSources.BAD_DREAMS, new DamageType("mo_enchants.bad_dreams", DamageScaling.NEVER, 0f));
    }
}
