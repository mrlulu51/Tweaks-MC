package io.github.mrlulu51.tweaksmc.init;

import io.github.mrlulu51.tweaksmc.screen.TweaksConfigScreen;
import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.Helpers;
import io.github.mrlulu51.tweaksmc.util.interfaces.ITInitComponent;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.option.ControlsOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;

import java.util.List;

public class TScreenEvents implements ITInitComponent {

    @Override
    public void register() {
        ScreenEvents.AFTER_INIT.register(((client, screen, scaledWidth, scaledHeight) -> {
            if(screen instanceof ControlsOptionsScreen) {
                List<ClickableWidget> buttons = Screens.getButtons(screen);
                buttons.add(ButtonWidget.builder(Helpers.translatableText("screen", "config.button", Constants.MODID), button -> client.setScreen(new TweaksConfigScreen(screen)))
                        .position((screen.width - 150) / 2, screen.height - 26)
                        .build());
            }
        }));
    }
}
