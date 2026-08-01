package net.uclas.uclascities;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import net.uclas.uclascities.item.ModItemGroups;
import net.uclas.uclascities.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UclasCityMod implements ModInitializer {
	public static final String MOD_ID = "uclascities";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}
