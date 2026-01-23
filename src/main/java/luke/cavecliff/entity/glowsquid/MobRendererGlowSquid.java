package luke.cavecliff.entity.glowsquid;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.model.ModelSquid;
import net.minecraft.client.render.tessellator.Tessellator;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class MobRendererGlowSquid extends MobRenderer<MobGlowSquid> {
    public MobRendererGlowSquid(ModelBase modelbase, float f) {
        super(modelbase, f);
        this.setArmorModel(new ModelSquid());
    }

    @Override
    public float limbSway(MobGlowSquid squid, float partialTick) {
        return squid.oldTentacleAngle + (squid.tentacleAngle - squid.oldTentacleAngle) * partialTick;
    }

    @Override
    public void setupRotations(MobGlowSquid squid, float ticksExisted, float bodyYaw, float partialTick) {
        if (squid.isSpecial()) {
            super.setupRotations(squid, ticksExisted, bodyYaw, partialTick);
        } else {
            float pitch = squid.xBodyRotO + (squid.xBodyRot - squid.xBodyRotO) * partialTick;
            float yaw = squid.zBodyRotO + (squid.zBodyRot - squid.zBodyRotO) * partialTick;
            GL11.glTranslatef(0.0F, 0.5F, 0.0F);
            GL11.glRotatef(180.0F - bodyYaw, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.2F, 0.0F);
        }

    }

    @Override
    public void renderPreview(Tessellator tessellator, MobGlowSquid glowsquid, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 1.25F, 0.0F);
        super.renderPreview(tessellator, glowsquid, x, y, z, yaw, partialTick);
        GL11.glPopMatrix();
    }

    public boolean setGlowSquidBrightness(MobGlowSquid glowsquid, int renderPass) {
        if (renderPass == 0) {
            this.bindTexture("/assets/cavecliff/textures/entity/glowsquid/" + (glowsquid.getTextureReference() + ".png"));

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

    @Override
    public boolean prepareArmor(MobGlowSquid entity, int renderPass, float partialTick) {
        return this.setGlowSquidBrightness(entity, renderPass);
    }

}
