/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MooncakeConstants {

    public static final String MODID = "mooncakecraft";

    public static final String NAME = "MooncakeCraft";

    public static final CreativeTabs TAB_MOONCAKE_CRAFT = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(MOONCAKE_MOLD);
        }
    };

    @GameRegistry.ObjectHolder("mooncakecraft:mooncake")
    public static final Item MOONCAKE_ITEM = null;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakemold")
    public static final Item MOONCAKE_MOLD = null;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncake_filling")
    public static final Item MOONCAKE_FILLING = null;

    @GameRegistry.ObjectHolder("mooncakecraft:wheat_flour")
    public static final Item WHEAT_FLOUR = null;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakeraw")
    public static final Item RAW_MOONCAKE_ITEM = null;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakeunshaped")
    public static final Item UNSHAPED_MOONCAKE_ITEM = null;
}
