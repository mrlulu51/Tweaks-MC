package io.github.mrlulu51.tweaksmc.config;

import io.github.lgatodu47.catconfigmc.RenderedConfigOption;
import io.github.lgatodu47.catconfigmc.RenderedConfigOptionBuilder;
import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.Helpers;

import java.util.List;

public class TweaksConfigRenderedOptions {

    private static final RenderedConfigOptionBuilder BUILDER = new RenderedConfigOptionBuilder();

    static {
        BUILDER.ofBoolean(TweaksConfigOptions.ENABLE_SHULKER_VIEWER_SHIFT_CLICK).setCommonTranslationKey("config.tweaks-mc.shulker_view").build();
    }

    public static List<RenderedConfigOption<?>> options() {
        return BUILDER.optionsToRender();
    }

}
