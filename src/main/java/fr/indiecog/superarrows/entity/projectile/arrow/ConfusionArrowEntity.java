package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import fr.indiecog.superarrows.predicate.ConfusionArrowTargetPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class ConfusionArrowEntity extends SingleActionArrowEntity {
    public ConfusionArrowEntity(EntityType<? extends SingleActionArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public ConfusionArrowEntity(World world, double x, double y, double z) {
        super(SuperArrowsEntities.CONFUSION_ARROW_ENTITY, x, y, z, world);
    }

    public ConfusionArrowEntity(World world, LivingEntity owner) {
        super(SuperArrowsEntities.CONFUSION_ARROW_ENTITY, owner, world);
    }


    @Override
    protected void entityHitAction(EntityHitResult entityHitResult) {
        if (!entityHitResult.getEntity().isPlayer() && entityHitResult.getEntity() instanceof HostileEntity) {
            HostileEntity mob = (HostileEntity)entityHitResult.getEntity();
            List<LivingEntity> list = getWorld().getEntitiesByClass(LivingEntity.class,new Box(getX()+10,getY()+10,getZ()+10,getX()-10,getY()-10,getZ()-10), new ConfusionArrowTargetPredicate((LivingEntity) entityHitResult.getEntity()));
            if (!list.isEmpty()) {
                mob.setTarget(list.get(getWorld().random.nextInt(list.size())));
                mob.setAttacking(true);
            }
        }

    }

    @Override
    protected void blockHitAction(BlockHitResult blockHitResult) {

    }

    @Override
    protected void hitAction(LivingEntity target) {

    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.CONFUSION_ARROW_ITEM);
    }
}
