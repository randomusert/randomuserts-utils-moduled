package io.github.randomusert.mods.randomuserts_utils.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingHelper {
   private static final Logger LOGGER = LoggerFactory.getLogger("randomuserts-utils");
    public static void info(String message) {
        LOGGER.info("API: " + message);
    }

    public static void dbg(String msg) {
        LOGGER.debug("API: " + msg);
    }
}