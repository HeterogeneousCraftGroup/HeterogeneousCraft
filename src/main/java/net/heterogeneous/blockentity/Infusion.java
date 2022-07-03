package net.heterogeneous.blockentity;

import net.heterogeneous.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;

public class Infusion extends BlockEntity  {
    private boolean active = false;

    public Infusion(BlockPos pos, BlockState state) {
        super(Main.INFUSION, pos, state);
    }

    public void setActive(boolean b) {
        active = b;
    }
    @Override
    public void writeNbt(NbtCompound tag) {
        // Save the current value of the number to the tag
        tag.putBoolean("active", active);
 
        super.writeNbt(tag);
    }
    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
    
        active = tag.getBoolean("active");
    }

    public void infuse() {
        BlockPos pos = this.getPos().down(1);
        assert world != null;
        if(world.getBlockState(pos).getBlock().getClass() == Blocks.FIRE.getDefaultState().getBlock().getClass()){
            world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY()+2,pos.getZ(), new ItemStack(Main.Fire)));
            }
        else if(world.getBlockState(pos).getBlock().getClass() == Blocks.ICE.getDefaultState().getBlock().getClass()){
            world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY()+2,pos.getZ(), new ItemStack(Main.Ice)));
        }
        else {
            world.spawnEntity(new ItemEntity(world,pos.getX(),pos.getY()+2,pos.getZ(),new ItemStack(Main.BOOK_PAGE)));
        }
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public boolean getActive() {
        return active;
    }
}
