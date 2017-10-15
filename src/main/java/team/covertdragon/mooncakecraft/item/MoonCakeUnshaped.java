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

public class MoonCakeUnshaped extends Item {

    public MoonCakeUnshaped() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
        this.setUnlocalizedName("item.mooncakecraft.mooncakeunshaped"); // Dumb check
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.mooncakecraft.mooncakeunshaped." + MooncakeFillingType.getByOrdinal(stack.getMetadata()).localizationKey;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> stacks) {
        if (tab == MooncakeConstants.TAB_MOONCAKE_CRAFT) {
            for (int meta = 1; meta < MooncakeFillingType.VALUES.length; meta++) {
                stacks.add(new ItemStack(this, 1, meta));
            }
        }
    }
}
