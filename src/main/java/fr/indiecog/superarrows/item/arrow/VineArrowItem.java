package fr.indiecog.superarrows.item.arrow;

import fr.indiecog.superarrows.entity.projectile.arrow.LightningArrowEntity;
import fr.indiecog.superarrows.entity.projectile.arrow.VineArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VineArrowItem extends ArrowItem {
    public VineArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new VineArrowEntity(world,shooter);
    }
}
