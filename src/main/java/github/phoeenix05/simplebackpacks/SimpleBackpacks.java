package github.phoeenix05.simplebackpacks;

import github.phoeenix05.simplebackpacks.item.LeatherBackpack;
import github.phoeenix05.simplebackpacks.item.SmallLeatherBackpack;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBackpacks implements ModInitializer {
    public static final String MOD_ID = "simplebackpacks";
	public static final Logger LOGGER = LoggerFactory.getLogger(SimpleBackpacks.MOD_ID);

	public static final Item LEATHER_BACKPACK = register_item("leather_backpack", new LeatherBackpack(new FabricItemSettings()));
	public static final Item SMALL_LEATHER_BACKPACK = register_item("small_leather_backpack", new SmallLeatherBackpack(new FabricItemSettings()));

	static Item register_item(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(SimpleBackpacks.MOD_ID, name), item);
	}

	static void register_item_groups() {
		ItemGroup general = FabricItemGroup.builder()
				.icon(() -> new ItemStack(LEATHER_BACKPACK))
				.displayName(Text.translatable("itemGroup.simplebackpacks"))
				.entries((ctx, entries) -> {
					entries.add(LEATHER_BACKPACK);
					entries.add(SMALL_LEATHER_BACKPACK);
				})
				.build();
		Registry.register(Registries.ITEM_GROUP, new Identifier(SimpleBackpacks.MOD_ID, "general"), general);
	}

	@Override
	public void onInitialize() {
		register_item_groups();
	}
}
