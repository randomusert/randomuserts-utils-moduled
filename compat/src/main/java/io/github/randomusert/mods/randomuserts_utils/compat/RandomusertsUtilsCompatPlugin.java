package io.github.randomusert.mods.randomuserts_utils.compat;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import io.github.randomusert.mods.randomuserts_utils.api.plugins.RandomusertsUtilsPlugin;
import io.github.randomusert.mods.randomuserts_utils.compat.init.ModRSItems;
import io.github.randomusert.mods.randomuserts_utils.compat.refinedstorage.storage.CustomItemstorageVariant;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RandomusertsUtilsCompatPlugin implements RandomusertsUtilsPlugin {


    @Override
    public void initialize() {
        LoggingHelper.info("Compat Init loading.....");
    }

    @Override
    public void populateCreativeTab(Consumer<ItemLike> output) {
        for (var variant : CustomItemstorageVariant.values()) {
            output.accept(ModRSItems.ITEM_STORAGE_PART.get(variant));
        }

        for (var variant : CustomItemstorageVariant.values()) {
            output.accept(ModRSItems.ITEM_DISK.get(variant));
        }
    }
}
