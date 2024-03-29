package net.tooltiprareness.mixin;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.tooltiprareness.TooltipRareness;

@SuppressWarnings("unused")
@Environment(EnvType.CLIENT)
@Mixin(value = Screen.class, priority = 999)
public class ScreenMixin {

    // @Shadow
    // protected TextRenderer textRenderer;
    // @Shadow
    // protected Text title;
    // @Shadow
    // @Nullable
    // protected MinecraftClient client;

    // @Nullable
    // @Unique
    // private ItemStack tooltipItemStack;

    // @Inject(method = "getTooltipFromItem", at = @At("HEAD"))
    // private void getTooltipFromItem(ItemStack stack, CallbackInfoReturnable<List<Text>> info) {
    //     if (stack == null)
    //         this.tooltipItemStack = null;
    //     else
    //         this.tooltipItemStack = stack;
    // }

    // @Shadow
    // public List<Text> getTooltipFromItem(ItemStack stack) {
    //     return null;
    // }

    // @ModifyConstant(method = "renderTooltipFromComponents", constant = @Constant(intValue = 0x505000FF))
    // private int renderTooltipFromComponentsColorOneMixin(int original, MatrixStack matrices, List<TooltipComponent> components, int x, int y) {
    //     if (components.size() > 1 && this.tooltipItemStack != null && TooltipRareness.CONFIG.showFrameColor && !(client.currentScreen instanceof CreativeInventoryScreen)) {
    //         if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.common_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.common_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.uncommon_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.uncommon_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.rare_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.rare_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.epic_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.epic_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.legendary_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.legendary_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.admin_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.administrator_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.mythic_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.mythic_frame_color;
    //     }

    //     return original;
    // }

    // @ModifyConstant(method = "renderTooltipFromComponents", constant = @Constant(intValue = 1344798847))
    // private int renderTooltipFromComponentsColorTwoMixin(int original, MatrixStack matrices, List<TooltipComponent> components, int x, int y) {
    //     if (components.size() > 1 && TooltipRareness.CONFIG.showFrameColor && !(client.currentScreen instanceof CreativeInventoryScreen))
    //         if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.common_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.common_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.uncommon_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.uncommon_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.rare_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.rare_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.epic_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.epic_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.legendary_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.legendary_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.admin_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.administrator_second_frame_color;
    //         else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.mythic_item.tooltip").getString()))
    //             return TooltipRareness.CONFIG.mythic_second_frame_color;
    //     return original;
    // }

    // Background color - issue with architectury mod -> incompat with REI
    // @ModifyConstant(method = "renderTooltipFromComponents", constant = @Constant(intValue = -267386864))
    // private int renderTooltipFromComponentsColorThirdMixin(int original) {
    //     if (TooltipRareness.CONFIG.changeBackgroundColor)
    //         return TooltipRareness.CONFIG.backgroundColor;
    //     return original;
    // }

    // @Inject(method = "renderTooltipFromComponents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V"))
    // private void renderTooltipFromComponentsMixin(MatrixStack matrices, List<TooltipComponent> components, int x, int y, CallbackInfo info) {
    //     if (components.size() > 1 && !TooltipRareness.CONFIG.showRarenessTooltip && !(client.currentScreen instanceof CreativeInventoryScreen))
    //         components.remove(1);
    // }

    // @ModifyVariable(method = "renderTooltipFromComponents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V"), ordinal = 7)
    // private int renderTooltipFromComponentsMixin(int original, MatrixStack matrices, List<TooltipComponent> components, int x, int y) {
    //     if (components.size() > 1 && !TooltipRareness.CONFIG.showRarenessTooltip && !(client.currentScreen instanceof CreativeInventoryScreen)) {
    //         return original - components.get(1).getHeight();
    //     } else
    //         return original;
    // }

}
