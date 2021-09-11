package net.tooltiprareness.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FireworkStarItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(FireworkStarItem.class)
public class FireworkChargeItemMixin {

    @Inject(method = "appendTooltip", at = @At("HEAD"))
    private void appendTooltipMixin(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context,
                                    CallbackInfo info) {
        tooltip.add(new TranslatableText("item.tooltiprareness.uncommon_item.tooltip"));
    }

}