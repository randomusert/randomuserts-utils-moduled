package io.github.randomusert.mods.randomuserts_utils.compat;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import net.fabricmc.api.ModInitializer;

public class RandomusertsUtilsCompat implements ModInitializer {
    @Override
    public void onInitialize() {
        LoggingHelper.info("Compat module loading API");
    }
}
