package team.covertdragon.mooncakecraft.supports.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;

@ModOnly("contenttweaker")
@ZenClass("mods.mooncakecraft.MooncakeRegistry")
@ZenRegister
public final class CraftTweakerMooncakeRegistry {

    @ZenMethod
    public static void register(String uniqueName, int hungerHeal, float saturation, CraftTweakerMooncakeFillingLogic logic) {
        if (!MooncakeRegistry.INSTANCE.registerFilling(uniqueName, hungerHeal, saturation, logic)) {
            CraftTweakerAPI.logError(String.format("Failed to register %s because the registry has been frozen. Try use ContentTweaker's loader.", uniqueName));
        }
    }

}
