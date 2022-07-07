package net.heterogeneous.gui.widget;

import com.mojang.blaze3d.platform.GlStateManager;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.TextureMap;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;

public class WTexturePanel extends WPlainPanel{
    public WTexturePanel(){

    }
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        super.paint(matrices, x, y, mouseX, mouseY);

        ScreenDrawing.texturedGuiRect(matrices, x, y, 175, 165, new Identifier("heterogeneouscraft","textures/gui/base_melting_furnace.png"), 0X00_FFFFFF);
        
        ScreenDrawing.texturedRect(matrices, x+48, y+37, 14, 14, new Identifier("heterogeneouscraft","textures/gui/base_melting_furnace.png"), (float)0.6875, (float)0, (float)0.74, (float)0.054, 0X00_FFFFFF);
        ScreenDrawing.texturedRect(matrices, x+67, y+15, 38, 40, new Identifier("heterogeneouscraft","textures/gui/base_melting_furnace.png"), (float)0.6875, (float)0.058, (float)0.834, (float)0.207, 0X00_FFFFFF);

    }
}