/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MooncakeFilling extends Item {
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + MooncakeFillingType.VALUES[stack.getMetadata()].localizationKey;
    }
}
