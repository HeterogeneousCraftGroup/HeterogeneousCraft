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
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import static net.heterogeneous.block.RegisterBlocks.BASE_MELTING_FURNACE_ENTITY;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;

public class BaseMeltingFurnaceEntity extends LootableContainerBlockEntity implements PropertyDelegateHolder, NamedScreenHandlerFactory, InventoryProvider {
    public Inventory inv = new TheSimpleInventory();
    private float fuel;
    private float progress;
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate(){

        @Override
        public int get(int index) {
            switch (index) {
                case 0: {
                    return (int) BaseMeltingFurnaceEntity.this.fuel;
                }
                case 1: {
                    return  (int) BaseMeltingFurnaceEntity.this.progress;
                }
            }
            return 0;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0: {
                    BaseMeltingFurnaceEntity.this.fuel = value;
                    break;
                }
                case 1: {
                    BaseMeltingFurnaceEntity.this.progress = value;
                    break;
                }
            }
        }

        @Override
        public int size() {
            return 2;
        }
    };
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
        // System.out.print(""+this.getWtaorld()+this.getPos());
        return new BaseMeltingFurnaceGui(syncId, inventory, ScreenHandlerContext.create(this.getWorld(), this.getPos()));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }
    // @Override
    // public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
    //     return inv;
    //     // return super.getInventory(state, world, pos);
    // }
    @Override
    public int size() {
        return 0;
    }
    public static void tick(World world, BlockPos pos, BlockState state, BaseMeltingFurnaceEntity be) {
        be.fuel--;
        // System.out.print(pos);
    }
    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return (SidedInventory) inv;
    }
    public void setFuelTime(int i) {
        fuel = i;
    }
    public float getFuelTime(){
        return fuel;
    }
    @Override
    public PropertyDelegate getPropertyDelegate() {
        
        return propertyDelegate;
    }
}
