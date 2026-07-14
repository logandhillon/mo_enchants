package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

/**
 * @author Logan Dhillon
 */
public class ModDamageTypeProvider {
    public static void bootstrap(BootstapContext<DamageType> ctx) {
        create(ctx, ModDamageSources.AQUAPHOBIA, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.BAD_DREAMS, DamageScaling.NEVER, 0f);
        create(ctx, ModDamageSources.BLOODTHIRST, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.FREEZING, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.GENERIC_CURSE, DamageScaling.NEVER, 0f);
        create(ctx, ModDamageSources.HARMING_CURSE, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.LIFEFORCE_DISCHARGE, DamageScaling.NEVER, 0.1f);
    }

    private static void create(
            BootstapContext<DamageType> ctx, ResourceKey<DamageType> type, DamageScaling scaling, float exhaustion
    ) {
        var id = type.location();
        ctx.register(type, new DamageType(id.getNamespace() + "." + id.getPath(), scaling, exhaustion));
    }
}
