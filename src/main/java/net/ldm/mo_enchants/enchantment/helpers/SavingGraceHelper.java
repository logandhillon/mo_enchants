package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class SavingGraceHelper {
    public static void onPlayerTick(PlayerTickEvent event) {
        var player = event.player;
        Level level = player.level();
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        int enchLevel = boots.getEnchantmentLevel(MoEnchantsEnchantments.SAVING_GRACE.get());
        int voidThreshold = level.dimension() == Level.OVERWORLD ? -74 : -10; // 10 blocks below void

        if (enchLevel < 1 || player.getY() > voidThreshold || player.getDeltaMovement().y > 0) return;

        if (level.isClientSide()) {
            // client stuff
            Minecraft.getInstance().gameRenderer.displayItemActivation(boots);
        } else {
            // server stuff
            player.setDeltaMovement(player.getDeltaMovement().x, 10, player.getDeltaMovement().z);
            player.hurtMarked = true;
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0, false, false));
            level.playSound(null, player.blockPosition(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 2, 1);

            if (boots.hurt(20, RandomSource.create(), null)) {
                boots.shrink(1);
                boots.setDamageValue(0);
            }
        }
    }
}