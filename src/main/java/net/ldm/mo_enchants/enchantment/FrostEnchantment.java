package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class FrostEnchantment extends Enchantment {
    public FrostEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == Enchantments.FLAMING_ARROWS)
            return false;
        if (ench == ModEnchantments.CONDUCTION.get())
            return false;
        if (ench == ModEnchantments.LEVITATING.get())
            return false;
        return ench != ModEnchantments.DETONATION.get();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        if (stack.getItem() == Items.BOW)
            return true;
        return stack.getItem() == Items.CROSSBOW;
    }
}
