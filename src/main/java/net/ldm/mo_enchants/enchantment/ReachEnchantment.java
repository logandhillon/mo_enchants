package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ReachEnchantment extends Enchantment {
    public ReachEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == Enchantments.BLOCK_FORTUNE)
            return false;
        if (ench == Enchantments.SILK_TOUCH)
            return false;
        return ench != MoEnchantsEnchantments.SMELTING_TOUCH.get();
    }
}
