package net.heterogeneous.gui;

import java.util.Optional;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot.ChangeListener;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.heterogeneous.Main;
import net.heterogeneous.gui.widget.WTexturePanel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseMeltingFurnaceGui extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 27;
    private static final int COUNT = 5;
    private static final int X = 176;
    private static final int Y = 130;
    private static final int PI_Y = Y-(18*3)-11;
    public BaseMeltingFurnaceGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Main.BASE_MELTING_FURNACE_SCREEN, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
        WTexturePanel root = new WTexturePanel();
        setRootPanel(root);
        root.setSize(X, Y);
        root.setInsets(Insets.ROOT_PANEL);
        // get the block entity from the context
        Optional<Object> blockEntity = context.get((world,pos)->{
                System.out.print("");
            }
        );
        
        
        WItemSlot oresSlot = new WItemSlot(blockInventory, 0, 1, 1, false);
        ((TheSimpleInventory)blockInventory).setChangeEvent(new Runnable() {
            @Override
            public void run() {
                
            }
        });
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
}
