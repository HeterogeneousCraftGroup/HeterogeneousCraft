package net.heterogeneous.item;

import net.heterogeneous.entity.FireBullet;
import net.minecraft.util.TypedActionResult;

public class FireMagicBookPage extends MagicBookPage {

    public FireMagicBookPage(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public net.minecraft.util.TypedActionResult<net.minecraft.item.ItemStack> use(net.minecraft.world.World world, net.minecraft.entity.player.PlayerEntity user, net.minecraft.util.Hand hand) {
        
        double x = user.getRotationVector().getX()*2;
        double y = user.getRotationVector().getY()*2;
        double z = user.getRotationVector().getZ()*2;
        
        
        FireBullet fb =  new FireBullet(world, user.getX(), user.getY()+1, user.getZ());
        fb.addVelocity(x, y, z);
        world.spawnEntity(fb);
        
        
        // user.getStackInHand(hand).setCount(user.getStackInHand(hand).getCount()-1);
        user.getStackInHand(hand).decrement(1);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
    
}