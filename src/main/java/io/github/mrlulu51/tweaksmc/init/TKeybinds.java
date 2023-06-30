package io.github.mrlulu51.tweaksmc.init;

import io.github.mrlulu51.tweaksmc.util.interfaces.ITInitComponent;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class TKeybinds implements ITInitComponent {

    public KeyBinding shulkerViewKey;

    @Override
    public void register() {
        shulkerViewKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tweaks-mc.shulker_view_key",
                InputUtil.Type.KEYSYM,
                InputUtil.GLFW_KEY_LEFT_ALT,
                "category.tweaks-mc.keybinds"
        ));
    }
}
