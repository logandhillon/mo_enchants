package net.ldm.mo_enchants.datagen.datapack;

import net.minecraft.data.worldgen.BootstrapContext;

/**
 * @author Logan Dhillon
 */
public interface DatapackEntryProvider<T> {
    void bootstrap(BootstrapContext<T> ctx);
}
