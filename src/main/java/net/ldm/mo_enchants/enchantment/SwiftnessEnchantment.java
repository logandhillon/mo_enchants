package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class SwiftnessEnchantment extends Enchantment {
    public SwiftnessEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == MoEnchantsEnchantments.PANIC.get())
            return false;
        return ench != Enchantments.SOUL_SPEED;
    }
}
