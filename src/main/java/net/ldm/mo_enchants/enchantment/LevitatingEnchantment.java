package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class LevitatingEnchantment extends Enchantment {
    public LevitatingEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.BREAKABLE, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == Enchantments.FLAMING_ARROWS)
            return false;
        if (ench == MoEnchantsEnchantments.FROST.get())
            return false;
        if (ench == MoEnchantsEnchantments.CONDUCTION.get())
            return false;
        return ench != MoEnchantsEnchantments.DETONATION.get();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        if (stack.getItem() == Items.BOW)
            return true;
        return stack.getItem() == Items.CROSSBOW;
    }

    public static void onEntityAttacked(LivingHurtEvent event, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.LEVITATING.get());
        if (level < 1) return;

        event.getEntity().addEffect(new MobEffectInstance(MobEffects.LEVITATION, level * 10, 0));
    }
}
