package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FireCoatingHelper {

    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.side.isClient()) return;

        if (event.player.getItemBySlot(EquipmentSlot.CHEST).getEnchantmentLevel(
                MoEnchantsEnchantments.FIRE_COATING.get()) > 0) {
            event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2, 0, false, false));
        }
    }
}
