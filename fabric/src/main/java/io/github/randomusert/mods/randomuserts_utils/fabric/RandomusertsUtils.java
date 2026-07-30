package io.github.randomusert.mods.randomuserts_utils.fabric;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import io.github.randomusert.mods.randomuserts_utils.api.config.ConfigManager;
import io.github.randomusert.mods.randomuserts_utils.api.init.CreativeTabs;
import io.github.randomusert.mods.randomuserts_utils.api.plugins.PluginManager;
import io.github.randomusert.mods.randomuserts_utils.api.plugins.RandomusertsUtilsPlugin;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;


public class RandomusertsUtils implements ModInitializer {
    public static final String MOD_ID = "rsts-utils";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static final CreativeModeTab RANDOMUSERTS_UTILS_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(Items.DIAMOND))
			.title(Component.translatable("creativeTab.randomuserts-utils-tab"))
			.displayItems((params, output) -> {
				PluginManager.getPlugins()
						.forEach(plugin -> plugin.populateCreativeTab(output::accept));
			})
			.build();

	List<RandomusertsUtilsPlugin> plugins = FabricLoader.getInstance()
			.getEntrypoints("rsts_utils_plugin", RandomusertsUtilsPlugin.class);

	@Override
	public void onInitialize() {
		LoggingHelper.info("Loading config");

		ConfigManager.load();

		LoggingHelper.info("Config loaded");

		LOGGER.debug("Loading {} Randomusert's Utils plugin entrypoints", plugins.size());

		FabricLoader.getInstance()
				.getEntrypoints("rsts_utils_plugin", RandomusertsUtilsPlugin.class)
				.forEach(plugin -> {
					PluginManager.register(plugin);

					if (ConfigManager.getConfig().isEnabled(plugin.getId())) {
						plugin.initialize();
					} else {
						LOGGER.info("Skipping disabled module '{}'.", plugin.getId());
					}
				});

		LOGGER.debug("Found {} Plugins", plugins.size());

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CreativeTabs.MAIN_TAB, RANDOMUSERTS_UTILS_TAB);

		LoggingHelper.info("Randomusert's Utils loaded");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}