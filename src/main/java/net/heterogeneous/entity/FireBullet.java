package net.heterogeneous.entity;

import net.heterogeneous.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class FireBullet extends ThrownItemEntity{
    // rand for random number generation
    private Random rand = new Random();


    public FireBullet(EntityType<? extends FireBullet> entityType, World world) {
        super(entityType, world);
    }

    public FireBullet(World world, LivingEntity livingEntity) {
        super(Main.FireBulletEntityType, livingEntity, world);
    }

    public FireBullet(World world, double x, double y, double z) {
        super(Main.FireBulletEntityType, x, y, z, world);
    }

    @Override
	protected Item getDefaultItem() {
		return Items.FIREWORK_STAR; // We will configure this later, once we have created the ProjectileItem.
	}
    @Override
    public void tick() {
        // particles
        if (this.world.isClient) {
            for (int i = 0; i < 2; ++i) {
                double d = this.rand.nextGaussian() * 0.02D;
                double e = this.rand.nextGaussian() * 0.02D;
                double f = this.rand.nextGaussian() * 0.02D;
                this.world.addParticle(ParticleTypes.FLAME, this.getX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), d, e, f);
                this.world.addParticle(ParticleTypes.FLAME, this.getX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), d, e, f);
                 
            }
        }
        super.tick();
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if (type == HitResult.Type.ENTITY) {
            ((EntityHitResult)hitResult).getEntity().damage(DamageSource.magic(this.getOwner(), this), 5.0f);
            ((EntityHitResult)hitResult).getEntity().setOnFireFor(10); //set onFire(true);
        }
        
        // this.kill();
        // this.world.addParticle(ParticleTypes.FLAME, this.getX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),0,0,0);
        // this.world.addParticle(ParticleTypes.FLAME, this.getX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),0,0,0);
        // this.world.addParticle(ParticleTypes.FLAME, this.getX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), this.getY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getZ() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),0,0,0);
        //play a expsion sound 
        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        if(type == HitResult.Type.BLOCK){
            if(((BlockHitResult)hitResult).getSide() == Direction.UP){
                this.world.setBlockState(((BlockHitResult)hitResult).getBlockPos().add(0, 1, 0), Blocks.FIRE.getDefaultState());
            }
        }

        
        
        // super.onBlockHit(blockHitResult);
        this.kill();
        
    }
    
    
}
            