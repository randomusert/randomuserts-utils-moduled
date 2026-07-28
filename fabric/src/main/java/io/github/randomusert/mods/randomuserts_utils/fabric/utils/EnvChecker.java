package io.github.randomusert.mods.randomuserts_utils.fabric.utils;

import io.github.randomusert.mods.randomuserts_utils.api.LoggingHelper;
import net.fabricmc.loader.api.FabricLoader;

public final class EnvChecker {

    public static boolean checkEnv() {
        boolean isDevEnv = FabricLoader.getInstance().isDevelopmentEnvironment();

        LoggingHelper.info(isDevEnv
                ? "DEV environment detected"
                : "PROD environment detected");

        return isDevEnv;
    }
}
