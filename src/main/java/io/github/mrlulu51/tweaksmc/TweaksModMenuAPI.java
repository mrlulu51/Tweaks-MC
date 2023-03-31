package io.github.mrlulu51.tweaksmc;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.mrlulu51.tweaksmc.screen.TweaksConfigScreen;

public class TweaksModMenuAPI implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return TweaksConfigScreen::new;
    }
}
