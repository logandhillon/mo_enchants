package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Map;

public class AngelsBlessingHelper {
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity == null || event.getAmount() < entity.getHealth()) return;

        ItemStack stack = ItemStack.EMPTY;

        if (entity.getMainHandItem().is(Items.TOTEM_OF_UNDYING)
            && EnchantmentHelper.getTagEnchantmentLevel(
                ModEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem()) > 0) {
            stack = entity.getMainHandItem();
        } else if (entity.getOffhandItem().is(Items.TOTEM_OF_UNDYING)
                   && EnchantmentHelper.getTagEnchantmentLevel(
                ModEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem()) > 0) {
            stack = entity.getOffhandItem();
        }

        if (!stack.isEmpty()) {
            totemAction(entity, stack);
            decrementLevel(stack);
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

    private static void decrementLevel(ItemStack stack) {
        int level = EnchantmentHelper.getTagEnchantmentLevel(ModEnchantments.ANGELS_BLESSING.get(), stack);

        // remove enchantment
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
        enchantments.remove(ModEnchantments.ANGELS_BLESSING.get());
        EnchantmentHelper.setEnchantments(enchantments, stack);

        // then add it back with 1 less level
        if (level > 1) {
            stack.enchant(ModEnchantments.ANGELS_BLESSING.get(), level - 1);
        }
    }
}
