package net.tooltiprareness.mixin;

import java.util.List;

import net.fabricmc.fabric.api.tag.TagFactory;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
@Mixin(Item.class)
public class ItemMixin {

    private static final Tag<Item> COMMON_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "common_item"));
    private static final Tag<Item> UNCOMMON_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "uncommon_item"));
    private static final Tag<Item> RARE_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "rare_item"));
    private static final Tag<Item> EPIC_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "epic_item"));
    private static final Tag<Item> LEGENDARY_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "legendary_item"));
    private static final Tag<Item> ADMIN_ITEM = TagFactory.ITEM.create(new Identifier("tooltiprareness", "admin_item"));

    @Inject(method = "appendTooltip", at = @At("HEAD"))
    private void appendTooltipMixin(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context,
            CallbackInfo info) {
        if (stack.isIn(COMMON_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.common_item.tooltip"));
        } else if (stack.isIn(UNCOMMON_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.uncommon_item.tooltip"));
        } else if (stack.isIn(RARE_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.rare_item.tooltip"));
        } else if (stack.isIn(EPIC_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.epic_item.tooltip"));
        } else if (stack.isIn(LEGENDARY_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.legendary_item.tooltip"));
        } else if (stack.isIn(ADMIN_ITEM)) {
            tooltip.add(new TranslatableText("item.tooltiprareness.admin_item.tooltip"));
        } else {
            tooltip.add(new TranslatableText("item.tooltiprareness.common_item.tooltip"));
        }
    }

}
