/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.block;

import info.tritusk.mooncakecraft.MooncakeConstants;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class PlantPeanut extends BlockCrops {

    protected Item getSeed()
    {
        return MooncakeConstants.PEANUT_SEED;
    }

    protected Item getCrop()
    {
        return MooncakeConstants.PEANUT_SEED;
    }
}
