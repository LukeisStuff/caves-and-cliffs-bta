package luke.cavecliff;

import luke.cavecliff.item.ItemHorn;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDiscMusic;
import net.minecraft.core.item.ItemFood;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffItems {

	public static int itemID = CaveCliffConfig.blockIDs;

	public static int itemID(String itemName) {
		try {
			return CaveCliffConfig.cfg.getInt(CaveCliffConfig.ItemIDs + "." + itemName);
		} catch (NullPointerException e) {
			CaveCliffConfig.properties.addEntry(CaveCliffConfig.ItemIDs + "." + itemName, itemID);
			return itemID++;
		}
	}

	public static Item AMETHYST;

	public static Item INGOT_COPPER;
	public static Item ORE_RAW_COPPER;

	public static Item FOOD_GLOW_BERRIES;

	public static Item HORN_GOAT;

	public static Item INKSAC_GLOW;

	public static Item RECORD_OTHERSIDE;

	public void initilizeItems() {

		AMETHYST = new ItemBuilder(MOD_ID)
			.build(new Item("amethyst", "cavecliff:item/amethyst", itemID("AMETHYST")));

		ORE_RAW_COPPER = new ItemBuilder(MOD_ID)
			.build(new Item("ore.raw.copper", "cavecliff:item/ore_raw_copper", itemID("ORE_RAW_COPPER")));

		INGOT_COPPER = new ItemBuilder(MOD_ID)
			.build(new Item("ingot.copper", "cavecliff:item/ingot_copper", itemID("INGOT_COPPER")));

		FOOD_GLOW_BERRIES = new ItemBuilder(MOD_ID)
			.build(new ItemFood("food.berries", "cavecliff:item/food_glow_berries", itemID("FOOD_GLOW_BERRIES"), 2, 4, false, 6));

		HORN_GOAT = new ItemBuilder(MOD_ID)
			.build(new ItemHorn("horn.goat", "cavecliff:item/horn_goat", itemID("HORN_GOAT")).setMaxStackSize(1));

		INKSAC_GLOW = new ItemBuilder(MOD_ID)
			.build(new Item("inksac.glow", "cavecliff:item/inksac_glow", itemID("INKSAC_GLOW")));

		RECORD_OTHERSIDE = new ItemBuilder(MOD_ID)
			.setStackSize(1)
			.build(new ItemDiscMusic("record.otherside", "cavecliff:item/record_otherside", itemID("RECORD_OTHERSIDE"), "otherside", "Lena Raine"));

	}
}
