package fr.indiecog.superarrows.item.arrow;

import fr.indiecog.superarrows.entity.projectile.arrow.GlowingArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GlowingArrowItem extends ArrowItem {
    public GlowingArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        GlowingArrowEntity arrowEntity = new GlowingArrowEntity(world, shooter);
        arrowEntity.initFromStack(stack);
        return arrowEntity;
    }
}
