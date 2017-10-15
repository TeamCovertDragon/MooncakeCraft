/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class MooncakeJEICompatibility implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.MOONCAKE_FILLING, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.RAW_MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.MOONCAKE_ITEM, 1, 0));
        blacklist.addIngredientToBlacklist(new ItemStack(MooncakeConstants.ICON, 1, 0));
    }
}
