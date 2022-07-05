package net.heterogeneous.block;

import net.heterogeneous.blockentity.LiquidLeakTapEntity;
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

public class LiquidLeakTap extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public LiquidLeakTap(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());

    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LiquidLeakTapEntity(pos, state);
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
    // onuse
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }
}
