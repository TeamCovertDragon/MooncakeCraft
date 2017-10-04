/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.recipe;

import com.google.gson.JsonObject;
import info.tritusk.mooncakecraft.MooncakeConstants;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MooncakeRecipe extends ShapelessOreRecipe {

    public MooncakeRecipe(ResourceLocation group, NonNullList<Ingredient> ingredients) {
        super(group, ingredients, new ItemStack(MooncakeConstants.MOONCAKE_MOLD));
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return super.getCraftingResult(inv); // TODO: manipulate the result upon crafted
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    public static final class Factory implements IRecipeFactory {
        @Override
        public IRecipe parse(JsonContext context, JsonObject json) {
            ShapelessOreRecipe r = ShapelessOreRecipe.factory(context, json);
            return new MooncakeRecipe(new ResourceLocation(r.getGroup()), r.getIngredients());
        }
    }
}
