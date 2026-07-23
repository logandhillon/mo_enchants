package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class SavingGraceHelper {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        var player = event.getEntity();
        Level level = player.level();
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        int enchLevel = boots.getEnchantmentLevel(level.holderOrThrow(ModEnchantments.SAVING_GRACE));
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

            boots.hurtAndBreak(20, player, EquipmentSlot.FEET);
        }
    }
}