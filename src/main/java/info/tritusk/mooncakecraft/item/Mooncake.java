package info.tritusk.mooncakecraft.item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Mooncake extends ItemFood {
    public Mooncake() {
        // Default constructor represents "this food gives 2 shank hunger, 2.0 saturation, and it is not food for wolf"
        super(2, 2.0F, false);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setNoRepair();
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return MooncakeFilling.VALUES[stack.getMetadata()].hunger;
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return MooncakeFilling.VALUES[stack.getMetadata()].saturation;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item.mooncakecraft.mooncake." + MooncakeFilling.VALUES[stack.getMetadata()].localizationKey;
    }
}
