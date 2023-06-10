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
    private static int renderModifyMixin(int original) {
        if (TooltipRareness.CONFIG.changeBackgroundColor) {
            return TooltipRareness.CONFIG.backgroundColor;
        }
        return original;
    }

    @ModifyConstant(method = "render", constant = @Constant(intValue = 0x505000FF), require = 0)
    private static int renderBorderModifyOneMixin(int original) {
        if (TooltipRareness.CONFIG.changeBorderColor) {
            return TooltipRareness.CONFIG.borderColorStart;
        }
        return original;
    }

    @ModifyConstant(method = "render", constant = @Constant(intValue = 1344798847), require = 0)
    private static int renderBorderModifyTwoMixin(int original) {
        if (TooltipRareness.CONFIG.changeBorderColor) {
            return TooltipRareness.CONFIG.borderColorEnd;
        }
        return original;
    }

}
