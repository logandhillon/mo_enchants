package net.ldm.mo_enchants.datagen.tag;

import net.ldm.mo_enchants.MoEnchants;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Logan Dhillon
 */
public class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public ModEnchantmentTagsProvider(PackOutput pOutput,
                                      CompletableFuture<Provider> pProvider,
                                      @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MoEnchants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        ModEnchantments.TAGS.forEach(tag -> {
            if (tag.isCurse()) tag(EnchantmentTags.CURSE).addOptional(tag.key().location());
            if (tag.isTradeable()) tag(EnchantmentTags.TRADEABLE).addOptional(tag.key().location());

            if (tag.isTreasureOnly()) tag(EnchantmentTags.TREASURE).addOptional(tag.key().location());
            else tag(EnchantmentTags.IN_ENCHANTING_TABLE).addOptional(tag.key().location());
        });

        tag(ModTags.EXCLUSIVE_BOW_MOD_ENCHANTMENTS)
                .addOptional(ModEnchantments.CONDUCTION.location())
                .addOptional(ModEnchantments.DETONATION.location())
                .add(Enchantments.FLAME)
                .addOptional(ModEnchantments.FROST.location())
                .addOptional(ModEnchantments.LEVITATING.location());

        tag(ModTags.OP_WEAPON_ENCHANTMENTS)
                .addOptional(ModEnchantments.ULTIMATE_FINISH.location())
                .addOptional(ModEnchantments.REVENANT.location())
                .addOptional(ModEnchantments.BLOODTHIRST.location())
                .addOptional(ModEnchantments.LIFESTEAL.location());

        tag(ModTags.WEAPON_POST_ATTACK_ENCHANTMENTS)
                .addOptional(ModEnchantments.LIFESTEAL.location())
                .addOptional(ModEnchantments.VENOMFANG.location())
                .addOptional(ModEnchantments.ICE_ASPECT.location())
                .add(Enchantments.FIRE_ASPECT);

        tag(ModTags.CRITICAL_HIT_ENCHANTMENTS)
                .addOptional(ModEnchantments.CRITICAL_BLOW.location())
                .addOptional(ModEnchantments.FIRST_STRIKE.location());

        tag(EnchantmentTags.DAMAGE_EXCLUSIVE)
                .addOptional(ModEnchantments.AQUA_SLASH.location())
                .addOptional(ModEnchantments.HUNTER.location());

        tag(EnchantmentTags.MINING_EXCLUSIVE)
                .addOptional(ModEnchantments.REACH.location())
                .addOptional(ModEnchantments.SMELTING_TOUCH.location());

        tag(EnchantmentTags.ARMOR_EXCLUSIVE)
                .addOptional(ModEnchantments.VITALITY.location());

        tag(ModTags.FOOT_ARMOR_EXCLUSIVE)
                .add(Enchantments.SOUL_SPEED)
                .addOptional(ModEnchantments.SWIFTNESS.location())
                .addOptional(ModEnchantments.PANIC.location());
    }
}
