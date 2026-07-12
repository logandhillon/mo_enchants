package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class MagmaWalkerEnchantment extends Enchantment {
    public MagmaWalkerEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return ench != Enchantments.FROST_WALKER;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
