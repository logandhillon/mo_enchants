package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author Logan Dhillon
 */
public class AttributeModifierEnchantment extends Enchantment {
    private final EquipmentSlot[] slots;
    private final UUID            uuid;
    private final Attribute       attribute;
    private final String          attributeName;
    private final float           attributeCoefficient;
    private final int             maxLevel;
    private final Enchantment[]   incompatibleEnchantments;
    private final boolean         isCurse;
    private final boolean         isTreasure;
    private final boolean         isTradable;

    public AttributeModifierEnchantment(
            Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots, UUID attributeUUID, Attribute attribute,
            String attributeName, float attributeCoefficient, int maxLevel, Enchantment[] incompatibleEnchantments,
            boolean isCurse, boolean isTreasure, boolean isTradable
    ) {
        super(rarity, category, slots);
        this.slots = slots;
        this.uuid = attributeUUID;
        this.attribute = attribute;
        this.attributeName = attributeName;
        this.attributeCoefficient = attributeCoefficient;
        this.maxLevel = maxLevel;
        this.incompatibleEnchantments = incompatibleEnchantments;
        this.isCurse = isCurse;
        this.isTreasure = isTreasure;
        this.isTradable = isTradable;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public boolean isCurse() {
        return isCurse;
    }

    @Override
    public boolean isTreasureOnly() {
        return isTreasure;
    }

    @Override
    public boolean isTradeable() {
        return isTradable;
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return !(other instanceof AttributeModifierEnchantment)
               && Arrays.stream(incompatibleEnchantments).noneMatch(e -> e == other);
    }

    public void updateAttribute(LivingEquipmentChangeEvent event) {
        if (Arrays.stream(slots).noneMatch(slot -> slot == event.getSlot())) return;

        AttributeInstance attribute = event.getEntity().getAttributes().getInstance(this.attribute);
        if (attribute == null) return;

        if (attribute.getModifier(uuid) != null) {
            attribute.removePermanentModifier(uuid);
        }

        int level = event.getTo().getEnchantmentLevel(this);
        if (level <= 0) return;

        attribute.addPermanentModifier(new AttributeModifier(
                uuid,
                "mo_enchants:" + attributeName,
                attributeCoefficient * level,
                Operation.ADDITION
        ));
    }
}
