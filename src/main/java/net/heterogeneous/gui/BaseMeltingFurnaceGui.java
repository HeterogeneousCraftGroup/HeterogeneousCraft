package net.heterogeneous.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.heterogeneous.Main;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class BaseMeltingFurnaceGui extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 27;
    private static final int COUNT = 5;
    private static final int X = 176;
    private static final int Y = 145;
    private static final int PI_Y = Y-(18*3)-11;
    public BaseMeltingFurnaceGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Main.BASE_MELTING_FURNACE_SCREEN, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(X, Y);
        root.setInsets(Insets.ROOT_PANEL);


        WItemSlot oresSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot fuelSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot endSlot_one = WItemSlot.of(blockInventory, 0);
        WItemSlot endSlot_two = WItemSlot.of(blockInventory, 0);
        WItemSlot endSlot_three = WItemSlot.of(blockInventory, 0);
        root.add(oresSlot, 42, 10);
        root.add(fuelSlot, 42, 46);
        root.add(endSlot_one, 82, 53);
        root.add(endSlot_two, 100, 53);
        root.add(endSlot_three, 118, 53);

        root.add(this.createPlayerInventoryPanel(), 0, PI_Y);

        root.validate(this);
    }
//    @Override
//    public void addPainters() {
//    }
}
