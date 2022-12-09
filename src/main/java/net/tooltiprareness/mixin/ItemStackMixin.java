package net.tooltiprareness.mixin;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.tooltiprareness.TooltipRareness;

@Environment(EnvType.CLIENT)
@Mixin(value = ItemStack.class, priority = 999)
public class ItemStackMixin {

    @Inject(method = "getTooltip", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void getTooltipMixin(@Nullable PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> info, List<Text> list) {
        if (player != null) {
            ItemStack stack = (ItemStack) (Object) this;
            if (stack != null)
                if (stack.isIn(TooltipRareness.COMMON_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.common_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.UNCOMMON_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.uncommon_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.RARE_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.rare_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.EPIC_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.epic_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.LEGENDARY_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.legendary_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.ADMIN_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.admin_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.MYTHIC_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.mythic_item.tooltip"));
                } else if (stack.isIn(TooltipRareness.NONE_ITEM)) {
                    list.add(1, Text.translatable("item.tooltiprareness.none_item.tooltip"));
                } else {
                    list.add(1, Text.translatable("item.tooltiprareness.common_item.tooltip"));
                }
        }
    }

}
