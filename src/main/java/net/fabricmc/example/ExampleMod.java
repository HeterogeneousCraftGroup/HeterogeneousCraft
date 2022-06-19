package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.checkerframework.common.returnsreceiver.qual.This;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public final static String ModID = "examplemod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
    public static final FireMagicBookPage CUSTOM_ITEM = new FireMagicBookPage(new FabricItemSettings().group(ItemGroup.MISC));
	public static final EntityType<FireBullet> FireBulletEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "fire_bullet"),
			FabricEntityTypeBuilder.<FireBullet>create(SpawnGroup.MISC, FireBullet::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	public static final EntityType<FireBullet> IceBulletEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "ice_bullet"),
			FabricEntityTypeBuilder.<FireBullet>create(SpawnGroup.MISC, FireBullet::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	// public static final FireBullet FIRE_BULLET = new FireBullet(ENTITY_TYPE.firebullet, );
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("tut", "custom_item"), CUSTOM_ITEM);
		EntityRendererRegistry.register(FireBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(IceBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
		// Registry.register(Registry.ENTITY_TYPE, new Identifier("tut","firebullet"), FIRE_BULLET)
	}
	
}
