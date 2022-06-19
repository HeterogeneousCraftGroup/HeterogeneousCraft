package net.fabricmc.example;

import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.*;
import net.minecraft.particle.ParticleEffect;

public class IceMagicBookPage extends MagicBookPage {

    public IceMagicBookPage(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public net.minecraft.util.TypedActionResult<net.minecraft.item.ItemStack> use(net.minecraft.world.World world, net.minecraft.entity.player.PlayerEntity user, net.minecraft.util.Hand hand) {
        
        double x = user.getRotationVector().getX()*2;
        double y = user.getRotationVector().getY()*2;
        double z = user.getRotationVector().getZ()*2;
        
        
        IceBullet ib =  new IceBullet(world, user.getX(), user.getY()+1, user.getZ());
        ib.addVelocity(x, y, z);
        world.spawnEntity(ib);
        
        
        // user.getStackInHand(hand).setCount(user.getStackInHand(hand).getCount()-1);
        user.getStackInHand(hand).decrement(1);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
    
}
