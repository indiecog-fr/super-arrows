package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class GlowingArrowEntity extends SingleActionArrowEntity {

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
    protected void blockHitAction(BlockHitResult blockHitResult) {
        BlockState bs;

        if(blockHitResult.getSide() == Direction.DOWN || !world.isAir(blockHitResult.getBlockPos().offset(blockHitResult.getSide()))) {
            dropItemtorch(blockHitResult.getBlockPos().offset(Direction.DOWN, 2));
            return;
        } else if(blockHitResult.getSide() == Direction.UP) {
            bs = Blocks.TORCH.getDefaultState();
        } else {
            bs = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, blockHitResult.getSide());
        }

        if(bs.canPlaceAt(world, blockHitResult.getBlockPos().offset(blockHitResult.getSide()))) {
            world.setBlockState(blockHitResult.getBlockPos().offset(blockHitResult.getSide()), bs, Block.NOTIFY_ALL);
        } else {
            dropItemtorch(blockHitResult.getBlockPos().offset(blockHitResult.getSide()));
        }
    }

    @Override
    protected void hitAction(LivingEntity target) {}

    @Override
    protected void entityHitAction(EntityHitResult entityHitResult) {}

    private void dropItemtorch(BlockPos pos) {
        // Create an item entity with velocity 0
        ItemEntity itemEntity = new ItemEntity(world, pos.north().getX(), pos.up().getY(), pos.getZ(), Items.TORCH.getDefaultStack(), 0, 0, 0);
        // Spawn the item entity
        world.spawnEntity(itemEntity);
    }
}
