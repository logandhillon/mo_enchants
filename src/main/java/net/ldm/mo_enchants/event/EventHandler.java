package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.helper.AngelsBlessingHelper;
import net.ldm.mo_enchants.enchantment.helper.AquaphobiaCurseHelper;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        AngelsBlessingHelper.onEntityAttacked(event);
//        ConductionHelper.onEntityAttacked(event, attacker);
//        FreezingAspectHelper.onEntityAttacked(event, attacker);
//        HarmingCurseEnchantment.onEntityAttacked(event, attacker);
//        LevitatingEnchantment.onEntityAttacked(event, attacker);
//        LifeforceDischargeCurseEnchantment.onEntityAttacked(attacker);
//        LifeStealEnchantment.onEntityAttacked(attacker);
//        RevenantEnchantment.onEntityAttacked(event.getEntity(), attacker);
//        ScorchingCurseEnchantment.onEntityAttacked(event);
//        ToxicAspectEnchantment.onEntityAttacked(event.getEntity(), attacker);
//        PanicHelper.onEntityAttacked(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (event.getEntity().level().isClientSide) {
            AquaphobiaCurseHelper.onPlayerTickClient(event);
//            BoilingCurseEnchantment.onPlayerTickClient(event);
//            FireCoatingEnchantment.onPlayerTickClient(event);
//            FreezingCurseEnchantment.onPlayerTickClient(event);
        }

//        SavingGraceHelper.onPlayerTick(event);
//        MagmaWalkerEnchantment.onLivingTick(event);
    }
//
//    @SubscribeEvent
//    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
//        NightVisionEnchantment.onEquipmentChange(event);
//    }
}