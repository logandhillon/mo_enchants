package net.ldm.mo_enchants.enchantment.event;

import net.ldm.mo_enchants.init.ModDamageSources;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class BloodthirstHelper {
    @SubscribeEvent
    public static void onItemRightClicked(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Level level = player.level();

        int enchLevel = event.getItemStack().getEnchantmentLevel(level.holderOrThrow(ModEnchantments.BLOODTHIRST));
        if (enchLevel < 1) return;

        if (player.getCooldowns().isOnCooldown(stack.getItem())) {
            if (level.isClientSide()) {
                player.displayClientMessage(
                        Component.translatable(
                                "cooldown.input", Component.translatable("enchantment.mo_enchants.bloodthirst")), true);
            }

            if (!level.isClientSide()) {
                level.playSound(
                        null,
                        event.getPos(),
                        SoundEvents.ENDERMAN_TELEPORT,
                        SoundSource.PLAYERS,
                        1,
                        0.5f);
            }
            return;
        }

        player.getCooldowns().addCooldown(stack.getItem(), 400);

        player.hurt(ModDamageSources.of(ModDamageSources.BLOODTHIRST, player), 5);
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 240, enchLevel - 1));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, 0));
        player.getUseItem().hurtAndBreak(15, player, EquipmentSlot.MAINHAND);

        if (!level.isClientSide()) {
            level.playSound(
                    null,
                    event.getPos(),
                    SoundEvents.PLAYER_ATTACK_KNOCKBACK,
                    SoundSource.PLAYERS,
                    1,
                    0.8f);
        }
    }
}
