/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.item;

import info.tritusk.mooncakecraft.MooncakeConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class MooncakeFilling extends Item {

    public MooncakeFilling() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
        this.setUnlocalizedName("mooncakecraft.filling");
        setCreativeTab(MooncakeConstants.tabMooncakeCraft);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        if (this.isInCreativeTab(tab)) {
            for (int meta = 0; meta < MooncakeFillingType.VALUES.length; meta++) {
                stacks.add(new ItemStack(this, 1, meta));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + MooncakeFillingType.VALUES[stack.getMetadata()].localizationKey;
    }
}
