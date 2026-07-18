package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class AquaphobiaCurseHelper {
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.player == null || !event.player.isInWater() || !hasAquaphobia(event.player)) return;

        if (event.player.tickCount % 10 == 0) {
            event.player.hurt(ModDamageSources.of(ModDamageSources.AQUAPHOBIA, event.player), 1);
        }
    }

    private static boolean hasAquaphobia(LivingEntity entity) {
        for (EquipmentSlot slot: new EquipmentSlot[]{
                EquipmentSlot.HEAD,
                EquipmentSlot.CHEST,
                EquipmentSlot.LEGS,
                EquipmentSlot.FEET
        }) {
            if (EnchantmentHelper.getTagEnchantmentLevel(
                    MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
                    entity.getItemBySlot(slot)) > 0) {
                return true;
            }
        }
        return false;
    }
}
