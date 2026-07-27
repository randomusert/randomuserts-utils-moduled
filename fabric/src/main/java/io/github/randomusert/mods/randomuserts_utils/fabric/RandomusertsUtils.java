package io.github.randomusert.mods.randomuserts_utils.fabric;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import io.github.randomusert.mods.randomuserts_utils.api.plugins.RandomusertsUtilsPlugin;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class RandomusertsUtils implements ModInitializer {
    public static final String MOD_ID = "rsts-utils";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	List<RandomusertsUtilsPlugin> plugins = FabricLoader.getInstance()
			.getEntrypoints("rsts_utils_plugin", RandomusertsUtilsPlugin.class);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		LoggingHelper.info("Test from the Randomusert's Utils API");

		LOGGER.debug("Loading {} Randomusert's Utils plugin entrypoints", plugins.size());

		plugins.forEach(plugin -> {
			plugin.initialize();
		});

		LoggingHelper.info("Randomusert's Utils loaded");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}