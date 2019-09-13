/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import team.covertdragon.mooncakecraft.block.PlantPeanut;
import team.covertdragon.mooncakecraft.block.PlantSesame;
import team.covertdragon.mooncakecraft.item.MoonCakeRaw;
import team.covertdragon.mooncakecraft.item.MoonCakeUnshaped;
import team.covertdragon.mooncakecraft.item.Mooncake;
import team.covertdragon.mooncakecraft.item.MooncakeFilling;
import team.covertdragon.mooncakecraft.item.MooncakeMold;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeRegistries {

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                new PlantPeanut().setRegistryName("mooncakecraft:peanut_plant"),
                new PlantSesame().setRegistryName("mooncakecraft:sesame_plant")
        );
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new Mooncake().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setRegistryName("mooncakecraft:mooncake"),
                new MooncakeMold().setRegistryName("mooncakecraft:mooncakemold"),
                new MooncakeFilling().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setRegistryName("mooncakecraft:mooncake_filling"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setTranslationKey("mooncakecraft.wheat_flour").setRegistryName("mooncakecraft:wheat_flour"),
                new MoonCakeRaw().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setRegistryName("mooncakecraft:mooncakeraw"),
                new MoonCakeUnshaped().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setRegistryName("mooncakecraft:mooncakeunshaped"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setTranslationKey("mooncakecraft.lotus_seeds").setRegistryName("mooncakecraft:lotus_seeds"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setTranslationKey("mooncakecraft.jujube").setRegistryName("mooncakecraft:jujube"),
                new ItemSeeds(MooncakeConstants.PEANUT_PLANT, Blocks.FARMLAND).setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setTranslationKey("mooncakecraft.peanut_seeds").setRegistryName("mooncakecraft:peanut_seeds"),
                new ItemSeeds(MooncakeConstants.SESAME_PLANT, Blocks.FARMLAND).setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setTranslationKey("mooncakecraft.sesame_seeds").setRegistryName("mooncakecraft:sesame_seeds"),
                new Item().setRegistryName("mooncakecraft:icon")
        );
        MooncakeRegistry.INSTANCE.freezeRegistry();
    }


}
