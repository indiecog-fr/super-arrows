package fr.indiecog.superarrows.entity.projectile.arrow;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class GlowingArrowEntity extends ArrowEntity {
    public GlowingArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState bs = Blocks.GLOWSTONE.getDefaultState();
        world.removeBlock(blockHitResult.getBlockPos(), false);
        world.setBlockState(blockHitResult.getBlockPos(), bs, 3);
    }
}
