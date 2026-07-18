package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.UltimateFinishEnchantment;
import net.ldm.mo_enchants.enchantment.helpers.*;
import net.minecraft.core.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event == null || event.getEntity() == null) return;

        AngelsBlessingHelper.onEntityAttacked(event);
        ConductionHelper.onEntityAttacked(event);
        FreezingAspectHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        FrostHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        HarmingCurseHelper.onEntityAttacked(event.getSource().getEntity());
        LevitatingHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        LifeforceDischargeCurseHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        LifeStealHelper.onEntityAttacked(event.getSource().getEntity());
        RevenantHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        ScorchingCurseHelper.onEntityAttacked(event.getEntity());
        ToxicAspectHelper.onEntityAttacked(event.getEntity(), event.getSource().getEntity());
        PanicHelper.onEntityAttacked(event.getEntity().level(), event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side.isClient() || event.phase != TickEvent.Phase.END) return;

        AquaphobiaCurseHelper.onPlayerTick(event);
        BoilingCurseHelper.onPlayerTick(event);
        FireCoatingHelper.onPlayerTick(event.player);
        FreezingCurseHelper.onPlayerTick(
                event.player.level(), new BlockPos(event.player.blockPosition()), event.player);
        MagmaWalkerHelper.onPlayerTick(event.player.level(), event.player.getOnPos(), event.player);
        SavingGraceHelper.onPlayerTick(event.player.level(), event.player.blockPosition(), event.player);
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        RockMendingHelper.onBlockBreak(event.getPlayer(), event.getState());
    }

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        UltimateFinishEnchantment.onExplosionDetonate(event);
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