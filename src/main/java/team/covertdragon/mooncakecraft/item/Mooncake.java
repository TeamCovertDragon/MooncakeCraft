/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import team.covertdragon.mooncakecraft.MooncakeConstants;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import team.covertdragon.mooncakecraft.util.NBTUtil;

import javax.annotation.Nonnull;

public class Mooncake extends ItemFood {

    public Mooncake() {
        // Default constructor represents "this food gives 2 shank hunger, 2.0 saturation, and it is not food for wolf"
        super(2, 2.0F, false);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return MooncakeRegistry.INSTANCE.getHungerHealFor(NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE));
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return MooncakeRegistry.INSTANCE.getSaturationFor(NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE));
    }

    // Copy of ItemFood::onItemUseFinish with changes
    // Changes:
    //   1. World.playSound call is moved to first
    //   2. ItemFood.onEaten is replaced by MooncakeFillingLogic.onEaten;
    //      the call itself is moved immediately after World.playSound call
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
        world.playSound(null, entity.posX, entity.posY, entity.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        MooncakeRegistry.INSTANCE.getBehaviorFor(NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE)).onEaten(stack, world, entity);
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            player.getFoodStats().addStats(this, stack);
            player.addStat(StatList.getObjectUseStats(this));
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)player, stack);
            }
        }
        stack.shrink(1);
        return stack;
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        String fillingType = NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE);
        if (!MooncakeRegistry.INSTANCE.isRegistered(fillingType)) {
            fillingType = MooncakeRegistry.FALLBACK_FILLING_TYPE;
        }
        return "item.mooncakecraft.mooncake." + fillingType;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (tab == MooncakeConstants.TAB_MOONCAKE_CRAFT) {
            for (String type : MooncakeRegistry.INSTANCE.getAllKnownFillings()) {
                if (MooncakeRegistry.FALLBACK_FILLING_TYPE.equals(type)) {
                    continue;
                }
                ItemStack item = new ItemStack(this);
                NBTTagCompound data = new NBTTagCompound();
                data.setString(MooncakeConstants.KEY_FILLING_TYPE, type);
                item.setTagCompound(data);
                stacks.add(item);
            }
        }
    }
}
