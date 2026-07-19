package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

public class NightVisionEnchantment extends Enchantment {
    public NightVisionEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, slots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return ench != Enchantments.AQUA_AFFINITY;
    }

    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getSlot() != EquipmentSlot.HEAD || !(event.getEntity() instanceof Player player)) return;

        boolean hadNightVision = event.getFrom().getEnchantmentLevel(ModEnchantments.NIGHT_VISION.get()) > 0;
        boolean hasNightVision = event.getTo().getEnchantmentLevel(ModEnchantments.NIGHT_VISION.get()) > 0;

        if (hasNightVision == hadNightVision) {
            return;
        }

        if (hasNightVision) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false, false));
        } else {
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }
}
