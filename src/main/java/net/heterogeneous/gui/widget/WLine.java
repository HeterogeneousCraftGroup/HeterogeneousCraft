package net.heterogeneous.gui.widget;

import java.util.Random;

import org.lwjgl.glfw.GLFW;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class WLine extends WWidget {
    private static final Random random= new Random();
    private int r = 0;
    public WLine() { 
    }
    @Override
    public void onKeyPressed(int ch, int key, int modifiers) {

    }
    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        ScreenDrawing.coloredRect(matrices, x, y, width, height, 0xAA_FF0000);
        String s = null;
        if(r == 0){
            s = "→";
        }
        else if(r == 1){
            s = "↓";
        }
        else if(r == 2){
            s = "←";
        }
        else if(r == 3){
            s = "↑";
        }
        ScreenDrawing.drawString(matrices, s, x, y, 0xFF_FFFFFF);

    }
    
    @Override
    public InputResult onClick(int x, int y, int button) {
        System.out.println(String.format("hello%d",button));
        if(button==0){
            if(r == 0){

                int a = 5;
                this.x+=a;
            }
            else if (r==1){
                int a = 5;
                this.y+=a;
            }
            else if (r==2){
                int a = 5;
                this.x-=a;
            }
            else if (r==3){
                int a = 5;
                this.y-=a;
            }
        }
        else{
            if(r < 3){
                r++;
            }
            else{
                r = 0;
            }
        }
        return super.onClick(x, y, button);
    }
    
}
