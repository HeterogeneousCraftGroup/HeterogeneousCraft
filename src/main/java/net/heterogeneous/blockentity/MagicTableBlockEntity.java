package net.heterogeneous.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;

import static net.heterogeneous.block.RegisterBlocks.MAGICTABLE_BLOCK_ENTITY;


public class MagicTableBlockEntity extends BlockEntity {

    private boolean active = false;

    public MagicTableBlockEntity(BlockPos pos, BlockState state) {
        super(MAGICTABLE_BLOCK_ENTITY, pos, state);
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

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }



//    public MagicTableBlockEntity(BlockPos pos, BlockState state) {
//        super(Main.ANVIL_TABLE_BLOCK_ENTITY, pos, state);
//    }
//    @Override
//    public Text getDisplayName() {
//        // Using the block name as the screen title
//        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
//    }
//
//    @Override
//    protected Text getContainerName() {
//        return null;
//    }
//
//    @Override
//    protected DefaultedList<ItemStack> getInvStackList() {
//        return null;
//    }
//
//    @Override
//    protected void setInvStackList(DefaultedList<ItemStack> list) {
//
//    }
//
//    @Override
//    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
//        return new ExampleGuiDescription(syncId, inventory, ScreenHandlerContext.create(world, pos));
//    }
//
//    @Override
//    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
}
