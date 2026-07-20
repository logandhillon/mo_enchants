package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class UltimateFinishEnchantment extends Enchantment {
    public UltimateFinishEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == ModEnchantments.LIFESTEAL.get())
            return false;
        return ench != ModEnchantments.REVENANT.get();
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
