package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
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
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

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
        return super.checkCompatibility(ench)
               && ench != ModEnchantments.DETONATION.get()
               && ench != Enchantments.FLAMING_ARROWS
               && ench != ModEnchantments.FROST.get()
               && ench != ModEnchantments.CONDUCTION.get();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        if (stack.getItem() == Items.BOW)
            return true;
        return stack.getItem() == Items.CROSSBOW;
    }

    public static void onEntityAttacked(LivingIncomingDamageEvent event, LivingEntity attacker) {
        int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.LEVITATING.get());
        if (level < 1) return;

        event.getEntity().addEffect(new MobEffectInstance(MobEffects.LEVITATION, level * 10, 0));
    }
}
