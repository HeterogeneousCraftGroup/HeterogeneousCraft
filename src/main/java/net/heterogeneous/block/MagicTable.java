package net.heterogeneous.block;

import net.heterogeneous.blockentity.MagicTableBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;

public class MagicTable extends Block implements BlockEntityProvider  {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public MagicTable(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MagicTableBlockEntity(pos, state);
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
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        // TODO Auto-generated method stub
//        if (!world.isClient) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof Infusion infusion) {
//                if (player.getMainHandStack().getItem().getClass() == MagicBookPage.class & !infusion.getActive()) {
//                    player.sendMessage(Text.of("hello"), true);
//                    player.getMainHandStack().decrement(1);
//                    infusion.setActive(true);
//                    return ActionResult.SUCCESS;
//                }
//                if (player.getMainHandStack().getItem().getClass() == InfusionStick.class & infusion.getActive()){
//                    infusion.infuse();
//                    infusion.setActive(false);
//                    return ActionResult.SUCCESS;
//
//                }
//            }
//        }
//        return ActionResult.FAIL;
//    }





//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new MagicTableBlockEntity(pos,state);
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
//        return ActionResult.SUCCESS;
//
//    }
//
//    @Nullable
//    @Override
//    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
//        return (NamedScreenHandlerFactory) createBlockEntity(pos, state);
//    }
//    @Override
//    public BlockState mirror(BlockState state, BlockMirror mirror) {
//        // TODO Auto-generated method stub
//        return state.rotate(mirror.getRotation(state.get(FACING)));
//    }
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        // TODO Auto-generated method stub
//        builder.add(FACING);
//    }
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        // TODO Auto-generated method stub
//        return super.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
//    }
//    @Override
//    public BlockState rotate(BlockState state, BlockRotation rotation) {
//        // TODO Auto-generated method stub
//        return state.with(FACING, rotation.rotate(state.get(FACING)));
//    }
}
