package net.fabricmc.example;

import net.fabricmc.loader.impl.lib.sat4j.pb.constraints.pb.OriginalBinaryClausePB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestItem extends Item{

    public TestItem(Settings settings) {
        super(settings);
        
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.sendMessage( Text.of("fuck"));
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
