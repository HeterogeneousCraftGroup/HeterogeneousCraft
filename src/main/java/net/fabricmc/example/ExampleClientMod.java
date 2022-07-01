package net.fabricmc.example;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
public class ExampleClientMod implements ClientModInitializer {
    @Override
	public void onInitializeClient() {
        System.out.print("hello");
		BlockRenderLayerMap.INSTANCE.putBlock(ExampleMod.INFUSION_BLOCK, RenderLayer.getCutout());	
	}
}
