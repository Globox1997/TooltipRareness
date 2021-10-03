package net.tooltiprareness;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.tooltiprareness.config.TooltipRarenessConfig;

public class TooltipRareness implements ClientModInitializer {

    public static TooltipRarenessConfig CONFIG = new TooltipRarenessConfig();

    @Override
    public void onInitializeClient() {
        AutoConfig.register(TooltipRarenessConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(TooltipRarenessConfig.class).getConfig();
    }

}
