/*
 * Copyright (c) 2017 3TUSK, Seraph-JACK, et al.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package info.tritusk.mooncakecraft;

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
    public static MooncakeProxy delegate;

    private MooncakeCraft() {
        FluidRegistry.enableUniversalBucket(); // For future usage
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        delegate.preInit(event);
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        delegate.init(event);
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        delegate.postInit(event);
    }
}
