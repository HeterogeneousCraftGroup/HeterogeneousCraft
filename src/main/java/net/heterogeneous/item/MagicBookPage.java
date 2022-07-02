package net.heterogeneous.item;
import net.minecraft.item.Item;
import net.minecraft.util.TypedActionResult;
public class MagicBookPage extends Item{

    public MagicBookPage(Settings settings) {
        
        super(settings);
    }

    @Override
    public net.minecraft.util.TypedActionResult<net.minecraft.item.ItemStack> use(net.minecraft.world.World world, net.minecraft.entity.player.PlayerEntity user, net.minecraft.util.Hand hand) {
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
    
}

