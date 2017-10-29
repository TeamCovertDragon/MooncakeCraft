/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.block;

import team.covertdragon.mooncakecraft.MooncakeConstants;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

public class PlantSesame extends BlockCrops {

    @Nonnull
    protected Item getSeed() {
        return MooncakeConstants.SESAME_SEED;
    }

    @Nonnull
    protected Item getCrop() {
        return MooncakeConstants.SESAME_SEED;
    }
}
