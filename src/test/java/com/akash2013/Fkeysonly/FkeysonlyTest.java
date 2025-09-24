package com.akash2013.Fkeysonly;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class FkeysonlyTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(FkeysonlyPlugin.class);
		RuneLite.main(args);
	}
}