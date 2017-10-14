/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import info.tritusk.mooncakecraft.item.MooncakeFillingType;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.gui.IGuiIngredientGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.wrapper.ICustomCraftingRecipeWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JEIPlugin
public class MooncakeJEICompatibility implements IModPlugin {
    private static ItemStack waterBottle = new ItemStack(Items.POTIONITEM);

    @Override
    public void register(IModRegistry registry) {
        //init water bottle
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("Potion", "minecraft:water");
        waterBottle.setTagCompound(tag);

        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.MOONCAKE_FILLING, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.RAW_MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.ICON, 1, 0));

        registerCustomRecipe(registry);
    }

    private void registerCustomRecipe(IModRegistry registry) {
        Collection<IRecipeWrapper> recipes = new ArrayList<>();
        for (int i = 1; i < MooncakeFillingType.values().length; i++) {
            recipes.add(new CustomRecipeHandler(i));
        }
        registry.addRecipes(recipes, VanillaRecipeCategoryUid.CRAFTING);
    }

    private static class CustomRecipeHandler implements ICustomCraftingRecipeWrapper {
        int metadata;

        CustomRecipeHandler(int meta) {
            metadata = meta;
        }

        @Override
        public void setRecipe(IRecipeLayout recipeLayout, IIngredients ingredients) {
            recipeLayout.setShapeless();
            IGuiIngredientGroup<ItemStack> group = recipeLayout.getIngredientsGroup(ItemStack.class);
            this.getIngredients(ingredients);
            group.set(ingredients);
        }

        @Override
        public void getIngredients(IIngredients ingredients) {
            List<ItemStack> inputs = new ArrayList<>();
            inputs.add(new ItemStack(MooncakeConstants.MOONCAKE_FILLING, 1, metadata));
            inputs.add(waterBottle);
            inputs.add(new ItemStack(MooncakeConstants.WHEAT_FLOUR));
            ingredients.setInputs(ItemStack.class, inputs);
            ingredients.setOutput(ItemStack.class, new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, metadata));
        }
    }
}
