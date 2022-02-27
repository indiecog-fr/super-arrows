package fr.indiecog.superarrows.entity.projectile.arrow;


import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class VineArrowEntity extends SingleActionArrowEntity {


    public VineArrowEntity(EntityType<? extends VineArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public VineArrowEntity(World world, double x, double y, double z) {
        super(SuperArrowsEntities.VINE_ARROW_ENTITY, x, y, z, world);
    }

    public VineArrowEntity(World world, LivingEntity owner) {
        super(SuperArrowsEntities.VINE_ARROW_ENTITY, owner, world);
    }

    @Override
    protected void blockHitAction(BlockHitResult blockHitResult) {
        /*if(blockHitResult.getSide() == Direction.DOWN || !world.isAir(blockHitResult.getBlockPos().offset(blockHitResult.getSide()))) {
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
        }*/
        placeVine(blockHitResult.getBlockPos().offset(blockHitResult.getSide()), blockHitResult.getSide());
    }

    private boolean placeVine(BlockPos position, Direction direction) {
        BlockState bs;
        bs = Blocks.WEEPING_VINES.getDefaultState();
        if(bs.canPlaceAt(getWorld(), position)) {
            if(getWorld().setBlockState(position, bs)) {

                if(getWorld() instanceof ServerWorld) {
                    for (int i = 0; i < 8; i++) {
                        Fertilizable b = (Fertilizable) getWorld().getBlockState(position).getBlock();
                        b.grow((ServerWorld) getWorld(), getWorld().random, position, getWorld().getBlockState(position));
                        this.discard();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    protected void hitAction(LivingEntity target) {}

    @Override
    protected void entityHitAction(EntityHitResult entityHitResult) {}


    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.VINE_ARROW_ITEM);
    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        switch(this.pickupType) {
            case ALLOWED:
                return player.getInventory().insertStack(new ItemStack(Items.ARROW));
            case CREATIVE_ONLY:
                return player.getAbilities().creativeMode;
            default:
                return false;
        }
    }
}
