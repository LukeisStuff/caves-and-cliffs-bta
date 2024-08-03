package luke.cavecliff.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.tessellator.Tessellator;
import org.lwjgl.opengl.GL11;

public class GlowSquidRenderer extends LivingRenderer<EntityGlowSquid> {
	public GlowSquidRenderer(ModelBase modelbase, float f) {
		super(modelbase, f);
		this.setRenderPassModel(modelbase);
	}

	public float ticksExisted(EntityGlowSquid glowsquid, float partialTick) {
		return glowsquid.limbAnglePrev + (glowsquid.newLimbAngle - glowsquid.limbAnglePrev) * partialTick;
	}

	public void rotateModel(EntityGlowSquid glowsquid, float ticksExisted, float headYawOffset, float partialTick) {
		float pitch = glowsquid.prevPitch + (glowsquid.newPitch - glowsquid.prevPitch) * partialTick;
		float yaw = glowsquid.prevYaw + (glowsquid.newYaw - glowsquid.prevYaw) * partialTick;
		GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		GL11.glRotatef(180.0F - headYawOffset, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.2F, 0.0F);
	}

	public void doRenderPreview(Tessellator tessellator, EntityGlowSquid glowsquid, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.25F, 0.0F);
		super.doRenderPreview(tessellator, glowsquid, x, y, z, yaw, partialTick);
		GL11.glPopMatrix();
	}

	protected boolean setGlowSquidBrightness(EntityGlowSquid glowsquid, int renderPass) {
		if (renderPass == 0) {
			boolean useVariants = Minecraft.getMinecraft(this).gameSettings.mobVariants.value;
			this.loadTexture("/assets/cavecliff/textures/entity/glowsquid/" + (useVariants ? glowsquid.getSkinVariant() : 0) + ".png");
			float brightness = glowsquid.getBrightness(1.0F);
			if (LightmapHelper.isLightmapEnabled()) {
				LightmapHelper.setLightmapCoord(LightmapHelper.getLightmapCoord(15, 15));
			}

			float f1 = (1.0F - brightness) * 0.5F;
			GL11.glEnable(3042);
			GL11.glDisable(3008);
			GL11.glBlendFunc(770, 771);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
			return true;
		} else {
			return false;
		}
	}

	protected boolean shouldRenderPass(EntityGlowSquid entity, int renderPass, float partialTick) {
		return this.setGlowSquidBrightness(entity, renderPass);
	}

}
