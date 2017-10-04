/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.recipe;

import info.tritusk.mooncakecraft.MooncakeConstants;
import info.tritusk.mooncakecraft.item.MoonCakeUnshaped;
import info.tritusk.mooncakecraft.item.MooncakeMold;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class RecipeAddFilling extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    public RecipeAddFilling() {
        super.setRegistryName(MooncakeConstants.MODID, "recipeaddfilling");
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < inv.getWidth(); i++) {
            for (int j = 0; j < inv.getHeight(); j++) {
                if (list.contains(inv.getStackInRowAndColumn(i, j).getItem()) && inv.getStackInRowAndColumn(i, j).getItem() != Items.AIR)
                    return false;
                list.add(inv.getStackInRowAndColumn(i, j).getItem());
                if (inv.getStackInRowAndColumn(i, j).getItem() instanceof MooncakeMold && inv.getStackInRowAndColumn(i, j).hasTagCompound())
                    return false;
            }
        }

        return list.contains(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM) && list.contains(MooncakeConstants.MOONCAKE_MOLD);
    }


    @Override
    @Nonnull
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        int meta = 0;
        for (int i = 0; i < inv.getWidth(); i++)
            for (int j = 0; j < inv.getHeight(); j++)
                if (inv.getStackInRowAndColumn(i, j).getItem() instanceof MoonCakeUnshaped)
                    meta = inv.getStackInRowAndColumn(i, j).getMetadata();
        ItemStack stack = new ItemStack(MooncakeConstants.MOONCAKE_MOLD);
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setInteger("meta", meta);
        stack.setTagCompound(tagCompound);
        return stack.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    @Nonnull
    public ItemStack getRecipeOutput() {
        return new ItemStack(MooncakeConstants.MOONCAKE_MOLD);
    }
}
