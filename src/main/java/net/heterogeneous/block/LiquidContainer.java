package net.heterogeneous.block;

import net.heterogeneous.blockentity.LiquidContainerEntity;
import net.heterogeneous.blockentity.MagicTableBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class LiquidContainer extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
//    protected val AABB_LEGS = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0)
//    protected val AABB_WALL_NORTH = AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125)
//    protected val AABB_WALL_SOUTH = AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0)
//    protected val AABB_WALL_EAST = AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0)
//    protected val AABB_WALL_WEST = AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0)

    public LiquidContainer(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());
    }
    



    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LiquidContainerEntity(pos,state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;

    }
    
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        // TODO Auto-generated method stub
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        // TODO Auto-generated method stub
        builder.add(FACING);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // TODO Auto-generated method stub
        return super.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        // TODO Auto-generated method stub
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
}
