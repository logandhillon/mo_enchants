package net.ldm.mo_enchants.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.ldm.mo_enchants.init.ModEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.Optional;

/**
 * @author Logan Dhillon
 */
public class SmeltingTouchLootModifier extends LootModifier {
    public static final MapCodec<SmeltingTouchLootModifier> CODEC = RecordCodecBuilder.mapCodec(
            inst -> codecStart(inst).apply(inst, SmeltingTouchLootModifier::new));

    public SmeltingTouchLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext ctx) {
        Entity entity = ctx.getParamOrNull(LootContextParams.THIS_ENTITY);

        // if not a player or player's tool doesn't have smelting touch
        if (!(entity instanceof Player player) || EnchantmentHelper.getTagEnchantmentLevel(
                ModEnchantments.SMELTING_TOUCH, player.getMainHandItem()) <= 0)
            return loot;

        for (int i = 0; i < loot.size(); i++) {
            ItemStack stack = loot.get(i);

            Optional<RecipeHolder<SmeltingRecipe>> recipe = player.level().getRecipeManager().getRecipeFor(
                    RecipeType.SMELTING, new SingleRecipeInput(stack), player.level());

            int finalI = i;
            recipe.ifPresent(r -> {
                ItemStack result = r.value().getResultItem(player.level().registryAccess()).copy();
                result.setCount(result.getCount() * stack.getCount());
                loot.set(finalI, result);
            });
        }

        return loot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
