package net.heterogeneous.blockentity;

import net.heterogeneous.block.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import static net.heterogeneous.block.RegisterBlocks.MAGICALEND_CHEST_ENTITY;

public class MagicalendChestEntity extends BlockEntity implements ImplementedInventory {
    private boolean active = false;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(5, ItemStack.EMPTY);

    public MagicalendChestEntity(BlockPos pos, BlockState state) {
        super(MAGICALEND_CHEST_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putBoolean("active", active);
        super.writeNbt(nbt);
    }
}
