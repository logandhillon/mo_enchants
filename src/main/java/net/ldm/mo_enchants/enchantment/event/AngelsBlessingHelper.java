package net.ldm.mo_enchants.enchantment.event;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class AngelsBlessingHelper {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (event.getAmount() < entity.getHealth()) return;

        var angelsBlessing = entity.level().holderOrThrow(ModEnchantments.ANGELS_BLESSING);

        ItemStack stack = ItemStack.EMPTY;

        if (entity.getMainHandItem().is(Items.TOTEM_OF_UNDYING)
            && entity.getMainHandItem().getEnchantmentLevel(angelsBlessing) > 0) {
            stack = entity.getMainHandItem();
        } else if (entity.getOffhandItem().is(Items.TOTEM_OF_UNDYING)
                   && entity.getOffhandItem().getEnchantmentLevel(angelsBlessing) > 0) {
            stack = entity.getOffhandItem();
        }

        if (!stack.isEmpty()) {
            totemAction(entity, stack);
            decrementLevel(stack, angelsBlessing);
        }
    }

    private static void totemAction(LivingEntity entity, ItemStack stack) {
        if (entity instanceof ServerPlayer serverPlayer) {
            serverPlayer.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING), 1);
            CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, stack);
        }

        entity.setHealth(1.0F);
        entity.removeAllEffects();
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
        entity.level().broadcastEntityEvent(entity, (byte)35);
    }

    private static void decrementLevel(ItemStack stack, Holder<Enchantment> angelsBlessing) {
        EnchantmentHelper.updateEnchantments(
                stack, list -> {
                    int level = list.getLevel(angelsBlessing);
                    if (level <= 1) list.removeIf(other -> other == angelsBlessing);
                    else list.set(angelsBlessing, level - 1);
                });
    }
}
