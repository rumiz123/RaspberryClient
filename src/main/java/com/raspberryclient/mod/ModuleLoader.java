package com.raspberryclient.mod;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ServiceLoader;

/**
 * Loads additional RaspberryModule implementations from the "modules" folder.
 */
public class ModuleLoader {
    private static final File MODULE_DIR = new File("modules");

    public static void loadModules() {
        if (!MODULE_DIR.exists()) {
            MODULE_DIR.mkdirs();
        }
        File[] jars = MODULE_DIR.listFiles((dir, name) -> name.endsWith(".jar"));
        if (jars == null) {
            return;
        }
        for (File jar : jars) {
            try {
                URLClassLoader loader = new URLClassLoader(new URL[] { jar.toURI().toURL() });
                ServiceLoader<RaspberryModule> services = ServiceLoader.load(RaspberryModule.class, loader);
                for (RaspberryModule mod : services) {
                    RaspberryClient.LOGGER.info("Loading module: {}", mod.getName());
                    mod.initialize();
                }
            } catch (Exception e) {
                RaspberryClient.LOGGER.error("Failed to load module from " + jar.getName(), e);
            }
        }
    }
}
