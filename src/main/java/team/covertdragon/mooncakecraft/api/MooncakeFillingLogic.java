package team.covertdragon.mooncakecraft.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface MooncakeFillingLogic {

    void onEaten(ItemStack item, World world, EntityLivingBase entity);

    class Blank implements MooncakeFillingLogic {

        public static final Blank INSTANCE = new Blank();

        @Override
        public void onEaten(ItemStack item, World world, EntityLivingBase entity) {
            // Does nothing.
        }
    }
}
