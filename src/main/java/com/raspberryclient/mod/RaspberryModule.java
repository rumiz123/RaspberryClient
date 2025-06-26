package com.raspberryclient.mod;

/**
 * Interface for modules that can be loaded by RaspberryClient.
 */
public interface RaspberryModule {
    /**
     * Initialize the module.
     */
    void initialize();

    /**
     * @return module name.
     */
    String getName();
}
