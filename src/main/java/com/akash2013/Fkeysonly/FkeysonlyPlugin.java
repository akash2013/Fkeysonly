package com.akash2013.Fkeysonly;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "F Keys Only"
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

        // Inventory tab (all layouts)
        if ((widgetId == 10551358 || widgetId == 10747959 || widgetId == 35913794) && config.blockInventory())
            event.consume();

        // Prayer tab (all layouts)
        if ((widgetId == 10551360 || widgetId == 10747961 || widgetId == 35913796) && config.blockPrayer())
            event.consume();

        // Magic tab (all layouts)
        if ((widgetId == 10551361 || widgetId == 10747962 || widgetId == 35913797) && config.blockMagic())
            event.consume();
    }
}