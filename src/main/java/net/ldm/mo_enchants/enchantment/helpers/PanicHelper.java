package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PanicHelper {
    private static final Map<UUID, Long> COOLDOWNS = new HashMap<>();

    public static void onEntityAttacked(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        int level = entity.getItemBySlot(EquipmentSlot.FEET).getEnchantmentLevel(MoEnchantsEnchantments.PANIC.get());

        if (level < 1 || entity.getHealth() >= (4 * level)) return;

        long time = entity.level().getGameTime();

        // if is on cooldown (current time less than next use)
        if (time < COOLDOWNS.getOrDefault(entity.getUUID(), 0L)) return;

        entity.setHealth((4 * level) - 1);
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (level * 40), level));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (level * 40), level));
        if (entity.level().isClientSide()) {
            Minecraft.getInstance().gameRenderer.displayItemActivation(entity.getItemBySlot(EquipmentSlot.FEET));
        }
        ItemStack item = (entity.getItemBySlot(EquipmentSlot.FEET));
        if (item.hurt(15, RandomSource.create(), null)) {
            item.shrink(1);
            item.setDamageValue(0);
        }

        COOLDOWNS.put(entity.getUUID(), time + (240 / level));
    }
}