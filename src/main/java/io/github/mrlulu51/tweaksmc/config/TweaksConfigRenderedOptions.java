package io.github.mrlulu51.tweaksmc.config;

import io.github.lgatodu47.catconfigmc.RenderedConfigOption;
import io.github.lgatodu47.catconfigmc.RenderedConfigOptionBuilder;
import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.Helpers;

import java.util.List;

public class TweaksConfigRenderedOptions {

    private static final RenderedConfigOptionBuilder BUILDER = new RenderedConfigOptionBuilder();

    static {
        BUILDER.ofBoolean(TweaksConfigOptions.ENABLE_SHULKER_VIEWER_SHIFT_CLICK).setCommonTranslationKey(Helpers.translatableText("config", "shulker_view", Constants.MODID).getString()).build();
    }

    public static List<RenderedConfigOption<?>> options() {
        return BUILDER.optionsToRender();
    }

}
