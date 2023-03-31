package io.github.mrlulu51.tweaksmc.screen;

import io.github.lgatodu47.catconfigmc.screen.ModConfigScreen;
import io.github.mrlulu51.tweaksmc.Tweaks;
import io.github.mrlulu51.tweaksmc.config.TweaksConfigRenderedOptions;
import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.Helpers;
import net.minecraft.client.gui.screen.Screen;

public class TweaksConfigScreen extends ModConfigScreen {

    public TweaksConfigScreen(Screen parent) {
        super(Helpers.translatableText("screen", "config.title", Constants.MODID), parent, Tweaks.getInstance().getConfig(), TweaksConfigRenderedOptions::options);
    }
}
