/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(MooncakeConstants.MODID)
public class MooncakeConstants {

    public static final String MODID = "mooncakecraft";

    public static final String NAME = "MooncakeCraft";

    @GameRegistry.ObjectHolder("mooncake")
    public static final Item MOONCAKE_ITEM = null;
}
