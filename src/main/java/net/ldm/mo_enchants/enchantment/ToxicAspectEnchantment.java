package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ToxicAspectEnchantment extends Enchantment {
    public ToxicAspectEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == ModEnchantments.FREEZING_ASPECT.get())
            return false;
        if (ench == Enchantments.FIRE_ASPECT)
            return false;
        return ench != ModEnchantments.LIFESTEAL.get();
    }

    public static void onEntityAttacked(LivingEntity victim, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.VENOMFANG.get());
        victim.addEffect(new MobEffectInstance(MobEffects.POISON, 50 * (level + 1), level - 1, false, false));
    }
}
