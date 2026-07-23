package net.ldm.mo_enchants.datagen;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModBlocks;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * @author Logan Dhillon
 */
public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput pack) {
        super(pack, MoEnchants.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // blocks and items
        add(ModBlocks.LIQUEFYING_MAGMA_BLOCK.value(), "Liquefying Magma Block");

        // misc.
        add("key.category.enchantments", "Enchantments");
        add("cooldown.generic", "§cThis ability is on cooldown!");
        add("cooldown.input", "§c%1$s is on cooldown!");

        for (var translation: ModEnchantments.TRANSLATIONS) {
            add("enchantment.mo_enchants." + translation.id(), translation.name());
            add("enchantment.mo_enchants." + translation.id() + ".desc", translation.description());
        }

        for (var translation: ModDamageSources.TRANSLATIONS) {
            add(translation.key(), translation.msg());
        }
    }

    public record Translation<T>(T key, String msg) {}
}
