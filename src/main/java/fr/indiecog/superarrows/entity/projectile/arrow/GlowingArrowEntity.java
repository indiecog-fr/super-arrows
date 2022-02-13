package fr.indiecog.superarrows.entity.projectile.arrow;


import com.google.common.collect.Sets;
import fr.indiecog.superarrows.entity.SuperArrowsEntities;
import fr.indiecog.superarrows.entity.projectile.abstractarrow.SingleActionArrowEntity;
import fr.indiecog.superarrows.item.SuperArrowsItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
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
        super(SuperArrowsEntities.GLOWING_ARROW_ENTITY, x, y, z, world);
    }

    public GlowingArrowEntity(World world, LivingEntity owner) {
        super(SuperArrowsEntities.GLOWING_ARROW_ENTITY, owner, world);
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

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SuperArrowsItems.GLOWING_ARROW_ITEM);
    }

    public void onPlayerCollision(PlayerEntity player) {
        if (!this.world.isClient && (this.inGround || this.isNoClip()) && this.shake <= 0) {
            if (this.tryPickup(player)) {
                player.sendPickup(this, 1);
                this.discard();
            }
        }
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
