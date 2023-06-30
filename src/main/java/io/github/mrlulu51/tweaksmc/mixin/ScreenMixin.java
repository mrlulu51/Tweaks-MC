package io.github.mrlulu51.tweaksmc.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.mrlulu51.tweaksmc.Tweaks;
import io.github.mrlulu51.tweaksmc.config.TweaksConfigOptions;
import io.github.mrlulu51.tweaksmc.util.Constants;
import io.github.mrlulu51.tweaksmc.util.parser.NbtParser;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {

    @Shadow
    protected ItemRenderer itemRenderer;
    @Shadow
    @Nullable
    protected MinecraftClient client;
    @Shadow
    protected TextRenderer textRenderer;
    private final Identifier BACKGROUND_TEXTURE = new Identifier(Constants.MODID, "textures/gui/shulker_tooltip.png");

    @Inject(at = @At("HEAD"), method = "renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/item/ItemStack;II)V", cancellable = true)
    protected void renderTooltip(MatrixStack matrices, ItemStack stack, int x, int y, CallbackInfo info) {
        Block shulker = Block.getBlockFromItem(stack.getItem());
        if (shulker instanceof ShulkerBoxBlock && InputUtil.isKeyPressed(client.getWindow().getHandle(), KeyBindingHelper.getBoundKeyOf(Tweaks.getInstance().getKeybinds().shulkerViewKey).getCode()) && Tweaks.getInstance().getConfig().getOrFallback(TweaksConfigOptions.ENABLE_SHULKER_VIEWER_SHIFT_CLICK, true)) {
            this.renderCustomTooltip(stack, x, y, matrices);
            info.cancel();
        }
    }

    private void renderCustomTooltip(ItemStack stack, int x, int y, MatrixStack matrices) {
        NbtCompound shulkerNbt = stack.getOrCreateNbt();
        DefaultedList<ItemStack> inventory = shulkerNbt.contains("BlockEntityTag") ? NbtParser.readNbtToInventory(shulkerNbt.getCompound("BlockEntityTag")) : DefaultedList.ofSize(27, ItemStack.EMPTY);

        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        DrawableHelper.drawTexture(matrices, x + 10, y + 10, 420, 0, 0, 176, 64, 176, 64);

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack contained = inventory.get(i);
            if (!contained.isEmpty()) {
                matrices.push();
                matrices.translate(0.0f, 0.0f, 500);
                this.itemRenderer.renderInGuiWithOverrides(matrices, this.client.player, contained, x + 18 + 18 * (i % 9), y + 16 + 18 * MathHelper.floor(i / 9.), 0);
                this.itemRenderer.renderGuiItemOverlay(matrices, this.textRenderer, contained, x + 18 + 18 * (i % 9), y + 16 + 18 * MathHelper.floor(i / 9.), null);
                matrices.pop();
            }
        }
    }
}
