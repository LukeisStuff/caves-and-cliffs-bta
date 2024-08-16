package luke.cavecliff;

import luke.cavecliff.entity.*;
import turniplabs.halplibe.helper.EntityHelper;

public class CaveCliffEntities {
	public static int entityID = 160;

	public void initializeEntities() {
		EntityHelper.createEntity(EntityGlowSquid.class, entityID++, "Glowsquid", () -> new GlowSquidRenderer(new ModelGlowSquid(), 0.7f));
		EntityHelper.createEntity(EntityGoat.class, entityID++, "Goat", () -> new GoatRenderer(new ModelGoat(), 0.8f));

	}
}
