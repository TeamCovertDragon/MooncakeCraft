/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft.client;

import info.tritusk.mooncakecraft.MooncakeConstants;
import info.tritusk.mooncakecraft.item.MooncakeFilling;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeRegistriesClient {

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomMeshDefinition(MooncakeConstants.MOONCAKE_ITEM, itemStack -> new ModelResourceLocation("mooncake_" + MooncakeFilling.VALUES[itemStack.getMetadata()].getLocalizationKey(), "inventory"));
    }
}
