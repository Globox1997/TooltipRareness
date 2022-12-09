package net.tooltiprareness;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tooltiprareness.config.TooltipRarenessConfig;

public class TooltipRareness implements ClientModInitializer {

    public static TooltipRarenessConfig CONFIG = new TooltipRarenessConfig();

    public static final TagKey<Item> COMMON_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "common_item"));
    public static final TagKey<Item> UNCOMMON_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "uncommon_item"));
    public static final TagKey<Item> RARE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "rare_item"));
    public static final TagKey<Item> EPIC_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "epic_item"));
    public static final TagKey<Item> LEGENDARY_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "legendary_item"));
    public static final TagKey<Item> ADMIN_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "admin_item"));
    public static final TagKey<Item> MYTHIC_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "mythic_item"));
    public static final TagKey<Item> NONE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("tooltiprareness", "none_item"));

    @Override
    public void onInitializeClient() {
        AutoConfig.register(TooltipRarenessConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(TooltipRarenessConfig.class).getConfig();
    }

}
