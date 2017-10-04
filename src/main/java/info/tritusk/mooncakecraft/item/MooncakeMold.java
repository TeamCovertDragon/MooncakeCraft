package info.tritusk.mooncakecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MooncakeMold extends Item {
    public MooncakeMold() {
        setCreativeTab(CreativeTabs.TOOLS);
        setUnlocalizedName("mooncakecraft.mooncakemold");
        setMaxStackSize(1);
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (!(stack.getItem() instanceof MooncakeMold))
            return EnumActionResult.PASS;

        if (!stack.hasTagCompound())
            return EnumActionResult.PASS;

        if (world.getBlockState(pos).getBlock() == Blocks.IRON_BLOCK) {
            if (!stack.getTagCompound().hasKey("hitCount"))
                stack.getTagCompound().setInteger("hitCount", 0);
            stack.getTagCompound().setInteger("hitCount", stack.getTagCompound().getInteger("hitCount") + 1);

            if (stack.getTagCompound().getInteger("hitCount") >= 5) {
                //TODO: Give Mooncake
                stack.setTagCompound(null);
            }
        }

        return EnumActionResult.PASS;
    }
}
