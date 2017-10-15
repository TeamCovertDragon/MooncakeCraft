/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft;

import team.covertdragon.mooncakecraft.item.MooncakeFillingType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

public abstract class MooncakeProxy {

    public Logger logger;

    public void preInit(FMLPreInitializationEvent event) {
        this.logger = event.getModLog();
    }

    public void init(FMLInitializationEvent event) {
        for (int i = 0; i < MooncakeFillingType.VALUES.length; i++) {
            GameRegistry.addSmelting(new ItemStack(MooncakeConstants.RAW_MOONCAKE_ITEM, 1, i), new ItemStack(MooncakeConstants.MOONCAKE_ITEM, 1, i), 1.0f);
        }
        MinecraftForge.addGrassSeed(new ItemStack(MooncakeConstants.SESAME_SEED), 10);
        MinecraftForge.addGrassSeed(new ItemStack(MooncakeConstants.PEANUT_SEED), 10);
    }

    public abstract void postInit(FMLPostInitializationEvent event);
}
