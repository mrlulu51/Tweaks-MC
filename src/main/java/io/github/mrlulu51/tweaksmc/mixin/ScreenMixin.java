package io.github.mrlulu51.tweaksmc.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.mrlulu51.tweaksmc.init.TKeybinds;
import io.github.mrlulu51.tweaksmc.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {

    private final Identifier BACKGROUND_TEXTURE = new Identifier(Constants.MODID, "textures/gui/shulker_tooltip.png");

    @Inject(at = @At("HEAD"), method = "renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/item/ItemStack;II)V", cancellable = true)
    protected void renderTooltip(MatrixStack matrices, ItemStack stack, int x, int y, CallbackInfo info) {
        Block shulker = Block.getBlockFromItem(stack.getItem());
        if(shulker instanceof ShulkerBoxBlock) {
            this.renderCustomTooltip(stack, x, y, matrices);
            info.cancel();
        }
    }

    private void renderCustomTooltip(ItemStack stack, int x, int y, MatrixStack matrices) {
        NbtCompound shulkerNbt = stack.getNbt();
        if(shulkerNbt == null) return;

        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        DrawableHelper.drawTexture(matrices, x, y, 420, 0, 0, 176, 64, 176, 64);
    }
}
