package io.github.mrlulu51.tweaksmc.config;

import io.github.lgatodu47.catconfig.ConfigOption;
import io.github.lgatodu47.catconfig.ConfigOptionBuilder;
import io.github.lgatodu47.catconfigmc.MinecraftConfigSides;

public class TweaksConfigOptions {

    private static final ConfigOptionBuilder BUILDER = ConfigOptionBuilder.create();
    public static final ConfigOptionBuilder OPTIONS = BUILDER;

    static {
        BUILDER.onSides(MinecraftConfigSides.CLIENT);
    }

    public static final ConfigOption<Boolean> ENABLE_SHULKER_VIEWER_SHIFT_CLICK = BUILDER.createBool("enable_shulker_viewer_shift_click", true);
}
