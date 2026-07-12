package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.UltimateFinishEnchantment;
import net.ldm.mo_enchants.enchantment.helpers.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onEntityAttacked( LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            AngelsBlessingHelper.execute(event.getEntity(), event.getAmount());
            ConductionHelper.execute(event.getEntity().level(), event.getEntity().blockPosition(), event.getSource().getEntity());
            FreezingAspectHelper.execute(event.getEntity(), event.getSource().getEntity());
            FrostHelper.execute(event.getEntity(), event.getSource().getEntity());
            HarmingCurseHelper.execute(event.getSource().getEntity());
            LevitatingHelper.execute(event.getEntity(), event.getSource().getEntity());
            LifeforceDischargeCurseHelper.execute(event.getEntity(), event.getSource().getEntity());
            LifeStealHelper.execute(event.getSource().getEntity());
            RevenantHelper.execute(event.getEntity(), event.getSource().getEntity());
            ScorchingCurseHelper.execute(event.getEntity());
            ToxicAspectHelper.execute(event.getEntity(), event.getSource().getEntity());
            PanicHelper.execute(event.getEntity().level(), event.getEntity());
        }
    }

    @SubscribeEvent
    public static void onPlayerTick( TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            AquaphobiaCurseHelper.execute(event.player.level(), event.player.blockPosition(), event.player);
            BoilingCurseHelper.execute(event.player.level(), new BlockPos(event.player.blockPosition()), event.player);
            FireCoatingHelper.execute(event.player);
            FreezingCurseHelper.execute(event.player.level(), new BlockPos(event.player.blockPosition()), event.player);
            MagmaWalkerHelper.execute(event.player.level(), event.player.getOnPos(), event.player);
            SavingGraceHelper.execute(event.player.level(), event.player.blockPosition(), event.player);
        }
    }

    @SubscribeEvent
    public static void onPlayerInBed( PlayerSleepInBedEvent event) {
        BadDreamsCurseHelper.execute(event.getEntity());
    }

    @SubscribeEvent
    public static void onRightClickItem( PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand()) return;
        BloodthirstHelper.execute(event.getLevel(), event.getPos(), event.getEntity());
    }

    @SubscribeEvent
    public static void onBlockBreak( BlockEvent.BreakEvent event) {
        CarefulEnchantmentHelper.execute(event);
        RockMendingHelper.execute(event.getPlayer(), event.getState());
    }

    @SubscribeEvent
    public static void onEntityDeath( LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            DetonationHelper.execute(event.getEntity().level(), event.getEntity().blockPosition(), event.getSource().getEntity());
            UltimateFinishEnchantment.onEntityDeath(event);
        }
    }

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        UltimateFinishEnchantment.onExplosionDetonate(event);
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        DensityCurseHelper.execute(event);
        GrowthHelper.execute(event);
        NightVisionHelper.execute(event);
        ReachHelper.execute(event);
        SwiftnessHelper.execute(event);
        WeightlessHelper.execute(event);
    }
}