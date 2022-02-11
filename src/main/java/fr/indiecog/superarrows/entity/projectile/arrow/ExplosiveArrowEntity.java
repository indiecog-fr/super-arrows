package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveArrowEntity extends ArrowEntity {
    public ExplosiveArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplosiveArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ExplosiveArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
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
