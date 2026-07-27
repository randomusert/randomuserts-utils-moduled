package io.github.randomusert.mods.randomuserts_utils.compat;

import com.refinedmods.refinedstorage.common.api.RefinedStorageApi;
import com.refinedmods.refinedstorage.fabric.api.RefinedStoragePlugin;
import io.github.randomusert.mods.randomuserts_utils.compat.init.ModRSItems;

public class RandomusertsUtilsRSPlugin implements RefinedStoragePlugin {
    @Override
    public void onApiAvailable(RefinedStorageApi api) {
        ModRSItems.initialize();
    }
}
