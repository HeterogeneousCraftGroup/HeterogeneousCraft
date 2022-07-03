package net.heterogeneous.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.heterogeneous.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;

public class TestGui extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 27;

    public TestGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Main.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 200);
        root.setInsets(Insets.ROOT_PANEL);

        WItemSlot label = WItemSlot.of(getBlockInventory(context, 27), 0);
        root.add(label, 1, 1);

        root.add(this.createPlayerInventoryPanel(), 1, 3);

        root.validate(this);
    }
}