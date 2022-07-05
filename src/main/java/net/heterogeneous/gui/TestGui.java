package net.heterogeneous.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.WDynamicLabel;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.heterogeneous.Main;
import net.heterogeneous.gui.widget.WForge;
import net.heterogeneous.gui.widget.WLine;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class TestGui extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 27;
    private static final int COUNT = 5;

    public TestGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(Main.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(400, 200);
        root.setInsets(Insets.ROOT_PANEL);

        WForge wf = new WForge(blockInventory);
        root.add(wf,14,1);
        WItemSlot label = new WItemSlot(blockInventory, 0, 1, 1, false);
        root.add(label, 13, 1);
        for (int i = 0; i<COUNT;i++){
            WLine wl = new WLine();
            root.add(wl, (int) Math.round(Math.random()*5)+14, (int) Math.round(Math.random()*5));
        }
        root.add(this.createPlayerInventoryPanel(), 1, 3);

        root.validate(this);
    }
}