package net.heterogeneous.blockentity;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.heterogeneous.block.RegisterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.ModelRotation;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.BlockRenderView;

public class LiquidContainerBlockEntityRenderer implements BlockEntityRenderer<LiquidContainerEntity>  {
    private static ItemStack stack = new ItemStack(RegisterBlocks.WATER, 1);
    public LiquidContainerBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }
    @Override
    public void render(LiquidContainerEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) );
        
        // matrices.;
        matrices.translate(+0.5, +0.3, +0.25);
        matrices.multiply(Quaternion.fromEulerXyz((float)Math.PI/2, (float)0, (float)0));
        matrices.scale((float)2, (float)2, (float)1);
        // Move the item
        // matrices.scale((float)(Math.random()*5),(float)Math.random()*5,(float)Math.random()*5);

        // Rotate the item
        // MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);
        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        
        // Mandatory call after GL calls
        matrices.pop();
        }
}
