package net.heterogeneous;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.heterogeneous.gui.ExampleBlockScreen;
import net.heterogeneous.gui.TestGui;
import net.minecraft.client.render.RenderLayer;

import static net.heterogeneous.block.RegisterBlocks.INFUSION_BLOCK;
import static net.heterogeneous.block.RegisterBlocks.MAGICTABLE;

public class ClientMod implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
        System.out.print("hello");
		BlockRenderLayerMap.INSTANCE.putBlock(Main.INFUSION_BLOCK, RenderLayer.getTranslucent());
		ScreenRegistry.<TestGui, ExampleBlockScreen>register(Main.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new ExampleBlockScreen(gui, inventory.player, title));
		BlockRenderLayerMap.INSTANCE.putBlock(Main.MAGICTABLE, RenderLayer.getTranslucent());
//		BlockRenderLayerMap.INSTANCE.putBlock(Main.MAGICTABLE, RenderLayer.getCutout());

	}
}
