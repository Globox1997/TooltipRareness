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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
@Mixin(value = ItemStack.class, priority = 999)
public class ItemStackMixin {

    private static final TagKey<Item> COMMON_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "common_item"));
    private static final TagKey<Item> UNCOMMON_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "uncommon_item"));
    private static final TagKey<Item> RARE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "rare_item"));
    private static final TagKey<Item> EPIC_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "epic_item"));
    private static final TagKey<Item> LEGENDARY_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "legendary_item"));
    private static final TagKey<Item> ADMIN_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "admin_item"));
    private static final TagKey<Item> MYTHIC_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "mythic_item"));
    private static final TagKey<Item> NONE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("tooltiprareness", "none_item"));

    @Inject(method = "getTooltip", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void getTooltipMixin(@Nullable PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> info, List<Text> list) {
        if (player != null) {
            ItemStack stack = (ItemStack) (Object) this;
            if (stack.isIn(COMMON_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.common_item.tooltip"));
            } else if (stack.isIn(UNCOMMON_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.uncommon_item.tooltip"));
            } else if (stack.isIn(RARE_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.rare_item.tooltip"));
            } else if (stack.isIn(EPIC_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.epic_item.tooltip"));
            } else if (stack.isIn(LEGENDARY_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.legendary_item.tooltip"));
            } else if (stack.isIn(ADMIN_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.admin_item.tooltip"));
            } else if (stack.isIn(MYTHIC_ITEM)) {
                list.add(1, new TranslatableText("item.tooltiprareness.mythic_item.tooltip"));
            } else if (stack.isIn(NONE_ITEM)) {
                list.add(0, new TranslatableText("item.tooltiprareness.none_item.tooltip"));
            } else {
                list.add(1, new TranslatableText("item.tooltiprareness.common_item.tooltip"));
            }
        }
    }

}
