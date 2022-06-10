package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
// import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents.Register.Register;
import net.minecraft.util.registry.Registry;

// import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final TestItem ti = new TestItem(new FabricItemSettings().group(ItemGroup.MISC));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("unknown_mod", "testitem"),ti);
		LOGGER.info("Hello Fabric world!");
	}
}
