package fr.indiecog.superarrows.entity.projectile.arrow;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class GlowingArrowEntity extends ArrowEntity {
    public GlowingArrowEntity(EntityType<? extends GlowingArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowingArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public GlowingArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState bs = Blocks.GLOWSTONE.getDefaultState();
        world.removeBlock(blockHitResult.getBlockPos(), false);
        world.setBlockState(blockHitResult.getBlockPos(), bs, 3);
    }

    @Override
    public void initFromStack(ItemStack stack) {
        super.initFromStack(stack);
    }
}
