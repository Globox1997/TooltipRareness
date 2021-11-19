# TooltipRareness
TooltipRareness is a Minecraft mod which divides items into rareness groups and shows it as a tooltip.

### Installation
TooltipRareness is a mod built for the [Fabric Loader](https://fabricmc.net/). It requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) and [Cloth Config API](https://www.curseforge.com/minecraft/mc-mods/cloth-config) to be installed separately;

### License
TooltipRareness is licensed under MIT.

### Datapacks
Modded items can get added to a rareness group via datapacks.\
Check out for how to create a datapack here: [Datapack Tutorial](https://minecraft.fandom.com/wiki/Tutorials/Creating_a_data_pack).  
TooltipRareness adds 6 different rareness groups to minecraft:\
* admin_item
* legendary_item
* epic_item
* rare_item
* uncommon_item
* common_item  

Just create a json file called like one of the rareness groups and put it under\
```data/tooltiprareness/tags/items/YOURFILE```\
An example how the json file can look like is here:


```
{
    "replace": false,
    "values": [
        "minecraft:dragon_egg"
    ]
}
```