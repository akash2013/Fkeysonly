package com.akash2013.Fkeysonly;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("fkeysonly")
public interface FkeysonlyConfig extends Config {
    // Only in combat
    @ConfigItem(
            keyName = "OnlyInCombat",
            name = "Only in combat",
            description = "Block tabs only when player is in combat (attacking or being attacked)",
            position = 0
    )
    default boolean OnlyInCombat() {
        return false;
    }

    // PvM main tabs
    @ConfigItem(
            keyName = "InventoryTab",
            name = "Inventory",
            description = "Block left-click on the Inventory tab",
            position = 1
    )
    default boolean InventoryTab() {
        return true;
    }

    @ConfigItem(
            keyName = "PrayerTab",
            name = "Prayer",
            description = "Block left-click on the Prayer tab",
            position = 2
    )
    default boolean PrayerTab() {
        return true;
    }

    @ConfigItem(
            keyName = "MagicTab",
            name = "Magic",
            description = "Block left-click on the Magic tab",
            position = 3
    )
    default boolean MagicTab() {
        return true;
    }

    @ConfigItem(
            keyName = "CombatTab",
            name = "Combat",
            description = "Block left-click on the Combat tab",
            position = 4
    )
    default boolean CombatTab() {
        return true;
    }

    @ConfigItem(
            keyName = "EquipmentTab",
            name = "Worn Equipment",
            description = "Block left-click on the Worn Equipment tab",
            position = 5
    )
    default boolean EquipmentTab() {
        return true;
    }
}
