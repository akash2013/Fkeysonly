package com.akash2013.Fkeysonly;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "F Keys Only",
        description = "Blocks mouse clicks on main PvM tabs, requiring F-keys. Supports all layouts.",
        tags = {"pvm", "fkeys", "tabs"}
)
public class FkeysonlyPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private FkeysonlyConfig config;

    @Provides
    FkeysonlyConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(FkeysonlyConfig.class);
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        int widgetId = event.getWidgetId();

        if (event.getMenuAction() != MenuAction.CC_OP)
            return;

        // --- Only in combat check ---
        if (config.OnlyInCombat() && !isPlayerInCombat())
            return;

        // --- Main PvM tabs ---
        if (isInventoryTab(widgetId) && config.InventoryTab()) event.consume();
        if (isPrayerTab(widgetId) && config.PrayerTab()) event.consume();
        if (isMagicTab(widgetId) && config.MagicTab()) event.consume();
        if (isCombatTab(widgetId) && config.CombatTab()) event.consume();
        if (isEquipmentTab(widgetId) && config.EquipmentTab()) event.consume();
    }

    // --- Combat detection ---
    private boolean isPlayerInCombat()
    {
        Player local = client.getLocalPlayer();
        if (local == null)
            return false;

        // Hvis spilleren angriper noe
        if (local.getInteracting() != null)
            return true;

        // Hvis noen NPC angriper spilleren
        return client.getNpcs().stream().anyMatch(npc -> npc.getInteracting() == local);
    }

    // --- Helper-metoder for hovedtabs (alle layouts) ---
    private boolean isInventoryTab(int id) { return id==10551358||id==10747959||id==35913794; }
    private boolean isPrayerTab(int id) { return id==10551360||id==10747961||id==35913796; }
    private boolean isMagicTab(int id) { return id==10551361||id==10747962||id==35913797; }
    private boolean isCombatTab(int id) { return id==10551355||id==10747956||id==35913791; }
    private boolean isEquipmentTab(int id) { return id==10551359||id==10747960||id==35913795; }
}
