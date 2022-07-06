package net.heterogeneous.block;

import net.heterogeneous.blockentity.MagicalendChestEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
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

public class MagicalendChest extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public MagicalendChest(Settings settings) {
        super(Settings.of(Material.STONE).nonOpaque());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MagicalendChestEntity(pos, state);
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
        activate(state, world, pos, player, hand, hit);
        return ActionResult.SUCCESS;
    }
    public boolean activate(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return true;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);


        if (!player.getStackInHand(hand).isEmpty()) {
            // 检查第一个打开的槽位是什么，并从玩家手中放入物品
            if (blockEntity.getStack(0).isEmpty()) {
                // 将玩家手中的物品堆放入物品栏中
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                // 从玩家手中移除物品堆
                player.getStackInHand(hand).setCount(0);
            } else if (blockEntity.getStack(1).isEmpty()) {
                blockEntity.setStack(1, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            } else {
                // 如果物品栏是满的，我们输出其内容
                System.out.println("The first slot holds "
                        + blockEntity.getStack(0) + " and the second slot holds " + blockEntity.getStack(1));
            }
        } else {
            // 如果玩家没有持有任何东西，我们依次将方块实体中的物品给予玩家

            // 查找第一个有物品的槽位，并给予玩家
            if (!blockEntity.getStack(1).isEmpty()) {
                // 给予玩家物品栏中的物品堆
                player.getInventory().offerOrDrop(blockEntity.getStack(1));
                // Remove the stack from the inventory
                blockEntity.removeStack(1);
            } else if (!blockEntity.getStack(0).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
            }
        }
        return true;
    }
}
