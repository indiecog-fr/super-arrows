package fr.indiecog.superarrows.entity.projectile.arrow;

import fr.indiecog.superarrows.SuperArrowsMod;
import fr.indiecog.superarrows.item.arrow.GlowingArrowItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.logging.Logger;

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
        BlockState bs;

        if(blockHitResult.getSide() == Direction.DOWN) {
            // The position of the conveyor (pos in your code)
            BlockPos currentPosition = blockHitResult.getBlockPos().offset(Direction.DOWN, 2);
            // Create an item entity with velocity 0
            ItemEntity itemEntity = new ItemEntity(world, currentPosition.north().getX(), currentPosition.up().getY(), currentPosition.getZ(), Items.TORCH.getDefaultStack(), 0, 0, 0);
            // Spawn the item entity
            world.spawnEntity(itemEntity);
            return;
        } else if(blockHitResult.getSide() == Direction.UP) {
            bs = Blocks.TORCH.getDefaultState();
        } else {
            bs = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, blockHitResult.getSide());
        }

        world.setBlockState(blockHitResult.getBlockPos().offset(blockHitResult.getSide()), bs, Block.NOTIFY_ALL);

    }


    @Override
    public void initFromStack(ItemStack stack) {
        super.initFromStack(stack);
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
        LOGGER.info("removed");
    }
}
