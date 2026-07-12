package net.ldm.mo_enchants.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.Optional;

/**
 * @author Logan Dhillon
 */
public class SmeltingTouchLootModifier extends LootModifier {
    public static final Codec<SmeltingTouchLootModifier> CODEC = RecordCodecBuilder.create(
            inst -> codecStart(inst).apply(inst, SmeltingTouchLootModifier::new));

    protected SmeltingTouchLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext ctx) {
        Entity entity = ctx.getParamOrNull(LootContextParams.THIS_ENTITY);

        // if not a player or player's tool doesn't have smelting touch
        if (!(entity instanceof Player player) || EnchantmentHelper.getTagEnchantmentLevel(
                MoEnchantsEnchantments.SMELTING_TOUCH.get(), player.getMainHandItem()) <= 0)
            return loot;

        for (int i = 0; i < loot.size(); i++) {
            ItemStack stack = loot.get(i);

            Optional<SmeltingRecipe> recipe = player.level().getRecipeManager().getRecipeFor(
                    RecipeType.SMELTING, new SimpleContainer(stack), player.level());

            int finalI = i;
            recipe.ifPresent(r -> {
                ItemStack result = r.getResultItem(player.level().registryAccess()).copy();
                result.setCount(result.getCount() * stack.getCount());
                loot.set(finalI, result);
            });
        }

        return loot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
