package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.UnknownNullability;

public class ScorchingCurseEnchantment extends Enchantment {
    public ScorchingCurseEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, slots);
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

    public static void onEntityAttacked(@UnknownNullability LivingIncomingDamageEvent event) {
        if (EnchantmentUtils.hasArmorEnchantment(event.getEntity(), ModEnchantments.SCORCHING_CURSE.get())) {
            event.getEntity().setSecondsOnFire(5);
        }
    }
}
