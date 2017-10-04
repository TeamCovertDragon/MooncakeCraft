/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

import info.tritusk.mooncakecraft.item.*;
import info.tritusk.mooncakecraft.recipe.RecipeAddFilling;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeRegistries {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(
                new Mooncake().setRegistryName("mooncakecraft:mooncake"),
                new MooncakeMold().setRegistryName("mooncakecraft:mooncakemold"),
                new MooncakeFilling().setRegistryName("mooncakecraft:mooncake_filling"),
                new Item().setCreativeTab(MooncakeConstants.tabMooncakeCraft).setHasSubtypes(false).setUnlocalizedName("mooncakecraft.wheat_flour").setRegistryName("mooncakecraft:wheat_flour"),
                new MoonCakeRaw().setRegistryName("mooncakecraft:mooncakeraw"),
                new MoonCakeUnshaped().setRegistryName("mooncakecraft:mooncakeunshaped")
        );
    }

    @SubscribeEvent
    public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        registry.registerAll(new RecipeAddFilling());
    }
}
