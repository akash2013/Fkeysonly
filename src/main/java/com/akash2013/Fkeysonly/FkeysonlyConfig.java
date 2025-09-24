package com.akash2013.Fkeysonly;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface FkeysonlyConfig extends Config
{
    @ConfigItem(
            keyName = "blockInventory",
            name = "Block Inventory Tab",
            description = "Block left-click on the inventory tab"
    )
    default boolean blockInventory()
    {
        return true;
    }

    @ConfigItem(
            keyName = "blockPrayer",
            name = "Block Prayer Tab",
            description = "Block left-click on the prayer tab"
    )
    default boolean blockPrayer()
    {
        return true;
    }

    @ConfigItem(
            keyName = "blockMagic",
            name = "Block Magic Tab",
            description = "Block left-click on the magic tab"
    )
    default boolean blockMagic()
    {
        return true;
    }
}
