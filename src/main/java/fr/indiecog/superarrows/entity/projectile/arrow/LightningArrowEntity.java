package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class LightningArrowEntity extends SingleActionArrowEntity {
    public LightningArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public LightningArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }



    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void blockHitAction(BlockHitResult blockHitResult) {
        if (world.isSkyVisible(blockHitResult.getBlockPos().up())) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(this.world);
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockHitResult.getBlockPos().up()));
            world.spawnEntity(lightningEntity);
        }
    }

    @Override
    protected void hitAction(LivingEntity target) {

    }


    @Override
    protected void entityHitAction(EntityHitResult entityHitResult) {
        if (world.isSkyVisible(entityHitResult.getEntity().getBlockPos())) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entityHitResult.getEntity().getWorld());
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(entityHitResult.getEntity().getBlockPos()));
            world.spawnEntity(lightningEntity);
            this.discard();
        }
    }
}
