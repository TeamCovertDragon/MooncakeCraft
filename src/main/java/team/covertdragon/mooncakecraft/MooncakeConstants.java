/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MooncakeConstants {

    public static final String MODID = "mooncakecraft";

    public static final String NAME = "MooncakeCraft";

    public static final CreativeTabs TAB_MOONCAKE_CRAFT = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ICON);
        }
    };

    @GameRegistry.ObjectHolder("mooncakecraft:peanut_plant")
    public static final Block PEANUT_PLANT;

    @GameRegistry.ObjectHolder("mooncakecraft:sesame_plant")
    public static final Block SESAME_PLANT;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncake")
    public static final Item MOONCAKE_ITEM;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakemold")
    public static final Item MOONCAKE_MOLD;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncake_filling")
    public static final Item MOONCAKE_FILLING;

    @GameRegistry.ObjectHolder("mooncakecraft:wheat_flour")
    public static final Item WHEAT_FLOUR;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakeraw")
    public static final Item RAW_MOONCAKE_ITEM;

    @GameRegistry.ObjectHolder("mooncakecraft:mooncakeunshaped")
    public static final Item UNSHAPED_MOONCAKE_ITEM;

    @GameRegistry.ObjectHolder("mooncakecraft:jujube")
    public static final Item JUJUBE;

    @GameRegistry.ObjectHolder("mooncakecraft:lotus_seeds")
    public static final Item LOTUS_SEED;

    @GameRegistry.ObjectHolder("mooncakecraft:peanut_seeds")
    public static final Item PEANUT_SEED;

    @GameRegistry.ObjectHolder("mooncakecraft:sesame_seeds")
    public static final Item SESAME_SEED;

    @GameRegistry.ObjectHolder("mooncakecraft:icon")
    public static final Item ICON;

    //Disable IDEA fake alerts
    static {
        ICON = null;
        SESAME_SEED = null;
        PEANUT_SEED = null;
        LOTUS_SEED = null;
        JUJUBE = null;
        UNSHAPED_MOONCAKE_ITEM = null;
        RAW_MOONCAKE_ITEM = null;
        WHEAT_FLOUR = null;
        MOONCAKE_FILLING = null;
        MOONCAKE_MOLD = null;
        MOONCAKE_ITEM = null;
        SESAME_PLANT = null;
        PEANUT_PLANT = null;
    }
}
