package io.github.randomusert.mods.randomuserts_utils.compat;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import net.fabricmc.api.ModInitializer;

public class RandomusertsUtilsCompat implements ModInitializer {


    public static String MOD_ID = "data/randomuserts-utils-compat";

    @Override
    public void onInitialize() {
        LoggingHelper.info("Compat module loading API");
    }
}
