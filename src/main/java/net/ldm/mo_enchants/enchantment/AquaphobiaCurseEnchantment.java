package net.ldm.mo_enchants.enchantment;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.ModDamageSources;
import net.ldm.mo_enchants.util.EnchantmentUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

public class AquaphobiaCurseEnchantment extends Enchantment {
    public AquaphobiaCurseEnchantment(EquipmentSlot... slots) {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, slots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    public static void onPlayerTickClient(PlayerTickEvent event) {
        if (event.player == null
            || !event.player.isInWater()
            || !EnchantmentUtils.hasArmorEnchantment(
                event.player, MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get())) {
            return;
        }

        if (event.player.tickCount % 10 == 0) {
            event.player.hurt(ModDamageSources.of(ModDamageSources.AQUAPHOBIA, event.player), 1);
        }
    }
}
