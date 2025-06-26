package com.raspberryclient.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(modid = RaspberryClient.MODID, name = "Raspberry Client", version = RaspberryClient.VERSION, acceptedMinecraftVersions = "1.8.9")
public class RaspberryClient {
    public static final String MODID = "raspberryclient";
    public static final String VERSION = "1.0.0";
    public static final Logger LOGGER = LoggerFactory.getLogger("RaspberryClient");

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Raspberry Client initialized!");
        // Initialize cosmetics manager
        CosmeticsManager.init();
        // Load extra modules from the modules folder
        ModuleLoader.loadModules();
    }
}
