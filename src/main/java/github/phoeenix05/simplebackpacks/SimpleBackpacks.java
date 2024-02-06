package github.phoeenix05.simplebackpacks;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBackpacks implements ModInitializer {
    public static final String MOD_ID = "simplebackpacks";
	public static final Logger LOGGER = LoggerFactory.getLogger(SimpleBackpacks.MOD_ID);

	public static final Item LEATHER_BACKPACK = register("leather_backpack", new FabricItemSettings());
	// public static final Item FOX_BACKPACK = register("fox_backpack", new FabricItemSettings());

	static Item register(String name, FabricItemSettings settings) {
		return Registry.register(Registries.ITEM, new Identifier(SimpleBackpacks.MOD_ID, name), new Item(settings));
	}

	@Override
	public void onInitialize() {
	}
}
