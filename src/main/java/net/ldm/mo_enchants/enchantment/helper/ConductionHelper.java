package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class ConductionHelper {
    public static void onEntityAttacked(LivingHurtEvent event, LivingEntity attacker) {
        Level level;
        if (attacker.getMainHandItem().getEnchantmentLevel(MoEnchantsEnchantments.CONDUCTION.get()) > 0
            && (level = event.getEntity().level()).isThundering()
            && !level.isClientSide
        ) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(event.getEntity().getOnPos().getCenter());
                lightning.setVisualOnly(false);
                level.addFreshEntity(lightning);
            }
        }
    }
}
