/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;
import team.covertdragon.mooncakecraft.api.MooncakeFillingLogic;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;

@Mod(modid = MooncakeConstants.MODID, name = MooncakeConstants.NAME, version = "@VERSION@", useMetadata = true)
public final class MooncakeCraft {

    private static final MooncakeCraft INSTANCE = new MooncakeCraft();

    @Mod.InstanceFactory
    public static MooncakeCraft getInstance() {
        return INSTANCE;
    }

    public static Logger logger;

    private MooncakeCraft() {
        FluidRegistry.enableUniversalBucket(); // For future usage
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MooncakeRegistry.INSTANCE.registerFilling("lotus_seed_paste", 6, 6F, MooncakeFillingLogic.Blank.INSTANCE);
        MooncakeRegistry.INSTANCE.registerFilling("sweet_bean_paste", 2, 4F, MooncakeFillingLogic.Blank.INSTANCE);
        MooncakeRegistry.INSTANCE.registerFilling("jujube_paste", 2, 4F, MooncakeFillingLogic.Blank.INSTANCE);
        MooncakeRegistry.INSTANCE.registerFilling("five_nuts", 1, .5F, MooncakeFillingLogic.Blank.INSTANCE);
        MooncakeRegistry.INSTANCE.registerFilling("lotus_seed_paste_with_yolk", 10, 10F, MooncakeFillingLogic.Blank.INSTANCE);
        MooncakeRegistry.INSTANCE.registerFilling("lotus_seed_paste_with_double_yolk", 15, 15F, MooncakeFillingLogic.Blank.INSTANCE);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.addGrassSeed(new ItemStack(MooncakeConstants.SESAME_SEED), 10);
        MinecraftForge.addGrassSeed(new ItemStack(MooncakeConstants.PEANUT_SEED), 10);

        OreDictionary.registerOre("foodMooncake", MooncakeConstants.MOONCAKE_ITEM);

        OreDictionary.registerOre("cropSesame", MooncakeConstants.SESAME_SEED);
        OreDictionary.registerOre("seedSesame", MooncakeConstants.SESAME_SEED);
        OreDictionary.registerOre("listAllseed", MooncakeConstants.SESAME_SEED);

        OreDictionary.registerOre("cropPeanut", MooncakeConstants.PEANUT_SEED);
        OreDictionary.registerOre("seedPeanut", MooncakeConstants.PEANUT_SEED);
        OreDictionary.registerOre("listAllnut", MooncakeConstants.PEANUT_SEED);
        OreDictionary.registerOre("listAllseed", MooncakeConstants.PEANUT_SEED);

        OreDictionary.registerOre("seedLotus", MooncakeConstants.LOTUS_SEED);
        OreDictionary.registerOre("listAllseed", MooncakeConstants.LOTUS_SEED);

        OreDictionary.registerOre("cropJujube", MooncakeConstants.JUJUBE);
        OreDictionary.registerOre("listAllfruit", MooncakeConstants.JUJUBE);

        OreDictionary.registerOre("foodFlour", MooncakeConstants.WHEAT_FLOUR);

        OreDictionary.registerOre("sugar", Items.SUGAR);
    }

}
