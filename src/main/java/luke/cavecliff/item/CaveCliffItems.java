package luke.cavecliff.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDiscMusic;
import net.minecraft.core.item.ItemFood;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.cavecliff.CaveCliffConfig.itemID;
import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffItems {

    public static Item AMETHYST;

    public static Item INGOT_COPPER;
    public static Item ORE_RAW_COPPER;

    public static Item FOOD_GLOW_BERRIES;

    public static Item HORN_GOAT;

    public static Item INKSAC_GLOW;

    public static Item RECORD_OTHERSIDE;

    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeItems();
        }
    }

    public static String itemKey(String string) {
        return MOD_ID + ":item/" + string;
    }

    public static void initializeItems() {

        AMETHYST = new ItemBuilder(MOD_ID)
            .build(new Item("amethyst", itemKey("amethyst"), itemID("AMETHYST")));

        ORE_RAW_COPPER = new ItemBuilder(MOD_ID)
            .build(new Item("ore.raw.copper", itemKey("ore_raw_copper"), itemID("ORE_RAW_COPPER")));

        INGOT_COPPER = new ItemBuilder(MOD_ID)
            .build(new Item("ingot.copper", itemKey("ingot_copper"), itemID("INGOT_COPPER")));

        FOOD_GLOW_BERRIES = new ItemBuilder(MOD_ID)
            .build(new ItemFood("food.berries", itemKey("food_glow_berries"), itemID("FOOD_GLOW_BERRIES"), 2, 4, false, 6));

        HORN_GOAT = new ItemBuilder(MOD_ID)
            .build(new ItemHorn("horn.goat", itemKey("horn_goat"), itemID("HORN_GOAT")).setMaxStackSize(1));

        INKSAC_GLOW = new ItemBuilder(MOD_ID)
            .build(new Item("inksac.glow", itemKey("inksac_glow"), itemID("INKSAC_GLOW")));

        RECORD_OTHERSIDE = new ItemBuilder(MOD_ID)
            .setStackSize(1)
            .build(new ItemDiscMusic("record.otherside", itemKey("record_otherside"), itemID("RECORD_OTHERSIDE"), "cavecliff:otherside", "Lena Raine"));

    }
}
