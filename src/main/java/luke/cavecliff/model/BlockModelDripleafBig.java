package luke.cavecliff.model;


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

import java.util.Random;

@Environment(EnvType.CLIENT)
public class BlockModelDripleafBig<T extends BlockLogic> extends BlockModelStandard<T> {
    public BlockModelDripleafBig(Block<T> block) {
        super(block);
    }

    @Override
    public boolean render(Tessellator tessellator, int x, int y, int z) {
        AABB bounds = this.block.getBlockBoundsFromState(renderBlocks.blockAccess, x, y, z);
        float brightness = 1.0F;
        if (!LightmapHelper.isLightmapEnabled()) {
            brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
        } else {
            tessellator.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
        }

        tessellator.setColorOpaque_F(255.0F * brightness, 255.0F * brightness, 255.0F * brightness);
        IconCoordinate tex = this.getBlockTextureFromSideAndMetadata(Side.TOP, renderBlocks.blockAccess.getBlockMetadata(x, y, z));

        int metadata = renderBlocks.blockAccess.getBlockMetadata(x, y, z);
        IconCoordinate texIndex = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, metadata);
        if (renderBlocks.overrideBlockTexture != null) {
            texIndex = renderBlocks.overrideBlockTexture;
        }

        double xd = x;
        double yd = y;
        double zd = z;
        long dRandom = (long) x * 3129871L ^ (long) z * 116129781L ^ (long) y;
        dRandom = dRandom * dRandom * 42317861L + dRandom * 11L;
        xd += ((double) ((float) (dRandom >> 16 & 15L) / 15.0F) - 0.5) * 0.25;
        yd += ((double) ((float) (dRandom >> 20 & 15L) / 15.0F) - 1.0) * 0.0;
        zd += ((double) ((float) (dRandom >> 24 & 15L) / 15.0F) - 0.5) * 0.25;

        double minU = texIndex.getIconUMin();
        double maxU = texIndex.getIconUMax();
        double minV = texIndex.getIconVMin();
        double maxV = texIndex.getIconVMax();
        double minX = xd + 0.5 - 0.45;
        double maxX = xd + 0.5 + 0.45;
        double minZ = zd + 0.5 - 0.45;
        double maxZ = zd + 0.5 + 0.45;
        double yMinus = -0.99f;
        tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0 + yMinus, minZ, minU, minV);
        tessellator.addVertexWithUV(minX, yd + 0.0 + yMinus, minZ, minU, maxV);
        tessellator.addVertexWithUV(maxX, yd + 0.0 + yMinus, maxZ, maxU, maxV);
        tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0 + yMinus, maxZ, maxU, minV);
        tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0 + yMinus, maxZ, minU, minV);
        tessellator.addVertexWithUV(maxX, yd + 0.0 + yMinus, maxZ, minU, maxV);
        tessellator.addVertexWithUV(minX, yd + 0.0 + yMinus, minZ, maxU, maxV);
        tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0 + yMinus, minZ, maxU, minV);
        tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0 + yMinus, maxZ, minU, minV);
        tessellator.addVertexWithUV(minX, yd + 0.0 + yMinus, maxZ, minU, maxV);
        tessellator.addVertexWithUV(maxX, yd + 0.0 + yMinus, minZ, maxU, maxV);
        tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0 + yMinus, minZ, maxU, minV);
        tessellator.addVertexWithUV(maxX, yd + 1.0 + 0.0 + yMinus, minZ, minU, minV);
        tessellator.addVertexWithUV(maxX, yd + 0.0 + yMinus, minZ, minU, maxV);
        tessellator.addVertexWithUV(minX, yd + 0.0 + yMinus, maxZ, maxU, maxV);
        tessellator.addVertexWithUV(minX, yd + 1.0 + 0.0 + yMinus, maxZ, maxU, minV);

        long seed = (long) x * 3129871 ^ (long) z * 116129781L ^ (long) y;
        Random random = new Random(seed);
        float rotationDegrees = random.nextInt(4) * 90.0F;

        renderRotatedFace(tessellator, bounds, x, y - 0.1125, z, tex, rotationDegrees, true);
        renderRotatedFace(tessellator, bounds, x, y - 0.1125, z, tex, rotationDegrees, false);

        return true;
    }

    private void renderRotatedFace(Tessellator tessellator, AABB bounds, int x, double y, int z, IconCoordinate tex, float rotationDegrees, boolean isTopFace) {
        double centerX = x + 0.5;
        double centerZ = z + 0.5;

        double minU = tex.getIconUMin();
        double maxU = tex.getIconUMax();
        double minV = tex.getIconVMin();
        double maxV = tex.getIconVMax();

        double rotationRadians = Math.toRadians(rotationDegrees);
        double cos = Math.cos(rotationRadians);
        double sin = Math.sin(rotationRadians);

        double[][] baseVertices = {
            {bounds.minX - 0.5, 0, bounds.minZ - 0.5},
            {bounds.minX - 0.5, 0, bounds.maxZ - 0.5},
            {bounds.maxX - 0.5, 0, bounds.maxZ - 0.5},
            {bounds.maxX - 0.5, 0, bounds.minZ - 0.5}
        };

        double[][] vertices = new double[4][3];
        for (int i = 0; i < 4; i++) {
            double rotX = baseVertices[i][0] * cos - baseVertices[i][2] * sin;
            double rotZ = baseVertices[i][0] * sin + baseVertices[i][2] * cos;
            vertices[i][0] = centerX + rotX;
            vertices[i][1] = y;
            vertices[i][2] = centerZ + rotZ;
        }

        if (isTopFace) {
            tessellator.addVertexWithUV(vertices[0][0], y, vertices[0][2], minU, minV);
            tessellator.addVertexWithUV(vertices[1][0], y, vertices[1][2], minU, maxV);
            tessellator.addVertexWithUV(vertices[2][0], y, vertices[2][2], maxU, maxV);
            tessellator.addVertexWithUV(vertices[3][0], y, vertices[3][2], maxU, minV);
        } else {
            tessellator.addVertexWithUV(vertices[3][0], y, vertices[3][2], maxU, minV);
            tessellator.addVertexWithUV(vertices[2][0], y, vertices[2][2], maxU, maxV);
            tessellator.addVertexWithUV(vertices[1][0], y, vertices[1][2], minU, maxV);
            tessellator.addVertexWithUV(vertices[0][0], y, vertices[0][2], minU, minV);
        }
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
