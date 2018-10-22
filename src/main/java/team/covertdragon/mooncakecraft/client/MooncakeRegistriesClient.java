/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft.client;

import team.covertdragon.mooncakecraft.MooncakeConstants;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID, value = Side.CLIENT)
public class MooncakeRegistriesClient {
    
    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        Set<String> allKnownFillings = MooncakeRegistry.INSTANCE.getAllKnownFillings();
        //Registries for mooncakes
        ModelLoader.setCustomMeshDefinition(MooncakeConstants.MOONCAKE_ITEM, new MooncakeFillingPostfixMeshDefinition("mooncake_").initWithVariants(MooncakeConstants.MOONCAKE_ITEM, allKnownFillings));

        //Registries for mooncake fillings
        ModelLoader.setCustomMeshDefinition(MooncakeConstants.MOONCAKE_FILLING, new MooncakeFillingPostfixMeshDefinition("mooncake_filling_").initWithVariants(MooncakeConstants.MOONCAKE_FILLING, allKnownFillings));

        //Registries for raw mooncakes
        ModelLoader.setCustomMeshDefinition(MooncakeConstants.RAW_MOONCAKE_ITEM, new MooncakeFillingPostfixMeshDefinition("mooncake_raw_").initWithVariants(MooncakeConstants.RAW_MOONCAKE_ITEM, allKnownFillings));

        //Registries for unshaped mooncakes
        ModelLoader.setCustomMeshDefinition(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, new MooncakeFillingPostfixMeshDefinition("mooncake_unshaped_").initWithVariants(MooncakeConstants.UNSHAPED_MOONCAKE_ITEM, allKnownFillings));

        //Registries for other things
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.WHEAT_FLOUR, 0, new ModelResourceLocation("mooncakecraft:wheat_flour", "inventory"));
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.SESAME_SEED, 0, new ModelResourceLocation("mooncakecraft:sesame_seeds", "inventory"));
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.PEANUT_SEED, 0, new ModelResourceLocation("mooncakecraft:peanut_seeds", "inventory"));
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.LOTUS_SEED, 0, new ModelResourceLocation("mooncakecraft:lotus_seeds", "inventory"));
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.JUJUBE, 0, new ModelResourceLocation("mooncakecraft:jujube", "inventory"));

        //Registries for mooncake mold
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.MOONCAKE_MOLD, 0, new ModelResourceLocation("mooncakecraft:mooncake_mold_empty", "inventory"));
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.MOONCAKE_MOLD, 1, new ModelResourceLocation("mooncakecraft:mooncake_mold_full", "inventory"));

        //ICON
        ModelLoader.setCustomModelResourceLocation(MooncakeConstants.ICON, 0, new ModelResourceLocation("mooncakecraft:icon", "inventory"));
    }
}
