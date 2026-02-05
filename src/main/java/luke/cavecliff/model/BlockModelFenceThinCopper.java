package luke.cavecliff.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFenceThin;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class BlockModelFenceThinCopper<T extends BlockLogicFenceThin> extends BlockModelStandard<T> {
    private static final IconCoordinate[][] VARIANT_TEXTURES = new IconCoordinate[4][4];
    private static final int SIDE = 0;
    private static final int BOTTOM = 1;
    private static final int TOP = 2;
    private static final int COLUMN = 3;

    static {
        VARIANT_TEXTURES[0][SIDE] = TextureRegistry.getTexture("cavecliff:block/fence/center");
        VARIANT_TEXTURES[0][BOTTOM] = TextureRegistry.getTexture("cavecliff:block/fence/bottom");
        VARIANT_TEXTURES[0][TOP] = TextureRegistry.getTexture("cavecliff:block/fence/top");
        VARIANT_TEXTURES[0][COLUMN] = TextureRegistry.getTexture("cavecliff:block/fence/column");

        VARIANT_TEXTURES[1][SIDE] = TextureRegistry.getTexture("cavecliff:block/fence/center_exposed");
        VARIANT_TEXTURES[1][BOTTOM] = TextureRegistry.getTexture("cavecliff:block/fence/bottom_exposed");
        VARIANT_TEXTURES[1][TOP] = TextureRegistry.getTexture("cavecliff:block/fence/top_exposed");
        VARIANT_TEXTURES[1][COLUMN] = TextureRegistry.getTexture("cavecliff:block/fence/column_exposed");

        VARIANT_TEXTURES[2][SIDE] = TextureRegistry.getTexture("cavecliff:block/fence/center_weathered");
        VARIANT_TEXTURES[2][BOTTOM] = TextureRegistry.getTexture("cavecliff:block/fence/bottom_weathered");
        VARIANT_TEXTURES[2][TOP] = TextureRegistry.getTexture("cavecliff:block/fence/top_weathered");
        VARIANT_TEXTURES[2][COLUMN] = TextureRegistry.getTexture("cavecliff:block/fence/column_weathered");

        VARIANT_TEXTURES[3][SIDE] = TextureRegistry.getTexture("cavecliff:block/fence/center_oxidized");
        VARIANT_TEXTURES[3][BOTTOM] = TextureRegistry.getTexture("cavecliff:block/fence/bottom_oxidized");
        VARIANT_TEXTURES[3][TOP] = TextureRegistry.getTexture("cavecliff:block/fence/top_oxidized");
        VARIANT_TEXTURES[3][COLUMN] = TextureRegistry.getTexture("cavecliff:block/fence/column_oxidized");
    }

    public BlockModelFenceThinCopper(Block<T> block) {
        super(block);
    }

    private IconCoordinate getSideTexture(int meta) {
        int variant = Math.min(meta, 3);
        return VARIANT_TEXTURES[variant][SIDE];
    }

    private IconCoordinate getBottomTexture(int meta) {
        int variant = Math.min(meta, 3);
        return VARIANT_TEXTURES[variant][BOTTOM];
    }

    private IconCoordinate getTopTexture(int meta) {
        int variant = Math.min(meta, 3);
        return VARIANT_TEXTURES[variant][TOP];
    }

    private IconCoordinate getColumnTexture(int meta) {
        int variant = Math.min(meta, 3);
        return VARIANT_TEXTURES[variant][COLUMN];
    }

    @Override
    public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
        return getSideTexture(data);
    }

    @Override
    public boolean render(Tessellator t, int x, int y, int z) {
        int metadata = renderBlocks.blockAccess.getBlockMetadata(x, y, z);

        IconCoordinate texSide = getSideTexture(metadata);
        IconCoordinate texBottom = getBottomTexture(metadata);
        IconCoordinate texTop = getTopTexture(metadata);
        IconCoordinate texColumn = getColumnTexture(metadata);

        float brightness = 1.0F;
        if (LightmapHelper.isLightmapEnabled()) {
            t.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
        } else {
            brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
        }

        t.setColorOpaque_F(brightness, brightness, brightness);
        float cBottom = 1.0F;
        float cTop = 1.0F;
        float cNorthSouth = 1.0F;
        float cEastWest = 1.0F;
        if (RenderBlocks.enableDirectionalLight) {
            cBottom = 0.5F;
            cNorthSouth = 0.8F;
            cEastWest = 0.6F;
        }

        BlockLogicFenceThin thin = this.block.getLogic();
        boolean connectNorth = thin.canConnectTo(renderBlocks.blockAccess, x + Direction.NORTH.getOffsetX(), y + Direction.NORTH.getOffsetY(), z + Direction.NORTH.getOffsetZ());
        boolean connectSouth = thin.canConnectTo(renderBlocks.blockAccess, x + Direction.SOUTH.getOffsetX(), y + Direction.SOUTH.getOffsetY(), z + Direction.SOUTH.getOffsetZ());
        boolean connectEast = thin.canConnectTo(renderBlocks.blockAccess, x + Direction.EAST.getOffsetX(), y + Direction.EAST.getOffsetY(), z + Direction.EAST.getOffsetZ());
        boolean connectWest = thin.canConnectTo(renderBlocks.blockAccess, x + Direction.WEST.getOffsetX(), y + Direction.WEST.getOffsetY(), z + Direction.WEST.getOffsetZ());

        double onePix = 0.0625F;
        double fenceNormalMinU = texSide.getIconUMin();
        double fenceNormalMinV = texSide.getIconVMin();
        texSide.getSubIconU(onePix * (double) 16.0F);
        double fenceNormalMaxV = texSide.getSubIconV(onePix * (double) 16.0F);
        IconCoordinate fenceTopmostTex;
        if (texTop == null) {
            fenceTopmostTex = texSide;
        } else {
            fenceTopmostTex = texTop;
        }

        double fenceTopmostMinU = fenceTopmostTex.getIconUMin();
        double fenceTopmostMinV = fenceTopmostTex.getIconVMin();
        fenceTopmostTex.getSubIconU(onePix * (double) 16.0F);
        double fenceTopmostMaxV = fenceTopmostTex.getSubIconV(onePix * (double) 16.0F);
        IconCoordinate fenceBottommostTex;
        if (texBottom == null) {
            fenceBottommostTex = texSide;
        } else {
            fenceBottommostTex = texBottom;
        }

        double fenceBottommostMinU = fenceBottommostTex.getIconUMin();
        double fenceBottommostMinV = fenceBottommostTex.getIconVMin();
        fenceBottommostTex.getSubIconU(onePix * (double) 16.0F);
        double fenceBottommostMaxV = fenceBottommostTex.getSubIconV(onePix * (double) 16.0F);
        Block<?> blockAbove = renderBlocks.blockAccess.getBlock(x, y + 1, z);
        boolean connectUpNorth = blockAbove == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.NORTH.getOffsetX(), y + Direction.NORTH.getOffsetY() + 1, z + Direction.NORTH.getOffsetZ());
        boolean connectUpSouth = blockAbove == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.SOUTH.getOffsetX(), y + Direction.SOUTH.getOffsetY() + 1, z + Direction.SOUTH.getOffsetZ());
        boolean connectUpEast = blockAbove == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.EAST.getOffsetX(), y + Direction.EAST.getOffsetY() + 1, z + Direction.EAST.getOffsetZ());
        boolean connectUpWest = blockAbove == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.WEST.getOffsetX(), y + Direction.WEST.getOffsetY() + 1, z + Direction.WEST.getOffsetZ());
        Block<?> blockBelow = renderBlocks.blockAccess.getBlock(x, y - 1, z);
        boolean connectDownNorth = blockBelow == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.NORTH.getOffsetX(), y + Direction.NORTH.getOffsetY() - 1, z + Direction.NORTH.getOffsetZ());
        boolean connectDownSouth = blockBelow == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.SOUTH.getOffsetX(), y + Direction.SOUTH.getOffsetY() - 1, z + Direction.SOUTH.getOffsetZ());
        boolean connectDownEast = blockBelow == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.EAST.getOffsetX(), y + Direction.EAST.getOffsetY() - 1, z + Direction.EAST.getOffsetZ());
        boolean connectDownWest = blockBelow == this.block && thin.canConnectTo(renderBlocks.blockAccess, x + Direction.WEST.getOffsetX(), y + Direction.WEST.getOffsetY() - 1, z + Direction.WEST.getOffsetZ());
        if (thin.shouldDrawColumn(renderBlocks.blockAccess, x, y, z)) {
            double sidesMinU = texColumn.getIconUMin();
            double sidesMinV = texColumn.getIconVMin();
            double sidesMaxU = texColumn.getSubIconU(onePix * (double) 2.0F);
            double sidesMaxV = texColumn.getSubIconV(onePix * (double) 16.0F);
            float minX = (float) x + 0.4375F;
            float minY = (float) y;
            float minZ = (float) z + 0.4375F;
            float maxX = (float) x + 0.5625F;
            float maxY = (float) y + 1.0F;
            float maxZ = (float) z + 0.5625F;
            t.setColorOpaque_F(cNorthSouth * brightness, cNorthSouth * brightness, cNorthSouth * brightness);
            t.addVertexWithUV(maxX, minY, minZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMinU, sidesMinV);
            t.setColorOpaque_F(cEastWest * brightness, cEastWest * brightness, cEastWest * brightness);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, minZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMinU, sidesMinV);
            double topBottomMinU = texColumn.getIconUMin();
            double topBottomMinV = texColumn.getIconVMin();
            double topBottomMaxU = texColumn.getSubIconU(onePix * (double) 2.0F);
            double topBottomMaxV = texColumn.getSubIconV(onePix * (double) 2.0F);
            t.setColorOpaque_F(cTop * brightness, cTop * brightness, cTop * brightness);
            t.addVertexWithUV(minX, maxY, maxZ, topBottomMinU, topBottomMaxV);
            t.addVertexWithUV(maxX, maxY, maxZ, topBottomMaxU, topBottomMaxV);
            t.addVertexWithUV(maxX, maxY, minZ, topBottomMaxU, topBottomMinV);
            t.addVertexWithUV(minX, maxY, minZ, topBottomMinU, topBottomMinV);
            t.setColorOpaque_F(cBottom * brightness, cBottom * brightness, cBottom * brightness);
            t.addVertexWithUV(minX, minY, minZ, topBottomMinU, topBottomMinV);
            t.addVertexWithUV(maxX, minY, minZ, topBottomMaxU, topBottomMinV);
            t.addVertexWithUV(maxX, minY, maxZ, topBottomMaxU, topBottomMaxV);
            t.addVertexWithUV(minX, minY, maxZ, topBottomMinU, topBottomMaxV);
        }

        if (connectNorth) {
            double sidesMinU;
            double sidesMinV;
            double sidesMaxU;
            double sidesMaxV;
            if (texBottom != null && !connectDownNorth) {
                sidesMinU = fenceBottommostMinU;
                sidesMinV = fenceBottommostMinV;
                sidesMaxV = fenceBottommostMaxV;
                sidesMaxU = fenceBottommostTex.getSubIconU(onePix * (double) 8.0F);
            } else if (texTop != null && !connectUpNorth) {
                sidesMinU = fenceTopmostMinU;
                sidesMinV = fenceTopmostMinV;
                sidesMaxV = fenceTopmostMaxV;
                sidesMaxU = fenceTopmostTex.getSubIconU(onePix * (double) 8.0F);
            } else {
                sidesMinU = fenceNormalMinU;
                sidesMinV = fenceNormalMinV;
                sidesMaxV = fenceNormalMaxV;
                sidesMaxU = texSide.getSubIconU(onePix * (double) 8.0F);
            }

            float minX = (float) x + 0.5F;
            float minY = (float) y;
            float minZ = (float) z;
            float maxX = (float) x + 0.5F;
            float maxY = (float) y + 1.0F;
            float maxZ = (float) z + 0.5F;
            t.setColorOpaque_F(cEastWest * brightness, cEastWest * brightness, cEastWest * brightness);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMaxU, sidesMinV);
        }

        if (connectSouth) {
            double sidesMinU;
            double sidesMinV;
            double sidesMaxU;
            double sidesMaxV;
            if (texBottom != null && !connectDownSouth) {
                sidesMinU = fenceBottommostTex.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = fenceBottommostTex.getIconUMax();
                sidesMinV = fenceBottommostMinV;
                sidesMaxV = fenceBottommostMaxV;
            } else if (texTop != null && !connectUpSouth) {
                sidesMinU = fenceTopmostTex.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = fenceTopmostTex.getIconUMax();
                sidesMinV = fenceTopmostMinV;
                sidesMaxV = fenceTopmostMaxV;
            } else {
                sidesMinU = texSide.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = texSide.getIconUMax();
                sidesMinV = fenceNormalMinV;
                sidesMaxV = fenceNormalMaxV;
            }

            float minX = (float) x + 0.5F;
            float minY = (float) y;
            float minZ = (float) z + 0.5F;
            float maxX = (float) x + 0.5F;
            float maxY = (float) y + 1.0F;
            float maxZ = (float) z + 1.0F;
            t.setColorOpaque_F(cEastWest * brightness, cEastWest * brightness, cEastWest * brightness);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMaxU, sidesMinV);
        }

        if (connectWest) {
            double sidesMinU;
            double sidesMinV;
            double sidesMaxU;
            double sidesMaxV;
            if (texBottom != null && !connectDownWest) {
                sidesMinU = fenceBottommostMinU;
                sidesMinV = fenceBottommostMinV;
                sidesMaxV = fenceBottommostMaxV;
                sidesMaxU = fenceBottommostTex.getSubIconU(onePix * (double) 8.0F);
            } else if (texTop != null && !connectUpWest) {
                sidesMinU = fenceTopmostMinU;
                sidesMinV = fenceTopmostMinV;
                sidesMaxV = fenceTopmostMaxV;
                sidesMaxU = fenceTopmostTex.getSubIconU(onePix * (double) 8.0F);
            } else {
                sidesMinU = fenceNormalMinU;
                sidesMinV = fenceNormalMinV;
                sidesMaxV = fenceNormalMaxV;
                sidesMaxU = texSide.getSubIconU(onePix * (double) 8.0F);
            }

            float minX = (float) x;
            float minY = (float) y;
            float minZ = (float) z + 0.5F;
            float maxX = (float) x + 0.5F;
            float maxY = (float) y + 1.0F;
            float maxZ = (float) z + 0.5F;
            t.setColorOpaque_F(cNorthSouth * brightness, cNorthSouth * brightness, cNorthSouth * brightness);
            t.addVertexWithUV(maxX, minY, minZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMaxU, sidesMinV);
        }

        if (connectEast) {
            double sidesMinU;
            double sidesMinV;
            double sidesMaxU;
            double sidesMaxV;
            if (texBottom != null && !connectDownEast) {
                sidesMinU = fenceBottommostTex.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = fenceBottommostTex.getIconUMax();
                sidesMinV = fenceBottommostMinV;
                sidesMaxV = fenceBottommostMaxV;
            } else if (texTop != null && !connectUpEast) {
                sidesMinU = fenceTopmostTex.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = fenceTopmostTex.getIconUMax();
                sidesMinV = fenceTopmostMinV;
                sidesMaxV = fenceTopmostMaxV;
            } else {
                sidesMinU = texSide.getSubIconU(onePix * (double) 8.0F);
                sidesMaxU = texSide.getIconUMax();
                sidesMinV = fenceNormalMinV;
                sidesMaxV = fenceNormalMaxV;
            }

            float minX = (float) x + 0.5F;
            float minY = (float) y;
            float minZ = (float) z + 0.5F;
            float maxX = (float) x + 1.0F;
            float maxY = (float) y + 1.0F;
            float maxZ = (float) z + 0.5F;
            t.setColorOpaque_F(cNorthSouth * brightness, cNorthSouth * brightness, cNorthSouth * brightness);
            t.addVertexWithUV(maxX, minY, minZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(minX, minY, minZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(minX, maxY, minZ, sidesMaxU, sidesMinV);
            t.addVertexWithUV(maxX, maxY, minZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, minY, maxZ, sidesMaxU, sidesMaxV);
            t.addVertexWithUV(maxX, minY, maxZ, sidesMinU, sidesMaxV);
            t.addVertexWithUV(maxX, maxY, maxZ, sidesMinU, sidesMinV);
            t.addVertexWithUV(minX, maxY, maxZ, sidesMaxU, sidesMinV);
        }

        return true;
    }

    @Override
    public void renderBlockOnInventory(Tessellator tessellator, int metadata, float brightness, float alpha, @Nullable Integer lightmapCoordinate) {
        IconCoordinate texSide = getSideTexture(metadata);
        IconCoordinate texColumn = getColumnTexture(metadata);

        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        AABB bounds = AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

        for (int i1 = 0; i1 < 2; ++i1) {
            GL11.glPushMatrix();
            float f4 = 0.0625F;
            bounds.set(0.0F, 0.0F, 0.0F, 2.0F * f4, 1.0F, f4 * 2.0F);
            GL11.glTranslatef(0.5F - f4, 0.0F, 0.0F);
            if (i1 == 1) {
                GL11.glTranslatef(0.0F, 0.0F, 1.0F - f4 * 2.0F);
            }

            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);
            this.renderBottomFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            this.renderTopFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            this.renderNorthFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            this.renderSouthFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            this.renderWestFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            this.renderEastFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texColumn);
            tessellator.draw();
            GL11.glPopMatrix();
        }

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        GL11.glDisable(2884);
        bounds.set(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        this.renderEastFace(tessellator, bounds, 0.0F, 0.0F, 0.0F, texSide);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
}
