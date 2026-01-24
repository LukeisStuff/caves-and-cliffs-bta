package luke.cavecliff;

import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffEntities {
    public static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeEntities();
        }
    }

    public static void initializeEntities() {
        EntityHelper.createEntity(MobGlowSquid.class, NamespaceID.getPermanent(MOD_ID, "glowsquid"), "guidebook.section.mob.glowsquid.name");
        EntityHelper.createEntity(MobGoat.class, NamespaceID.getPermanent(MOD_ID, "goat_mountain"), "guidebook.section.mob.goat.mountain.name");
        EntityHelper.createEntity(MobAxolotl.class, NamespaceID.getPermanent(MOD_ID, "axolotl"), "guidebook.section.mob.axolotl.name");
    }
}
