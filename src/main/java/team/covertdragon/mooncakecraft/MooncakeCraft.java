/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, yesterday17, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package team.covertdragon.mooncakecraft;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;

@Mod(modid = MooncakeConstants.MODID, name = MooncakeConstants.NAME, version = "@VERSION@", useMetadata = true)
public final class MooncakeCraft {

    @Mod.InstanceFactory
    public static MooncakeCraft getInstance() {
        return new MooncakeCraft();
    }

    @Nonnull
    @SidedProxy(
            serverSide = "info.tritusk.mooncakecraft.server.MooncakeProxyServer",
            clientSide = "info.tritusk.mooncakecraft.client.MooncakeProxyClient")
    public static MooncakeProxy mooncakeSpecialist;

    private MooncakeCraft() {
        FluidRegistry.enableUniversalBucket(); // For future usage
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        mooncakeSpecialist.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        mooncakeSpecialist.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        mooncakeSpecialist.postInit(event);
    }
}
