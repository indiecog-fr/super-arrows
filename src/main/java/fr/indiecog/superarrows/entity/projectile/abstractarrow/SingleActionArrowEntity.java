package fr.indiecog.superarrows.entity.projectile.abstractarrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public abstract class SingleActionArrowEntity extends ArrowEntity {

    private boolean isActionFinish;

    public SingleActionArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        isActionFinish = false;
    }

    public SingleActionArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
        isActionFinish = false;
    }

    public SingleActionArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
        isActionFinish = false;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if(!isActionFinish) {
            blockHitAction(blockHitResult);
            isActionFinish = true;
        }
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        if(!isActionFinish) {
            hitAction(target);
            isActionFinish = true;
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {

        if(!isActionFinish) {
            entityHitAction(entityHitResult);
            isActionFinish = true;
        }
        super.onEntityHit(entityHitResult);
    }

    protected abstract void blockHitAction(BlockHitResult blockHitResult);

    protected abstract void hitAction(LivingEntity target);

    protected abstract void entityHitAction(EntityHitResult entityHitResult);
}