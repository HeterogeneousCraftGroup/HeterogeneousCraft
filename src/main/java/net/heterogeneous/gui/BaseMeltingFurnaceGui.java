package net.heterogeneous.gui;

import java.util.Optional;
import java.util.function.BiFunction;

import com.mojang.authlib.minecraft.client.MinecraftClient;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot.ChangeListener;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.heterogeneous.Main;
import net.heterogeneous.blockentity.BaseMeltingFurnaceEntity;
import net.heterogeneous.gui.widget.WTexturePanel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseMeltingFurnaceGui extends SyncedGuiDescription implements ChangeListener {
    private static final int INVENTORY_SIZE = 27;
    private static final int COUNT = 5;
    private static final int X = 176;
    private static final int Y = 130;
    private BlockEntity be = null;
    private static final int PI_Y = Y-(18*3)-11;
    
    @Environment(EnvType.CLIENT)
    public BaseMeltingFurnaceGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Main.BASE_MELTING_FURNACE_SCREEN, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
            Optional<BlockEntity> temp = context.get((world,pos)->{
                // System.out.print("pos"+pos+world);
                return world.getBlockEntity(pos);
            });
            if(temp.isPresent()){
                System.out.println(temp);
                System.out.println(Thread.currentThread());
            }
            else{
                System.out.print(getPropertyDelegate().get(0));
                System.out.println("no block entity");
                System.out.println(Thread.currentThread());
            }
            System.out.print(getBlockPropertyDelegate(context));
            // be = temp.get();
            WTexturePanel root = new WTexturePanel(be);
            setRootPanel(root);
            root.setSize(X, Y);
            root.setInsets(Insets.ROOT_PANEL);
            // get the block entity from the context
            WItemSlot oresSlot = new WItemSlot(blockInventory, 0, 1, 1, false);
            oresSlot.addChangeListener(this);
            WItemSlot fuelSlot = new WItemSlot(blockInventory, 1, 1, 1, false);
            WItemSlot endSlot_one = new WItemSlot(blockInventory, 2, 1, 1, false);
            WItemSlot endSlot_two = new WItemSlot(blockInventory, 3, 1, 1, false);
            WItemSlot endSlot_three = new WItemSlot(blockInventory, 4, 1, 1, false);
            root.add(oresSlot, 39, 9);
            root.add(fuelSlot, 39, 45);
            root.add(endSlot_one, 82, 50);
            root.add(endSlot_two, 100, 50);
            root.add(endSlot_three, 118, 50);
    
            root.add(this.createPlayerInventoryPanel(), 0, PI_Y);
    
            root.validate(this);
        

      
    }
//    @Override
//    public void addPainters() {
//    }
    @Override
    public void onStackChanged(WItemSlot slot, Inventory inventory, int index, ItemStack stack) {
        // TODO Auto-generated method stub
        if (stack.getItem() == Items.LAVA_BUCKET & be != null) {
            stack.decrement(-1);
            ((BaseMeltingFurnaceEntity)be).setFuelTime(1000);
        } 
    }
}
