/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeEventHandlers {

    @SubscribeEvent
    public static void gatherDrop(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null
                && event.getState().getBlock() == Blocks.WATERLILY
                && event.getHarvester().getRNG().nextInt(100) < 5) {
            event.getDrops().add(new ItemStack(MooncakeConstants.LOTUS_SEED, 2));
        }
    }
}
