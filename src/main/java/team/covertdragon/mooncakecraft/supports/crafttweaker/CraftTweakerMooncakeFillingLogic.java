package team.covertdragon.mooncakecraft.supports.crafttweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IWorld;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenClass;
import team.covertdragon.mooncakecraft.api.MooncakeFillingLogic;

@ModOnly("contenttweaker")
@ZenClass("mods.mooncakecraft.MooncakeFillingLogic")
@ZenRegister
public interface CraftTweakerMooncakeFillingLogic extends MooncakeFillingLogic {

    void onEaten(IItemStack item, IWorld world, IEntityLivingBase entity);

    @Override
    default void onEaten(ItemStack item, World world, EntityLivingBase entity) {
        this.onEaten(CraftTweakerMC.getIItemStack(item), CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIEntityLivingBase(entity));
    }
}
