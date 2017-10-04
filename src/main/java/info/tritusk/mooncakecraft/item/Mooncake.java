package info.tritusk.mooncakecraft.item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Mooncake extends ItemFood {
    public Mooncake() {
        // Default constructor represents "this food gives 2 shank hunger, 2.0 saturation, and it is not food for wolf"
        super(2, 2.0F, false);
    }

    public int getHealAmount(ItemStack stack) {
        return 0; // TODO implements EnumMap lookup
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return 0.0F; // TODO implements EnumMap lookup
    }
}
