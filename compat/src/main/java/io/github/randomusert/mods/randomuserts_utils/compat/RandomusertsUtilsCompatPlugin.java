package io.github.randomusert.mods.randomuserts_utils.compat;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import io.github.randomusert.mods.randomuserts_utils.api.plugins.RandomusertsUtilsPlugin;

public class RandomusertsUtilsCompatPlugin implements RandomusertsUtilsPlugin {
    @Override
    public void initialize() {
        LoggingHelper.info("Compat Init loading.....");
    }
}
