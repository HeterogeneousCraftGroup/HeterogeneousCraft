package net.heterogeneous.blockentity;

import net.heterogeneous.gui.BaseMeltingFurnaceGui;
import net.heterogeneous.gui.TheSimpleInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import static net.heterogeneous.block.RegisterBlocks.BASE_MELTING_FURNACE_ENTITY;

public class BaseMeltingFurnaceEntity extends LootableContainerBlockEntity implements NamedScreenHandlerFactory, InventoryProvider {
    public Inventory inv = new TheSimpleInventory();

    public BaseMeltingFurnaceEntity(BlockPos pos, BlockState state) {
        super(BASE_MELTING_FURNACE_ENTITY, pos, state);
    }
    public BaseMeltingFurnaceEntity(BlockPos pos, BlockState state, World world ) {
        super(BASE_MELTING_FURNACE_ENTITY, pos, state);
        this.world = world;
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
        System.out.print(""+this.getWorld()+this.getPos());
        return new BaseMeltingFurnaceGui(syncId, inventory, ScreenHandlerContext.create(this.getWorld(), this.getPos()));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return (SidedInventory) inv;
    }
}
