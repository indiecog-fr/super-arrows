package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class TracingArrowEntity extends PersistentProjectileEntity {

    private boolean hasGravity;
    private final float speedMultiplier = 3;

    public TracingArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
        hasGravity = false;
    }

    public TracingArrowEntity(World world, double x, double y, double z) {
        super(SuperArrowsEntities.TRACING_ARROW_ENTITY, x, y, z, world);
        hasGravity = false;
    }

    public TracingArrowEntity(World world, LivingEntity owner) {
        super(SuperArrowsEntities.TRACING_ARROW_ENTITY,owner, world);
        hasGravity = false;
    }

    @Override
    public boolean hasNoGravity() {
        return !hasGravity;
    }

    @Override
    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        super.setVelocity(x, y, z, speed*speedMultiplier, divergence);
    }

    @Override
    public void setVelocity(Entity shooter, float pitch, float yaw, float roll, float speed, float divergence) {
        super.setVelocity(shooter, pitch, yaw, roll, speed*speedMultiplier, divergence);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.hasGravity = true;
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.TRACING_ARROW_ITEM);
    }

    @Override
    public double getDamage() {
        return super.getDamage();
    }
}
