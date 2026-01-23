package luke.cavecliff.blockmodel;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;

@Environment(EnvType.CLIENT)
public class BlockModelDripleafSmall<T extends BlockLogic> extends BlockModelStandard<T> {
    public BlockModelDripleafSmall(Block<T> block) {
        super(block);
    }

    public boolean render(Tessellator tessellator, int x, int y, int z) {
        float brightness = 1.0F;
        if (!LightmapHelper.isLightmapEnabled()) {
            brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
        } else {
            tessellator.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
        }

        int metadata = renderBlocks.blockAccess.getBlockMetadata(x, y, z);
        IconCoordinate texIndex = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, metadata);
        if (renderBlocks.overrideBlockTexture != null) {
            texIndex = renderBlocks.overrideBlockTexture;
        }

        tessellator.setColorOpaque_F(255.0F * brightness, 255.0F * brightness, 255.0F * brightness);
        IconCoordinate tex = this.getBlockTextureFromSideAndMetadata(Side.TOP, renderBlocks.blockAccess.getBlockMetadata(x, y, z));

        double minU = texIndex.getIconUMin();
        double maxU = texIndex.getIconUMax();
        double minV = texIndex.getIconVMin();
        double maxV = texIndex.getIconVMax();
        double minX = (double) x + 0.5 - 0.45;
        double maxX = (double) x + 0.5 + 0.45;
        double minZ = (double) z + 0.5 - 0.45;
        double maxZ = (double) z + 0.5 + 0.45;
        tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, minZ, minU, minV);
        tessellator.addVertexWithUV(minX, (double) y + 0.0, minZ, minU, maxV);
        tessellator.addVertexWithUV(maxX, (double) y + 0.0, maxZ, maxU, maxV);
        tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, maxZ, maxU, minV);
        tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, maxZ, minU, minV);
        tessellator.addVertexWithUV(maxX, (double) y + 0.0, maxZ, minU, maxV);
        tessellator.addVertexWithUV(minX, (double) y + 0.0, minZ, maxU, maxV);
        tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, minZ, maxU, minV);
        tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, maxZ, minU, minV);
        tessellator.addVertexWithUV(minX, (double) y + 0.0, maxZ, minU, maxV);
        tessellator.addVertexWithUV(maxX, (double) y + 0.0, minZ, maxU, maxV);
        tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, minZ, maxU, minV);
        tessellator.addVertexWithUV(maxX, (double) y + 1.0 + 0.0, minZ, minU, minV);
        tessellator.addVertexWithUV(maxX, (double) y + 0.0, minZ, minU, maxV);
        tessellator.addVertexWithUV(minX, (double) y + 0.0, maxZ, maxU, maxV);
        tessellator.addVertexWithUV(minX, (double) y + 1.0 + 0.0, maxZ, maxU, minV);

        renderPetal(tessellator, x, y + 0.20, z, tex, 0);
        renderPetal(tessellator, x, y + 0.65, z, tex, 90);
        renderPetal(tessellator, x, y + 0.35, z, tex, 180);
        renderPetal(tessellator, x, y + 0.80, z, tex, 270);

        return true;
    }

    public void renderPetal(Tessellator tessellator, int x, double y, int z, IconCoordinate tex, double rotationDegrees) {
        double centerX = x + 0.5;
        double centerZ = z + 0.5;
        double size = 0.45;
        double rotationRadians = Math.toRadians(rotationDegrees);

        double cos = Math.cos(rotationRadians);
        double sin = Math.sin(rotationRadians);

        double[][] baseVertices = {
            {-size, 0, -size},
            {-size, 0, size},
            {size, 0, size},
            {size, 0, -size}
        };

        double[][] vertices = new double[4][3];
        for (int i = 0; i < 4; i++) {
            double rotX = baseVertices[i][0] * cos - baseVertices[i][2] * sin;
            double rotZ = baseVertices[i][0] * sin + baseVertices[i][2] * cos;
            vertices[i][0] = centerX + rotX;
            vertices[i][1] = y;
            vertices[i][2] = centerZ + rotZ;
        }

        double minU = tex.getIconUMin();
        double maxU = tex.getIconUMax();
        double minV = tex.getIconVMin();
        double maxV = tex.getIconVMax();

        tessellator.addVertexWithUV(vertices[0][0], vertices[0][1], vertices[0][2], minU, minV);
        tessellator.addVertexWithUV(vertices[1][0], vertices[1][1], vertices[1][2], minU, maxV);
        tessellator.addVertexWithUV(vertices[2][0], vertices[2][1], vertices[2][2], maxU, maxV);
        tessellator.addVertexWithUV(vertices[3][0], vertices[3][1], vertices[3][2], maxU, minV);

        tessellator.addVertexWithUV(vertices[3][0], vertices[3][1], vertices[3][2], maxU, minV);
        tessellator.addVertexWithUV(vertices[2][0], vertices[2][1], vertices[2][2], maxU, maxV);
        tessellator.addVertexWithUV(vertices[1][0], vertices[1][1], vertices[1][2], minU, maxV);
        tessellator.addVertexWithUV(vertices[0][0], vertices[0][1], vertices[0][2], minU, minV);
    }

    @Override
    public boolean shouldItemRender3d() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(WorldSource blockAccess, AABB bounds, int x, int y, int z, int side) {
        return side == 1 || super.shouldSideBeRendered(blockAccess, bounds, x, y, z, side);
    }
}
