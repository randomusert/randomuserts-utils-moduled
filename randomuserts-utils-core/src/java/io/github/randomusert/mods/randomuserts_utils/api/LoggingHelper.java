package io.github.randomusert.mods.randomuserts_utils.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingHelper {
    public static void info(String message) {
         final Logger LOGGER = LoggerFactory.getLogger("randomuserts-utils");
        LOGGER.info("API: " + message);
    }
}