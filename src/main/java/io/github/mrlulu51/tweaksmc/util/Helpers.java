package io.github.mrlulu51.tweaksmc.util;

import net.minecraft.text.Text;

public class Helpers {

    public static Text translatableText(String prefix, String suffix, String modid) {
        return Text.translatable(prefix + "." + modid + "." + suffix);
    }
}
