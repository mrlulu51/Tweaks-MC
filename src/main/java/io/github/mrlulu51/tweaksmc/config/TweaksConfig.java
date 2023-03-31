package io.github.mrlulu51.tweaksmc.config;

import io.github.lgatodu47.catconfig.CatConfig;
import io.github.lgatodu47.catconfig.CatConfigLogger;
import io.github.lgatodu47.catconfig.ConfigOptionAccess;
import io.github.lgatodu47.catconfigmc.MinecraftConfigSides;
import io.github.mrlulu51.tweaksmc.util.Constants;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;

public class TweaksConfig extends CatConfig {

    public TweaksConfig() {
        super(MinecraftConfigSides.CLIENT, Constants.MODID, CatConfigLogger.delegate(LogManager.getLogger("Tweaks MC Config")));
    }


    @Override
    protected @NotNull ConfigOptionAccess getConfigOptions() {
        return TweaksConfigOptions.OPTIONS;
    }

    @Override
    protected @NotNull Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    protected @Nullable ConfigWatcher makeAndStartConfigWatcherThread() {
        ConfigWatcher watcher = new ConfigWatcher("Tweaks MC Config Watcher");
        watcher.start();
        return watcher;
    }
}
