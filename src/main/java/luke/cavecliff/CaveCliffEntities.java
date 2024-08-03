package luke.cavecliff;

import luke.cavecliff.entity.EntityGlowSquid;
import luke.cavecliff.entity.GlowSquidRenderer;
import luke.cavecliff.entity.ModelGlowSquid;
import turniplabs.halplibe.helper.EntityHelper;

public class CaveCliffEntities {
	private static int entityID = 160;

	public void initializeEntities() {
		EntityHelper.createEntity(EntityGlowSquid.class, entityID++, "Glowsquid", () -> new GlowSquidRenderer(new ModelGlowSquid(), 0.7f));
	}
}
