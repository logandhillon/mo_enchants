package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class FireCoatingEnchantment extends Enchantment {
    public FireCoatingEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        if (ench == Enchantments.FIRE_PROTECTION)
            return false;
        return ench != Enchantments.THORNS;
    }

    public static void onPlayerTickClient(PlayerTickEvent event) {
        if (event.player.getItemBySlot(EquipmentSlot.CHEST).getEnchantmentLevel(
                ModEnchantments.FIRE_COATING.get()) > 0) {
            event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2, 0, false, false));
        }
    }
}
