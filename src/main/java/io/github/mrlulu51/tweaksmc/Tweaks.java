package io.github.mrlulu51.tweaksmc;

import io.github.lgatodu47.catconfig.CatConfig;
import io.github.mrlulu51.tweaksmc.config.TweaksConfig;
import io.github.mrlulu51.tweaksmc.init.TKeybinds;
import io.github.mrlulu51.tweaksmc.init.TScreenEvents;
import io.github.mrlulu51.tweaksmc.util.interfaces.ITInitComponent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class Tweaks implements ClientModInitializer {

    private static Tweaks instance;
    private CatConfig config;
    private TKeybinds keybinds;

    @Override
    public void onInitializeClient() {
        // Registering Config
        config = new TweaksConfig();

        // Init Game Screens Changes
        new TScreenEvents().register();
        (keybinds = new TKeybinds()).register();

        // Registering instance
        instance = this;
    }

    public CatConfig getConfig() {
        return config;
    }

    public TKeybinds getKeybinds() {
        return keybinds;
    }

    public static Tweaks getInstance() {
        return instance;
    }
}
