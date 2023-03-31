package io.github.mrlulu51.tweaksmc.init;

import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.Helpers;
import io.github.mrlulu51.tweaksmc.util.interfaces.ITInitComponent;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class TKeybinds implements ITInitComponent {

    public static KeyBinding shulkerViewKey;

    @Override
    public void register() {
        shulkerViewKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                Helpers.translatableText("key", "shulker_view_key", Constants.MODID).getString(),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_SHIFT,
                Helpers.translatableText("category", "keybinds", Constants.MODID).getString()
        ));
    }
}
