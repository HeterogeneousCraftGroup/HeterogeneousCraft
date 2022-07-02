package net.heterogeneous.blockentity;

import net.heterogeneous.Main;
import net.heterogeneous.gui.ExampleGuiDescription;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class AnvilTableBlockEntity extends LootableContainerBlockEntity implements NamedScreenHandlerFactory {
    public AnvilTableBlockEntity(BlockPos pos, BlockState state) {
        super(Main.ANVIL_TABLE_BLOCK_ENTITY, pos, state);
    }
    @Override
    public Text getDisplayName() {
        // Using the block name as the screen title
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    protected Text getContainerName() {
        return null;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return null;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {

    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ExampleGuiDescription(syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
