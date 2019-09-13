/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.item;

import net.minecraft.nbt.NBTTagCompound;
import team.covertdragon.mooncakecraft.MooncakeConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import team.covertdragon.mooncakecraft.util.NBTUtil;

import javax.annotation.Nonnull;

public class MoonCakeRaw extends Item {

    public MoonCakeRaw() {
        this.setMaxDamage(0);
        this.setNoRepair();
        this.setTranslationKey("item.mooncakecraft.mooncakeraw"); // Dumb check
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        String fillingType = NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE);
        if (!MooncakeRegistry.INSTANCE.isRegistered(fillingType)) {
            fillingType = MooncakeRegistry.FALLBACK_FILLING_TYPE;
        }
        return "item.mooncakecraft.mooncakeraw." + fillingType;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        if (this.isInCreativeTab(tab)) {
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
