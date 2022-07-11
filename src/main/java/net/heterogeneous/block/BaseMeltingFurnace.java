package net.heterogeneous.block;

import net.heterogeneous.blockentity.InfusionBlockEntity;
import net.heterogeneous.blockentity.BaseMeltingFurnaceEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
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
import org.jetbrains.annotations.Nullable;

public class BaseMeltingFurnace extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public BaseMeltingFurnace(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());

    }
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state, World world) {
        return new BaseMeltingFurnaceEntity(pos, state, world);
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
        player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        return ActionResult.SUCCESS;
    }
    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory) createBlockEntity(pos, state,world);
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos var1, BlockState var2) {
        return new BaseMeltingFurnaceEntity(var1, var2);
        // return null;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegisterBlocks.BASE_MELTING_FURNACE_ENTITY, (world1, pos, state1, be) -> BaseMeltingFurnaceEntity.tick(world1, pos, state1, be));
    }
}
