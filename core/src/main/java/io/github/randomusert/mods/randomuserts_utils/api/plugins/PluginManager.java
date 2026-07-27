package io.github.randomusert.mods.randomuserts_utils.api.plugins;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PluginManager {
    private static final List<RandomusertsUtilsPlugin> PLUGINS = new ArrayList<>();

    public static void register(RandomusertsUtilsPlugin plugin) {
        PLUGINS.add(plugin);
    }

    public static List<RandomusertsUtilsPlugin> getPlugins() {
        return Collections.unmodifiableList(PLUGINS);
    }
}
