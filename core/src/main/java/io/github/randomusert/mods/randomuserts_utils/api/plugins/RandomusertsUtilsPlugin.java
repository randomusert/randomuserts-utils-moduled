package io.github.randomusert.mods.randomuserts_utils.api.plugins;

import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public interface RandomusertsUtilsPlugin {

    public abstract String getId();

    default void initialize() {}

    default void populateCreativeTab(Consumer<ItemLike> output) {
    }
}