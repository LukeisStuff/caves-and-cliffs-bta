package luke.cavecliff;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemRecord;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffItems {

	public int itemID(String blockName) {
		return CaveCliffConfig.cfg.getInt("Item IDs." + blockName);
	}

	public static Item amethyst;

	public static Item ingotCopper;
	public static Item oreRawCopper;

	public static Item foodGlowBerries;

	public static Item recordOtherside;

	public void initilizeItems() {

		amethyst = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/amethyst")
			.build(new Item("amethyst", itemID("amethyst")));

		oreRawCopper = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/ore_raw_copper")
			.build(new Item("ore.raw.copper", itemID("oreRawCopper")));

		ingotCopper = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/ingot_copper")
			.build(new Item("ingot.copper", itemID("ingotCopper")));

		foodGlowBerries = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/glowberries")
			.build(new ItemFood("food.berries", itemID("foodGlowBerries"), 3, 4, false, 6));

		recordOtherside = new ItemBuilder(MOD_ID)
			.setIcon(MOD_ID + ":item/otherside")
			.setStackSize(1)
			.build(new ItemRecord("record.otherside", itemID("recordOtherside"), "otherside", "Lena Raine"));

	}
}
