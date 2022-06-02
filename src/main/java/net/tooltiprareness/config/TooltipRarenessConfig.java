package net.tooltiprareness.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "tooltiprareness")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class TooltipRarenessConfig implements ConfigData {

    public boolean showRarenessTooltip = true;
    @Comment("Color in 0xHexadecimal - Incompatible with REI")
    public boolean showFrameColor = true;

    @ConfigEntry.Category("advanced_settings")
    public int common_frame_color = 0xFFAAAAAA;
    @ConfigEntry.Category("advanced_settings")
    public int uncommon_frame_color = 0xFF00AA00;
    @ConfigEntry.Category("advanced_settings")
    public int rare_frame_color = 0xFFFF5555;
    @ConfigEntry.Category("advanced_settings")
    public int epic_frame_color = 0xFFAA00AA;
    @ConfigEntry.Category("advanced_settings")
    public int legendary_frame_color = 0xFFFFAA00;
    @ConfigEntry.Category("advanced_settings")
    public int administrator_frame_color = 0xFF555555;
    @ConfigEntry.Category("advanced_settings")
    public int mythic_frame_color = 0xFF56EDF5;

    @ConfigEntry.Category("advanced_settings")
    public int common_second_frame_color = 0xFF2A2A2A;
    @ConfigEntry.Category("advanced_settings")
    public int uncommon_second_frame_color = 0xFF002A00;
    @ConfigEntry.Category("advanced_settings")
    public int rare_second_frame_color = 0xFF421515;
    @ConfigEntry.Category("advanced_settings")
    public int epic_second_frame_color = 0xFF2A002A;
    @ConfigEntry.Category("advanced_settings")
    public int legendary_second_frame_color = 0xFF664200;
    @ConfigEntry.Category("advanced_settings")
    public int administrator_second_frame_color = 0xFF151515;
    @ConfigEntry.Category("advanced_settings")
    public int mythic_frame_color = 0xFF2ABCC7;

    @ConfigEntry.Category("advanced_settings")
    public boolean changeBackgroundColor = false;
    @ConfigEntry.Category("advanced_settings")
    public int backgroundColor = -267386864;

}
