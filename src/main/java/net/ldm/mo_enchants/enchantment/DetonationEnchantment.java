package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class DetonationEnchantment extends Enchantment {
    public DetonationEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BOW, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return super.checkCompatibility(ench)
               && ench != ModEnchantments.CONDUCTION.get()
               && ench != Enchantments.FLAMING_ARROWS
               && ench != ModEnchantments.FROST.get()
               && ench != ModEnchantments.LEVITATING.get();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        if (stack.getItem() == Items.BOW)
            return true;
        return stack.getItem() == Items.CROSSBOW;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
