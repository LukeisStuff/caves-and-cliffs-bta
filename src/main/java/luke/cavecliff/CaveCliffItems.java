package luke.cavecliff;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoor;
import net.minecraft.core.item.ItemPlaceable;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffItems {

	private int itemID(String blockName) {
		return CaveCliffConfig.cfg.getInt("Item IDs." + blockName);
	}

	public static Item amethyst;

	public static Item ingotCopper;
	public static Item oreRawCopper;

	public static Item bucketPowderSnow;

	public static Item foodGlowBerries;

	public static Item recordOtherside;

	public void initilizeItems() {

		oreRawCopper = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/ore_raw_copper")
			.build(new Item("ore.raw.copper", itemID("oreRawCopper")));

		ingotCopper = new ItemBuilder(MOD_ID)
			.setIcon("cavecliff:item/ingot_copper")
			.build(new Item("ingot.copper", itemID("ingotCopper")));

	}
}
