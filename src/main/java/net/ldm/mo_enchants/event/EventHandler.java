package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.*;
import net.ldm.mo_enchants.enchantment.helpers.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event.getEntity() == null || !(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        AngelsBlessingHelper.onEntityAttacked(event);
        ConductionHelper.onEntityAttacked(event, attacker);
        FreezingAspectHelper.onEntityAttacked(event, attacker);
        HarmingCurseHelper.onEntityAttacked(event, attacker);
        LevitatingEnchantment.onEntityAttacked(event, attacker);
        LifeforceDischargeCurseEnchantment.onEntityAttacked(attacker);
        LifeStealEnchantment.onEntityAttacked(attacker);
        RevenantEnchantment.onEntityAttacked(event.getEntity(), attacker);
        ScorchingCurseEnchantment.onEntityAttacked(event);
        ToxicAspectEnchantment.onEntityAttacked(event.getEntity(), attacker);
        PanicHelper.onEntityAttacked(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        if (event.side.isClient()) {
            AquaphobiaCurseEnchantment.onPlayerTickClient(event);
            BoilingCurseEnchantment.onPlayerTickClient(event);
            FireCoatingEnchantment.onPlayerTickClient(event);
            FreezingCurseEnchantment.onPlayerTickClient(event);
        }

        SavingGraceHelper.onPlayerTick(event);
    }

    @SubscribeEvent
    public static void onLivingTick(LivingTickEvent event) {
        MagmaWalkerEnchantment.onLivingTick(event);
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        GrowthHelper.onEquipmentChange(event);
        NightVisionEnchantment.onEquipmentChange(event);
        ReachHelper.onEquipmentChange(event);
        SwiftnessHelper.onEquipmentChange(event);
        WeightlessHelper.onEquipmentChange(event);
        DensityCurseHelper.onEquipmentChange(event);
    }
}