package net.tooltiprareness.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.tooltip.TooltipBackgroundRenderer;
import net.tooltiprareness.TooltipRareness;

@Environment(EnvType.CLIENT)
@Mixin(TooltipBackgroundRenderer.class)
public class TooltipBackgroundRendererMixin {

    @ModifyConstant(method = "render", constant = @Constant(intValue = -267386864), require = 0)
    private static int render(int original) {
        if (TooltipRareness.CONFIG.changeBackgroundColor)
            return TooltipRareness.CONFIG.backgroundColor;
        return original;
    }

    // @ModifyConstant(method = "renderTooltipFromComponents", constant = @Constant(intValue = 0x505000FF))
    // private int renderTooltipFromComponentsColorOneMixin(int original, MatrixStack matrices, List<TooltipComponent> components, int x, int y) {
    // if (components.size() > 1 && this.tooltipItemStack != null && TooltipRareness.CONFIG.showFrameColor && !(client.currentScreen instanceof CreativeInventoryScreen)) {
    // if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.common_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.common_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.uncommon_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.uncommon_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.rare_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.rare_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.epic_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.epic_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.legendary_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.legendary_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.admin_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.administrator_frame_color;
    // else if (getTooltipFromItem(this.tooltipItemStack).get(1).getString().equals(Text.translatable("item.tooltiprareness.mythic_item.tooltip").getString()))
    // return TooltipRareness.CONFIG.mythic_frame_color;
    // }

    // return original;
    // }
}
