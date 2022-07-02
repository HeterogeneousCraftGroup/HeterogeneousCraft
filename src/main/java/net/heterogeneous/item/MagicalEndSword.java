package net.heterogeneous.item;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class MagicalEndSword extends Item {

    public MagicalEndSword(Settings settings) {

        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // 默认为白色文本
        tooltip.add( new TranslatableText("whitetiphere") );

        // 格式化为红色文本
        tooltip.add( new TranslatableText("redtiphere").formatted(Formatting.RED) );
    }


}
