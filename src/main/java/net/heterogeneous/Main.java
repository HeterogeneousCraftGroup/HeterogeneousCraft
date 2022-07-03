package net.heterogeneous;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.heterogeneous.block.RegisterBlocks;
import net.heterogeneous.entity.FireBullet;
import net.heterogeneous.entity.IceBullet;
import net.heterogeneous.gui.TestGui;
import net.heterogeneous.item.RegisterFoodItems;
import net.heterogeneous.item.RegisterItems;
import net.heterogeneous.item.RegisterMaterielsItems;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.heterogeneous.item.RegisterItems.INFUSION_STICK;

public class Main implements ModInitializer {
	public final static String ModID = "heterogeneouscraft";
	public static ScreenHandlerType<TestGui> SCREEN_HANDLER_TYPE ;
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final ItemGroup HC_GROUP = FabricItemGroupBuilder.create(
        new Identifier("heterogeneouscraft", "heterogeneouscraft"))
        .icon(() -> new ItemStack(INFUSION_STICK))
        .build();

	

	public static final EntityType<FireBullet> FireBulletEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "fire_bullet"),
			FabricEntityTypeBuilder.<FireBullet>create(SpawnGroup.MISC, FireBullet::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	public static final EntityType<IceBullet> IceBulletEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "ice_bullet"),
			FabricEntityTypeBuilder.<IceBullet>create(SpawnGroup.MISC, IceBullet::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);


		// public static final FireBullet FIRE_BULLET = new FireBullet(ENTITY_TYPE.firebullet, );
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.,

		LOGGER.info("Hello Fabric world!");

		SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier("heterogeneouscraft", "anvil_block"), (syncId, inventory) -> new TestGui(syncId, inventory, ScreenHandlerContext.EMPTY));

		RegisterBlocks.register();
		RegisterItems.register();
		RegisterFoodItems.register();
		RegisterMaterielsItems.register();

		// Registry.register(Registry.ITEM, new Identifier("tut", "bookpage"), BOOK_PAGE);
		EntityRendererRegistry.register(FireBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(IceBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
	}

}
