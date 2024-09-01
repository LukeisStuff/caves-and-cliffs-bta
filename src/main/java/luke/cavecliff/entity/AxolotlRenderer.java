package luke.cavecliff.entity;

import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.tessellator.Tessellator;

public class AxolotlRenderer extends LivingRenderer<EntityAxolotl> {
	public AxolotlRenderer(ModelBase modelbase, float f) {
		super(modelbase, f);
	}

	public void renderAxolotl(EntityAxolotl entityaxolotl, double d, double d1, double d2, float f, float f1) {
		super.render(entityaxolotl, d, d1, d2, f, f1);
	}

	public void render(EntityAxolotl entityaxolotl, double x, double y, double z, float yaw, float partialTick) {
		this.renderAxolotl(entityaxolotl, x, y, z, yaw, partialTick);
	}

	public void doRender(Tessellator tessellator, EntityAxolotl entityaxolotl, double x, double y, double z, float yaw, float partialTick) {
		this.renderAxolotl(entityaxolotl, x, y, z, yaw, partialTick);
	}
}
