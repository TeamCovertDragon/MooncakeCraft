package info.tritusk.mooncakecraft;

import info.tritusk.mooncakecraft.item.Mooncake;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MooncakeConstants.MODID)
public class MooncakeRegistries {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(new Mooncake().setRegistryName("mooncakecraft:mooncake"));
    }
}
