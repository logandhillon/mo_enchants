package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments.Translation;
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
        // blocks and items
        add(MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get(), "Liquefying Magma Block");

        // misc.
        add("key.category.enchantments", "Enchantments");
        add("cooldown.generic", "§cThis ability is on cooldown!");
        add("cooldown.input", "§c%1$s is on cooldown!");

        for (Translation translation: MoEnchantsEnchantments.TRANSLATIONS) {
            add("enchantment.mo_enchants." + translation.id(), translation.name());
            add("enchantment.mo_enchants." + translation.id() + ".desc", translation.description());
        }
    }
}
