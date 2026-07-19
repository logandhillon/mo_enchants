package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class LifeStealEnchantment extends Enchantment {
    public LifeStealEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == MoEnchantsEnchantments.FREEZING_ASPECT.get())
            return false;
        if (ench == Enchantments.FIRE_ASPECT)
            return false;
        if (ench == MoEnchantsEnchantments.VENOMFANG.get())
            return false;
        return ench != MoEnchantsEnchantments.ULTIMATE_FINISH.get();
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onEntityAttacked(LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.LIFE_STEAL.get());
        if (level < 1 || Math.random() < level / 10f) return;

        attacker.setHealth(attacker.getHealth() + 1 + level);
    }
}
