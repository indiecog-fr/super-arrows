package fr.indiecog.superarrows.entity.projectile.abstractarrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public abstract class SingleActionArrowEntity extends PersistentProjectileEntity {

    private boolean isActionFinish;

    protected SingleActionArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    protected SingleActionArrowEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    protected SingleActionArrowEntity(EntityType<? extends PersistentProjectileEntity> type, LivingEntity owner, World world) {
        super(type, owner, world);
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