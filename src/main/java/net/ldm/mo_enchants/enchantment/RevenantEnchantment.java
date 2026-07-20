package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
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
        return super.checkCompatibility(ench)
               && ench != ModEnchantments.BLOODTHIRST.get()
               && ench != ModEnchantments.ULTIMATE_FINISH.get();
    }

    public static void onEntityAttacked(LivingEntity victim, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.REVENANT.get());

        if (level < 1
            || victim.getMobType() != MobType.UNDEAD
            || victim.getType().is(ModTags.BOSSES)) {
            return;
        }

        if (Math.random() * 100 < level + 1) {
            victim.hurt(victim.damageSources().mobAttack(attacker), Float.MAX_VALUE);
        }
    }
}
