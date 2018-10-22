package team.covertdragon.mooncakecraft.client;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import team.covertdragon.mooncakecraft.MooncakeConstants;
import team.covertdragon.mooncakecraft.api.MooncakeRegistry;
import team.covertdragon.mooncakecraft.util.NBTUtil;

import java.util.Set;

public class MooncakeFillingPostfixMeshDefinition implements ItemMeshDefinition {

    private final String mainPath;

    public MooncakeFillingPostfixMeshDefinition(String mainPath) {
        this.mainPath = mainPath;
    }

    public MooncakeFillingPostfixMeshDefinition initWithVariants(Item targetItem, Set<String> variants) {
        ModelLoader.registerItemVariants(targetItem, variants.stream()
                .map(type -> new ResourceLocation(MooncakeConstants.MODID, mainPath + type))
                .map(rl -> new ModelResourceLocation(rl, "inventory"))
                .toArray(ModelResourceLocation[]::new)
        );
        return this;
    }

    @Override
    public ModelResourceLocation getModelLocation(ItemStack stack) {
        String fillingType = NBTUtil.getString(stack.getTagCompound(), MooncakeConstants.KEY_FILLING_TYPE);
        if (!MooncakeRegistry.INSTANCE.isRegistered(fillingType)) {
            fillingType = MooncakeRegistry.FALLBACK_FILLING_TYPE;
        }
        return new ModelResourceLocation(new ResourceLocation(MooncakeConstants.MODID, mainPath + fillingType), "inventory");
    }
}
