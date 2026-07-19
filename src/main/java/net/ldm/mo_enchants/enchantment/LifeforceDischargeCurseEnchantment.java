package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LifeforceDischargeCurseEnchantment extends Enchantment {
    public LifeforceDischargeCurseEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onEntityAttacked(LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(
                MoEnchantsEnchantments.LIFEFORCE_DISCHARGE_CURSE.get());
        if (level < 1) return;

        attacker.hurt(ModDamageSources.of(ModDamageSources.LIFEFORCE_DISCHARGE, attacker), 1 + level);
    }
}
