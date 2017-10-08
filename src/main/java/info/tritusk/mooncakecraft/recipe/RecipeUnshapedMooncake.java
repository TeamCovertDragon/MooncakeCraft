package info.tritusk.mooncakecraft.recipe;

import info.tritusk.mooncakecraft.MooncakeConstants;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.ArrayList;

public class RecipeUnshapedMooncake extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    private ItemStack resultITem;
    private int bucketSlot;

    public RecipeUnshapedMooncake() {
        super.setRegistryName(MooncakeConstants.MODID, "recipe_unshaped_mooncake");
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        for (int i = 0; i < inv.getWidth(); i++) {
            for (int j = 0; j < inv.getHeight(); j++) {
                if (!inv.getStackInRowAndColumn(i, j).isEmpty())
                    list.add(inv.getStackInRowAndColumn(i, j));
                if (inv.getStackInRowAndColumn(i, j).getItem() instanceof ItemPotion)
                    bucketSlot = i + j * 3;
            }
        }

        if (list.size() != 3)
            return false;

        boolean flag1 = false, flag2 = false, flag3 = false;
        for (ItemStack stack : list) {
            if (stack.getItem() == Items.POTIONITEM && stack.hasTagCompound() && stack.getTagCompound().getString("Potion").equals("minecraft:water")) {
                flag1 = true;
            }
            //  ↓Fake IDEA Alert
            if (stack.getItem() == MooncakeConstants.MOONCAKE_FILLING) {
                flag2 = true;
                resultITem = new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, stack.getMetadata());
            }

            if (stack.getItem() == MooncakeConstants.WHEAT_FLOUR)
                flag3 = true;
        }
        return flag1 && flag2 && flag3;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return resultITem.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 3;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, 0);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> list = net.minecraftforge.common.ForgeHooks.defaultRecipeGetRemainingItems(inv);
        list.set(bucketSlot, new ItemStack(Items.GLASS_BOTTLE, 1));
        return list;
    }
}
