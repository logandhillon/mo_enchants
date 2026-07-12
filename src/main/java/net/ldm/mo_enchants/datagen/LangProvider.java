package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

/**
 * @author Logan Dhillon
 */
public class LangProvider extends LanguageProvider {
    public LangProvider(PackOutput pack) {
        super(pack, MoEnchantsMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}
