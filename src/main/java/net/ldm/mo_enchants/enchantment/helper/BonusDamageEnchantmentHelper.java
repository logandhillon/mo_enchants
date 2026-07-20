package net.ldm.mo_enchants.enchantment.helper;

import net.ldm.mo_enchants.init.ModEnchantments;
import net.ldm.mo_enchants.init.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber
public class BonusDamageEnchantmentHelper {

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;
        LivingEntity victim = event.getEntity();

        if (victim instanceof Animal) {
            int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.HUNTER.get());
            if (level >= 1) {
                event.setAmount(event.getAmount() + (level * 1.5f));
            }
            return;
        }

        if (victim.getType().is(ModTags.WATER_WEAK_MOBS)) {
            int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.AQUA_SLASH.get());
            if (level >= 1) {
                event.setAmount(event.getAmount() + (level * 1.5f));
            }
            return;
        }

        if (victim.getHealth() == victim.getMaxHealth()) {
            int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.FIRST_STRIKE.get());

            if (level >= 1) {
                event.setAmount(event.getAmount() * 1.25f);
                playBonusDamageSound(attacker);
            }
            return;
        }

        int level = attacker.getMainHandItem().getEnchantmentLevel(ModEnchantments.CRITICAL_BLOW.get());
        if (level > 0 && Math.random() >= 0.1 * level) {
            event.setAmount(event.getAmount() * 1.5f);
            playBonusDamageSound(attacker);
        }
    }

    /**
     * Plays a pitched-up trident throw sound effect on the server side.
     *
     * @param attacker source of sound effect; the attacker
     */
    private static void playBonusDamageSound(LivingEntity attacker) {
        if (!attacker.level().isClientSide) {
            attacker.level().playSound(
                    attacker,
                    attacker.blockPosition(),
                    Objects.requireNonNull(
                            ForgeRegistries.SOUND_EVENTS.getValue(
                                    ResourceLocation.withDefaultNamespace("item.trident.throw"))),
                    SoundSource.PLAYERS,
                    1,
                    2);
        }
    }
}
