/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import info.tritusk.mooncakecraft.block.PlantPeanut;
import info.tritusk.mooncakecraft.block.PlantSesame;
import info.tritusk.mooncakecraft.item.*;
import info.tritusk.mooncakecraft.recipe.RecipeUnshapedMooncake;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeRegistries {

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.registerAll(
                new PlantPeanut().setRegistryName("mooncakecraft:peanut_plant"),
                new PlantSesame().setRegistryName("mooncakecraft:sesame_plant")
        );
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                new Mooncake().setRegistryName("mooncakecraft:mooncake"),
                new MooncakeMold().setRegistryName("mooncakecraft:mooncakemold"),
                new MooncakeFilling().setRegistryName("mooncakecraft:mooncake_filling"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setUnlocalizedName("mooncakecraft.wheat_flour").setRegistryName("mooncakecraft:wheat_flour"),
                new MoonCakeRaw().setRegistryName("mooncakecraft:mooncakeraw"),
                new MoonCakeUnshaped().setRegistryName("mooncakecraft:mooncakeunshaped"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setUnlocalizedName("mooncakecraft.lotus_seeds").setRegistryName("mooncakecraft:lotus_seeds"),
                new Item().setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setHasSubtypes(false).setUnlocalizedName("mooncakecraft.jujube").setRegistryName("mooncakecraft:jujube"),
                new ItemSeeds(MooncakeConstants.PEANUT_PLANT, Blocks.FARMLAND).setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setUnlocalizedName("mooncakecraft.peanut_seeds").setRegistryName("mooncakecraft:peanut_seeds"),
                new ItemSeeds(MooncakeConstants.SESAME_PLANT, Blocks.FARMLAND).setCreativeTab(MooncakeConstants.TAB_MOONCAKE_CRAFT).setUnlocalizedName("mooncakecraft.sesame_seeds").setRegistryName("mooncakecraft:sesame_seeds"),
                new Item().setRegistryName("mooncakecraft:icon")
        );
    }

    @SubscribeEvent
    public static void onBlockMissing(RegistryEvent.MissingMappings<Block> event) {
        for (RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
            if (new ResourceLocation(MooncakeConstants.MODID, "jujube_plant").equals(mapping.key)) {
                mapping.remap(Blocks.WHEAT);
                break;
            }
        }
    }

    @SubscribeEvent
    public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().registerAll(
                new RecipeUnshapedMooncake()
        );
    }
}
