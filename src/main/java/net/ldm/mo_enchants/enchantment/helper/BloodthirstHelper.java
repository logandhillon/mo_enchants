package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@EventBusSubscriber
public class BloodthirstHelper {
    @SubscribeEvent
    public static void onItemRightClicked(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Level level = player.level();

        int enchLevel = EnchantmentHelper.getTagEnchantmentLevel(
                ModEnchantments.BLOODTHIRST.get(), event.getItemStack());
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
                        Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(
                                ResourceLocation.withDefaultNamespace("entity.enderman.teleport"))),
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
        player.getUseItem().hurt(15, RandomSource.create(), null);
        player.getUseItem().shrink(1);
        player.getUseItem().setDamageValue(0);

        if (!level.isClientSide()) {
            level.playSound(
                    null,
                    event.getPos(),
                    Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(
                            ResourceLocation.withDefaultNamespace("entity.player.attack.knockback"))),
                    SoundSource.PLAYERS,
                    1,
                    0.8f);
        }
    }
}
