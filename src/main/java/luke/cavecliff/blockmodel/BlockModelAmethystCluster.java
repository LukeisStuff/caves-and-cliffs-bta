package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockLogicAmethystCluster;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;

public class BlockModelAmethystCluster<T extends BlockLogicAmethystCluster> extends BlockModelCrossedSquares<T> {

	public BlockModelAmethystCluster(Block<T> block) {
		super(block);
	}

	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		int meta = renderBlocks.blockAccess.getBlockMetadata(x, y, z);
		Side facing = BlockLogicAmethystCluster.getFacingFromMetadata(meta);

		float brightness = 1.0F;
		if (!LightmapHelper.isLightmapEnabled()) {
			brightness = getBlockBrightness(renderBlocks.blockAccess, x, y, z);
		} else {
			tessellator.setLightmapCoord(block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
		}
		int color = BlockColorDispatcher.getInstance().getDispatch(block).getWorldColor(renderBlocks.blockAccess, x, y, z);
		float r = (float) (color >> 16 & 255) / 255.0F;
		float g = (float) (color >> 8 & 255) / 255.0F;
		float b = (float) (color & 255) / 255.0F;
		tessellator.setColorOpaque_F(brightness * r, brightness * g, brightness * b);

		IconCoordinate texIndex = this.getBlockTextureFromSideAndMetadata(facing, meta);
		if (renderBlocks.overrideBlockTexture != null) {
			texIndex = renderBlocks.overrideBlockTexture;
		}
		double minU = texIndex.getIconUMin();
		double maxU = texIndex.getIconUMax();
		double minV = texIndex.getIconVMin();
		double maxV = texIndex.getIconVMax();

		double minX, maxX, minY, maxY, minZ, maxZ;
		double u0, u1, v0, v1;
		switch (facing) {
			case BOTTOM:
				minX = (double) x + 0.5 - 0.45F;
				maxX = (double) x + 0.5 + 0.45F;
				minY = (double) y + 1.0 - 1.0;
				maxY = (double) y + 1.0;
				minZ = (double) z + 0.5 - 0.45F;
				maxZ = (double) z + 0.5 + 0.45F;
				u0 = minU;
				u1 = maxU;
				v0 = maxV;
				v1 = minV;
				break;
			case NORTH:
				minX = (double) x + 0.5 - 0.45F;
				maxX = (double) x + 0.5 + 0.45F;
				minY = (double) y + 0.5 - 0.45F;
				maxY = (double) y + 0.5 + 0.45F;
				minZ = (double) z + 1.0 - 1.0;
				maxZ = (double) z + 1.0;
				u0 = minV;
				u1 = maxV;
				v0 = maxU;
				v1 = minU;
				break;
			case SOUTH:
				minX = (double) x + 0.5 - 0.45F;
				maxX = (double) x + 0.5 + 0.45F;
				minY = (double) y + 0.5 - 0.45F;
				maxY = (double) y + 0.5 + 0.45F;
				minZ = z;
				maxZ = (double) z + 1.0;
				u0 = maxV;
				u1 = minV;
				v0 = minU;
				v1 = maxU;
				break;
			case WEST:
				minX = (double) x + 1.0 - 1.0;
				maxX = (double) x + 1.0;
				minY = (double) y + 0.5 - 0.45F;
				maxY = (double) y + 0.5 + 0.45F;
				minZ = (double) z + 0.5 - 0.45F;
				maxZ = (double) z + 0.5 + 0.45F;
				u0 = minV;
				u1 = maxV;
				v0 = maxU;
				v1 = minU;
				break;
			case EAST:
				minX = x;
				maxX = (double) x + 1.0;
				minY = (double) y + 0.5 - 0.45F;
				maxY = (double) y + 0.5 + 0.45F;
				minZ = (double) z + 0.5 - 0.45F;
				maxZ = (double) z + 0.5 + 0.45F;
				u0 = maxV;
				u1 = minV;
				v0 = minU;
				v1 = maxU;
				break;
			default:
				minX = (double) x + 0.5 - 0.45F;
				maxX = (double) x + 0.5 + 0.45F;
				minY = y;
				maxY = (double) y + 1.0;
				minZ = (double) z + 0.5 - 0.45F;
				maxZ = (double) z + 0.5 + 0.45F;
				u0 = minU;
				u1 = maxU;
				v0 = minV;
				v1 = maxV;
				break;
		}

		tessellator.addVertexWithUV(minX, minY, minZ, u0, v1);
		tessellator.addVertexWithUV(minX, maxY, minZ, u0, v0);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, u1, v0);
		tessellator.addVertexWithUV(maxX, minY, maxZ, u1, v1);

		tessellator.addVertexWithUV(maxX, minY, minZ, u0, v1);
		tessellator.addVertexWithUV(maxX, maxY, minZ, u0, v0);
		tessellator.addVertexWithUV(minX, maxY, maxZ, u1, v0);
		tessellator.addVertexWithUV(minX, minY, maxZ, u1, v1);

		tessellator.addVertexWithUV(minX, minY, maxZ, u0, v1);
		tessellator.addVertexWithUV(minX, maxY, maxZ, u0, v0);
		tessellator.addVertexWithUV(maxX, maxY, minZ, u1, v0);
		tessellator.addVertexWithUV(maxX, minY, minZ, u1, v1);

		tessellator.addVertexWithUV(maxX, minY, maxZ, u0, v1);
		tessellator.addVertexWithUV(maxX, maxY, maxZ, u0, v0);
		tessellator.addVertexWithUV(minX, maxY, minZ, u1, v0);
		tessellator.addVertexWithUV(minX, minY, minZ, u1, v1);

		return true;
	}

}
