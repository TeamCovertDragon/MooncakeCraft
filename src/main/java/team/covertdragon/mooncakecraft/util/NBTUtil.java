package team.covertdragon.mooncakecraft.util;

import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.ParametersAreNullableByDefault;

@ParametersAreNullableByDefault
public final class NBTUtil {

    private NBTUtil() {
        throw new UnsupportedOperationException("No instance for you");
    }

    public static String getString(NBTTagCompound tag, String key) {
        if (tag == null || key == null) {
            return "";
        } else {
            return tag.getString(key);
        }
    }
}
