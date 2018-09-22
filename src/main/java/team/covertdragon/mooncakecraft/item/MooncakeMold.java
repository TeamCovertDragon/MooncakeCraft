/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.item;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.oredict.OreDictionary;
import team.covertdragon.mooncakecraft.MooncakeConstants;

public class MooncakeMold extends Item {
    public MooncakeMold() {
        setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT);
        setUnlocalizedName("mooncakecraft.mooncakemold");
        setMaxStackSize(1);
    }

    @Override
    public int getMetadata(ItemStack stack) {
        return stack.hasTagCompound() ? 1 : 0;
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (!(stack.getItem() instanceof MooncakeMold))
            return EnumActionResult.PASS;

        if (!stack.hasTagCompound())
            return EnumActionResult.PASS;

        int target = OreDictionary.getOreID("blockIron");
        for (int id : OreDictionary.getOreIDs(new ItemStack(world.getBlockState(pos).getBlock())))
        {
        	if (target == id) {
        		world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_METAL_HIT, SoundCategory.BLOCKS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        		world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_WOOD_HIT, SoundCategory.BLOCKS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                if (!stack.getTagCompound().hasKey("hitCount"))
                    stack.getTagCompound().setInteger("hitCount", 0);
                stack.getTagCompound().setInteger("hitCount", stack.getTagCompound().getInteger("hitCount") + 1);

                if (stack.getTagCompound().getInteger("hitCount") >= 5) {
                    ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(MooncakeConstants.RAW_MOONCAKE_ITEM, 1, stack.getTagCompound().getInteger("meta")));
                    stack.setTagCompound(null);
                }

                return EnumActionResult.SUCCESS;
            }
        }

        return EnumActionResult.PASS;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTagCompound()) {
            tooltip.add(new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, stack.getTagCompound().getInteger("meta")).getDisplayName());
        }
    }
}
