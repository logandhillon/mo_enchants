package net.ldm.mo_enchants.datagen.datapack;

import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

/**
 * @author Logan Dhillon
 */
public class ModDamageTypeProvider implements DatapackEntryProvider<DamageType> {
    @Override
    public void bootstrap(BootstrapContext<DamageType> ctx) {
        create(ctx, ModDamageSources.AQUAPHOBIA, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.BLOODTHIRST, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.FREEZING, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.GENERIC_CURSE, DamageScaling.NEVER, 0f);
        create(ctx, ModDamageSources.HARMING_CURSE, DamageScaling.NEVER, 0.1f);
        create(ctx, ModDamageSources.LIFEFORCE_DISCHARGE, DamageScaling.NEVER, 0.1f);
    }

    private static void create(
            BootstrapContext<DamageType> ctx, ResourceKey<DamageType> type, DamageScaling scaling, float exhaustion
    ) {
        var id = type.location();
        ctx.register(type, new DamageType(id.getNamespace() + "." + id.getPath(), scaling, exhaustion));
    }
}
