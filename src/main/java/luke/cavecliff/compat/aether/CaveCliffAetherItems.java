package luke.cavecliff.compat.aether;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffAetherItems {

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
    }


}
