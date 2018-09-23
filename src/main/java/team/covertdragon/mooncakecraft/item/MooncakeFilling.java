/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.item;

import team.covertdragon.mooncakecraft.MooncakeConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import team.covertdragon.mooncakecraft.util.NBTUtil;

import javax.annotation.Nonnull;

public class MooncakeFilling extends Item {

    public MooncakeFilling() {
        this.setMaxDamage(0);
        this.setNoRepair();
        this.setTranslationKey("mooncakecraft.filling");
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (tab == MooncakeConstants.TAB_MOONCAKE_CRAFT) {

        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        String fillingType = NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE);
        if (!MooncakeRegistry.INSTANCE.isRegistered(fillingType)) {
            fillingType = MooncakeRegistry.FALLBACK_FILLING_TYPE;
        }
        return super.getTranslationKey() + "." + fillingType;
    }
}
