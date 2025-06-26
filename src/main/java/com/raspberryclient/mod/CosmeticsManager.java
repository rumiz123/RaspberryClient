package com.raspberryclient.mod;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages simple client-side cosmetics like capes.
 */
public class CosmeticsManager {
    private static final List<String> loadedCosmetics = new ArrayList<>();

    public static void init() {
        // In a real client, cosmetics would be loaded from a server or config.
        // Here we simply log and add a default cape.
        loadedCosmetics.add("default_cape");
        RaspberryClient.LOGGER.info("Cosmetics initialized with {} item(s)", loadedCosmetics.size());
    }
}
