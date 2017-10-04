/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Mooncake extends ItemFood {
    public Mooncake() {
        // Default constructor represents "this food gives 2 shank hunger, 2.0 saturation, and it is not food for wolf"
        super(2, 2.0F, false);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
        this.setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return MooncakeFilling.VALUES[stack.getMetadata()].hunger;
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return MooncakeFilling.VALUES[stack.getMetadata()].saturation;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.mooncakecraft.mooncake." + MooncakeFilling.VALUES[stack.getMetadata()].localizationKey;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        if (this.isInCreativeTab(tab)) {
            for (int meta = 0; meta < MooncakeFilling.VALUES.length; meta++) {
                stacks.add(new ItemStack(this, 1, meta));
            }
        }
    }
}
