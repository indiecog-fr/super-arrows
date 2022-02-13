package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class LightningArrowEntity extends SingleActionArrowEntity {
    public LightningArrowEntity(EntityType<? extends SingleActionArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningArrowEntity(World world, double x, double y, double z) {
        super(SuperArrowsEntities.LIGHTNING_ARROW_ENTITY, x, y, z, world);
    }

    public LightningArrowEntity(World world, LivingEntity owner) {
        super(SuperArrowsEntities.LIGHTNING_ARROW_ENTITY,owner, world);
    }



    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void blockHitAction(BlockHitResult blockHitResult) {
        if (world.isSkyVisible(blockHitResult.getBlockPos().up())) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(this.world);
            if (lightningEntity != null) {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockHitResult.getBlockPos().up()));
                world.spawnEntity(lightningEntity);
                this.discard();
            }
        }
    }

    @Override
    protected void hitAction(LivingEntity target) {

    }


    @Override
    protected void entityHitAction(EntityHitResult entityHitResult) {
        if (world.isSkyVisible(entityHitResult.getEntity().getBlockPos())) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entityHitResult.getEntity().getWorld());
            if (lightningEntity != null) {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(entityHitResult.getEntity().getBlockPos()));
                world.spawnEntity(lightningEntity);
                this.discard();
            }
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.LIGHTNING_ARROW_ITEM);
    }
}
