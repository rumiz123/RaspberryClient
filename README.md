# RaspberryClient

RaspberryClient is a minimal example client built on the Forge toolchain for Minecraft 1.8.9. It demonstrates how you might create a modular client similar to Lunar Client.

## Features

- **Forge** mod setup for Minecraft 1.8.9.
- Modular system that loads additional JARs from the `modules` directory.
- Simple cosmetics manager stub.
- Windows launcher generated via Launch4J.

This repository only contains a starting template. Many features would need to be implemented to reach parity with a full client.

## Building

```
./gradlew build
./gradlew launch4j # generates RaspberryClient.exe in build/launcher
```

The build requires internet access to download dependencies.

## Adding Modules

Drop additional mod JARs that implement `com.raspberryclient.mod.RaspberryModule` into the `modules` folder. They will be loaded on client startup.
