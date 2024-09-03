package luke.cavecliff.entity;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class AxolotlRenderer extends LivingRenderer<EntityAxolotl> {
	public ModelAxolotl modelAxolotlMain;
	public AxolotlRenderer(ModelAxolotl modelAxolotl, float shadowSize) {
		super(modelAxolotl, shadowSize);
		this.modelAxolotlMain = modelAxolotl;
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


	public void renderEquippedItems(EntityAxolotl entity, float f) {
		ItemStack itemstack = entity.getAxolotlHeldItem();
		if (itemstack != null && itemstack.getItem() != null) {
			GL11.glPushMatrix();
			this.modelAxolotlMain.axolotlHead.postRender(0.0625f);
			GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
			if (itemstack.itemID > 0 && itemstack.itemID < Block.blocksList.length && ((BlockModel<?>) BlockModelDispatcher.getInstance().getDispatch(Block.blocksList[itemstack.itemID])).shouldItemRender3d()) {
				float scale = 0.35f;
				GL11.glTranslatef(0.075f, -0.3f, -0.35f);
				GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
				GL11.glScalef(scale *= 0.75f, -scale, scale);
			} else {
				float scale = 0.375f;
				GL11.glTranslatef(0.25f, -0.25f, -0.35f);
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
				GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
				GL11.glRotatef(70.0f, 1.0f, 0.0f, 1.0f);
			}
			ItemModelDispatcher.getInstance().getDispatch(itemstack).renderItem(Tessellator.instance, this.renderDispatcher.itemRenderer, entity, itemstack);
			GL11.glPopMatrix();
		}
	}
}
