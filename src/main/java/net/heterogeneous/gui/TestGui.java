package net.heterogeneous.gui;

//public class TestGui extends SyncedGuiDescription {
//    private static final int INVENTORY_SIZE = 27;
//
//    public TestGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
//        super(Main.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));
//        WGridPanel root = new WGridPanel();
//        setRootPanel(root);
//        root.setSize(200, 200);
//        root.setInsets(Insets.ROOT_PANEL);
//
//        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
//        WDynamicLabel label = new WDynamicLabel(() -> String.valueOf(itemSlot.isHovered()));
//        root.add(itemSlot, 1, 1);
//        root.add(label, 2, 1);
//
//        root.add(this.createPlayerInventoryPanel(), 1, 3);
//
//        root.validate(this);
//    }
//}