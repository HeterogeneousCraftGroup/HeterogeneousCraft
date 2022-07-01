package net.fabricmc.example;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;

public class Infusion extends BlockEntity  {
    private boolean active = false;

    public Infusion(BlockPos pos, BlockState state) {
        super(ExampleMod.INFUSION, pos, state);
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
        BlockPos pos = this.getPos();
        pos.add(0,-1,0);
        assert world != null;
        if(world.getBlockState(pos) == Blocks.FIRE.getDefaultState()){
            world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), new ItemStack(ExampleMod.Fire)));
            }
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public boolean getActive() {
        return active;
    }
}
