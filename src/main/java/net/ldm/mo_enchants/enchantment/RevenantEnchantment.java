package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class RevenantEnchantment extends Enchantment {
    public RevenantEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == MoEnchantsEnchantments.BLOODTHIRST.get())
            return false;
        return ench != MoEnchantsEnchantments.ULTIMATE_FINISH.get();
    }
}
