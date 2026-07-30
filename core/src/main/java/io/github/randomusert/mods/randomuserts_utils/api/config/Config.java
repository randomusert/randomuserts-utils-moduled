package io.github.randomusert.mods.randomuserts_utils.api.config;

public class Config {

    public Modules modules = new Modules();

    public int configVersion = 1;

    public static class Modules {
        public boolean compat = true;
        public boolean machines = true;
    }

    public boolean isEnabled(String pluginId) {
        return switch (pluginId) {
            case "compat" -> modules.compat;
            case "machines" -> modules.machines;
            default -> true;
        };
    }
}
