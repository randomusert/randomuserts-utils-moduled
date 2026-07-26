package io.github.randomusert.mods.randomuserts_utils.fabric;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;


public class RandomusertsUtils implements ModIntializer {
    public static final String MOD_ID = "rsts-utils";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	List<RstsUtilsPlugin> plugins = FabricLoader.getInstance()
			.getEntrypoints("rsts_utils_plugin", RstsUtilsPlugin.class);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		LoggingHelper.info("Test from the Randomusert's Utils API");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}