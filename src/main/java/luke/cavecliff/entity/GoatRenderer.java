package luke.cavecliff.entity;

import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.tessellator.Tessellator;

public class GoatRenderer extends LivingRenderer<EntityGoat> {
	public GoatRenderer(ModelBase modelbase, float f) {
		super(modelbase, f);
	}

	public void renderGoat(EntityGoat entitygoat, double d, double d1, double d2, float f, float f1) {
		super.render(entitygoat, d, d1, d2, f, f1);
	}

	public void render(EntityGoat entitygoat, double x, double y, double z, float yaw, float partialTick) {
		this.renderGoat(entitygoat, x, y, z, yaw, partialTick);
	}

	public void doRender(Tessellator tessellator, EntityGoat entitygoat, double x, double y, double z, float yaw, float partialTick) {
		this.renderGoat(entitygoat, x, y, z, yaw, partialTick);
	}
}
