package net.heterogeneous.gui.widget;

import io.github.cottonmc.cotton.gui.client.LibGui;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Color;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.heterogeneous.item.Template;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class WForge extends WWidget {
    private final Inventory inv;
    ArrayList<WLine> al = new ArrayList<WLine>();
    public WForge(Inventory blockInventory){
        

        

        inv = blockInventory;
    }
    @Override
    public boolean canResize() {
        return true; // set to false if you want a static size
    }
    
    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        for (WLine wl : al) {
            wl.paint(matrices, x, y, mouseX, mouseY);
        }
        if(inv.getStack(0).getItem() == Items.AIR){
            return;
        }
        
//        Registry.ITEM.getId(inv.getStack(0).getItem());
        ScreenDrawing.texturedRect(matrices,x,y,100,100,new Texture(new Identifier(Registry.ITEM.getId(this.inv.getStack(0).getItem()).getNamespace(), String.format("textures/item/%s.png", Registry.ITEM.getId(this.inv.getStack(0).getItem()).getPath()))), 0xFF_FFFFFF);
    }
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    private Template template;


}
