package info.tritusk.mooncakecraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(MooncakeConstants.MODID)
public class MooncakeConstants {

    public static final String MODID = "mooncakecraft";

    public static final String NAME = "MooncakeCraft";

    @GameRegistry.ObjectHolder("mooncake")
    public static final Item MOONCAKE_ITEM = null;
}
