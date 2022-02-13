package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveArrowEntity extends PersistentProjectileEntity {
    public ExplosiveArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplosiveArrowEntity(double x, double y, double z, World world) {
        super(SuperArrowsEntities.EXPLOSIVE_ARROW_ENTITY, x, y, z, world);
    }

    public ExplosiveArrowEntity(LivingEntity owner, World world) {
        super(SuperArrowsEntities.EXPLOSIVE_ARROW_ENTITY, owner, world);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        world.createExplosion(this,getBlockX(),getBlockY(),getBlockZ(),4,true, Explosion.DestructionType.BREAK);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.EXPLOSIVE_ARROW_ITEM);
    }
}
