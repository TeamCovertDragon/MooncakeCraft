package info.tritusk.mooncakecraft.recipe;

import info.tritusk.mooncakecraft.MooncakeConstants;
import info.tritusk.mooncakecraft.item.MoonCakeUnshaped;
import info.tritusk.mooncakecraft.item.MooncakeMold;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class RecipeAddFilling extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    public RecipeAddFilling() {
        super.setRegistryName(MooncakeConstants.MODID, "recipeAddFilling");
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < inv.getWidth(); i++) {
            for (int j = 0; j < inv.getHeight(); j++) {
                if (!list.contains(inv.getStackInRowAndColumn(i, j).getItem()))
                    list.add(inv.getStackInRowAndColumn(i, j).getItem());
                if (inv.getStackInRowAndColumn(i, j).getItem() instanceof MooncakeMold && inv.getStackInRowAndColumn(i, j).hasTagCompound())
                    return false;
            }
        }

        boolean a = false, b = false;
        for (Item aItem : list) {
            if (aItem instanceof MoonCakeUnshaped)
                a = true;
            if (aItem instanceof MooncakeMold)
                b = true;
        }
        return a & b;
    }


    @Override
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
    public ItemStack getRecipeOutput() {
        return new ItemStack(MooncakeConstants.MOONCAKE_MOLD);
    }
}
