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
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class Mooncake extends ItemFood {
    public Mooncake() {
        // Default constructor represents "this food gives 2 shank hunger, 2.0 saturation, and it is not food for wolf"
        super(2, 2.0F, false);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return MooncakeFillingType.getByOrdinal(stack.getMetadata()).hunger;
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return MooncakeFillingType.getByOrdinal(stack.getMetadata()).saturation;
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.mooncakecraft.mooncake." + MooncakeFillingType.getByOrdinal(stack.getMetadata()).localizationKey;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (tab == MooncakeConstants.TAB_MOONCAKE_CRAFT) {
            for (int meta = 1; meta < MooncakeFillingType.VALUES.length; meta++) {
                stacks.add(new ItemStack(this, 1, meta));
            }
        }
    }
}
