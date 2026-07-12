package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class WeightlessEnchantment extends Enchantment {
    public WeightlessEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, slots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == Enchantments.THORNS)
            return false;
        return ench != MoEnchantsEnchantments.DENSITY_CURSE.get();
    }
}
