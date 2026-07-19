package net.ldm.mo_enchants.event;

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
        LevitatingHelper.onEntityAttacked(event, attacker);
        LifeforceDischargeCurseHelper.onEntityAttacked(attacker);
        LifeStealHelper.onEntityAttacked(attacker);
        RevenantHelper.onEntityAttacked(event.getEntity(), attacker);
        ScorchingCurseHelper.onEntityAttacked(event.getEntity());
        ToxicAspectHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        PanicHelper.onEntityAttacked(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.side.isClient() || event.phase != TickEvent.Phase.END) return;

        AquaphobiaCurseHelper.onPlayerTick(event);
        BoilingCurseHelper.onPlayerTick(event);
        FireCoatingHelper.onPlayerTick(event);
        FreezingCurseHelper.onPlayerTick(event);
        SavingGraceHelper.onPlayerTick(event.player.level(), event.player.blockPosition(), event.player);
    }

    @SubscribeEvent
    public static void onLivingTick(LivingTickEvent event) {
        MagmaWalkerHelper.onLivingTick(event);
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        GrowthHelper.onEquipmentChange(event);
        NightVisionHelper.onEquipmentChange(event);
        ReachHelper.onEquipmentChange(event);
        SwiftnessHelper.onEquipmentChange(event);
        WeightlessHelper.onEquipmentChange(event);
    }
}