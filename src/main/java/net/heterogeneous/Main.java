package net.heterogeneous;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.heterogeneous.block.AnvilTable;
import net.heterogeneous.block.InfusionBlock;
import net.heterogeneous.block.MagicTable;
import net.heterogeneous.blockentity.AnvilTableBlockEntity;
import net.heterogeneous.blockentity.Infusion;
import net.heterogeneous.entity.FireBullet;
import net.heterogeneous.entity.IceBullet;
import net.heterogeneous.gui.ExampleGuiDescription;
import net.heterogeneous.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public final static String ModID = "examplemod";
	public static ScreenHandlerType<ExampleGuiDescription> SCREEN_HANDLER_TYPE ;
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static InfusionStick INFUSION_STICK;
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final ItemGroup TUT_GROUP = FabricItemGroupBuilder.create(
        new Identifier("tut", "tut"))
        .icon(() -> new ItemStack(INFUSION_STICK))
        .build();
    public static final FireMagicBookPage Fire = new FireMagicBookPage(new FabricItemSettings().group(TUT_GROUP));
	public static final IceMagicBookPage Ice = new IceMagicBookPage(new FabricItemSettings().group(TUT_GROUP));
	public static final MagicBookPage BOOK_PAGE = new MagicBookPage(new FabricItemSettings().group(TUT_GROUP));
	public static final Item MAGICALEND = new Item(new FabricItemSettings().group(TUT_GROUP));

	public static ToolItem MAGICAL_END_SWORD = new SwordItem(MagicalendTool.INSTANCE, 8, -2.4F, new FabricItemSettings().group(TUT_GROUP));

	

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
	public static final Block DEEPSLATE_MAGICALEND_ORE = new OreBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f), UniformIntProvider.create(1,20));
	public static final Block ANVILTABLE = new AnvilTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static BlockEntityType<AnvilTableBlockEntity> ANVIL_TABLE_BLOCK_ENTITY;
	public static final Block MAGICTABLE = new MagicTable(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static BlockEntityType<net.heterogeneous.blockentity.MagicTableBlockEntity> MagicTableBlockEntity;
	public static final Block INFUSION_BLOCK = new InfusionBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static BlockEntityType<Infusion> INFUSION;

		// public static final FireBullet FIRE_BULLET = new FireBullet(ENTITY_TYPE.firebullet, );
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.,

		LOGGER.info("Hello Fabric world!");
		INFUSION_STICK = new InfusionStick(new FabricItemSettings().group(TUT_GROUP));
		Registry.register(Registry.ITEM, new Identifier("tut", "fire"), Fire);
		Registry.register(Registry.ITEM, new Identifier("tut", "ice"), Ice);
		Registry.register(Registry.ITEM, new Identifier("tut", "bookpage"), BOOK_PAGE);
		Registry.register(Registry.ITEM, new Identifier("tut", "infusion_stick"), INFUSION_STICK);

		Registry.register(Registry.ITEM, new Identifier("tut", "infusion_block"), new BlockItem(INFUSION_BLOCK,new FabricItemSettings().group(TUT_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier("tut", "infusion_block"), INFUSION_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tut", "deepslate_magicalend_ore"), new BlockItem(DEEPSLATE_MAGICALEND_ORE,new FabricItemSettings().group(TUT_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier("tut", "deepslate_magicalend_ore"), DEEPSLATE_MAGICALEND_ORE);
		Registry.register(Registry.ITEM, new Identifier("tut", "magicalend"), MAGICALEND);
		Registry.register(Registry.BLOCK, new Identifier("tut", "anvil_table"), ANVILTABLE);
		Registry.register(Registry.ITEM, new Identifier("tut", "anvil_table"), new BlockItem(ANVILTABLE,new FabricItemSettings().group(TUT_GROUP)));

		Registry.register(Registry.ITEM, new Identifier("tut", "magic_table"), new BlockItem(MAGICTABLE,new FabricItemSettings().group(TUT_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier("tut", "magic_table"), MAGICTABLE);

		SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier("tut", "anvil_block"), (syncId, inventory) -> new ExampleGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

		Registry.register(Registry.ITEM, new Identifier("tut", "magicalend_sword"), MAGICAL_END_SWORD);

		// Registry.register(Registry.ITEM, new Identifier("tut", "bookpage"), BOOK_PAGE);
		EntityRendererRegistry.register(FireBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(IceBulletEntityType, (context) ->
				 new FlyingItemEntityRenderer(context));
		INFUSION = Registry.register(Registry.BLOCK_ENTITY_TYPE, "infusion", FabricBlockEntityTypeBuilder.create(Infusion::new, INFUSION_BLOCK).build(null));
		// Registry.register(Registry.ENTITY_TYPE, new Identifier("tut","firebullet"), FIRE_BULLET)
		ANVIL_TABLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "anvil_table", FabricBlockEntityTypeBuilder.create(AnvilTableBlockEntity::new, ANVILTABLE).build(null));
	}

}
