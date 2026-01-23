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

@Environment(EnvType.CLIENT)
public class BlockModelLightningRod<T extends BlockLogic> extends BlockModelStandard<T> {
    public BlockModelLightningRod(Block<T> block) {
        super(block);
    }

    @Override
    public boolean render(Tessellator tessellator, int x, int y, int z) {
        float brightness = 1.0F;
        if (LightmapHelper.isLightmapEnabled()) {
            tessellator.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
        } else {
            brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
            if (this.block.emission > 0) {
                brightness = 1.0F;
            }
        }

        tessellator.setColorOpaque_F(brightness, brightness, brightness);
        renderLightningRod(tessellator, x, y, z);

        return true;
    }

    private void renderLightningRod(Tessellator tessellator, double x, double y, double z) {
        IconCoordinate texture = this.getBlockTextureFromSideAndMetadata(Side.TOP, 0);
        if (renderBlocks.overrideBlockTexture != null) {
            texture = renderBlocks.overrideBlockTexture;
        }

        double rodMinU = texture.getSubIconU(0.4375);
        double rodMaxU = texture.getSubIconU(0.5625);
        double rodMinV = texture.getSubIconV(0.3125);
        double rodMaxV = texture.getSubIconV(1.0);

        double rodTopBottomMinV = texture.getSubIconV(0.3125);
        double rodTopBottomMaxV = texture.getSubIconV(0.4375);

        double cubeMinU = texture.getSubIconU(0.375);
        double cubeMaxU = texture.getSubIconU(0.625);
        double cubeMinV = texture.getSubIconV(0.0);
        double cubeMaxV = texture.getSubIconV(0.25);

        x += 0.5;
        z += 0.5;
        double rodWidth = 0.0625;
        double cubeWidth = 0.125;

        // Rod
        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z - rodWidth, rodMinU, rodMinV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z - rodWidth, rodMinU, rodMaxV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z + rodWidth, rodMaxU, rodMaxV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z + rodWidth, rodMaxU, rodMinV);

        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z + rodWidth, rodMinU, rodMinV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z + rodWidth, rodMinU, rodMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z - rodWidth, rodMaxU, rodMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z - rodWidth, rodMaxU, rodMinV);

        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z - rodWidth, rodMinU, rodMinV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z - rodWidth, rodMinU, rodMaxV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z - rodWidth, rodMaxU, rodMaxV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z - rodWidth, rodMaxU, rodMinV);

        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z + rodWidth, rodMinU, rodMinV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z + rodWidth, rodMinU, rodMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z + rodWidth, rodMaxU, rodMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z + rodWidth, rodMaxU, rodMinV);

        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z + rodWidth, rodMinU, rodTopBottomMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z + rodWidth, rodMaxU, rodTopBottomMaxV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.75, z - rodWidth, rodMaxU, rodTopBottomMinV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.75, z - rodWidth, rodMinU, rodTopBottomMinV);

        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z - rodWidth, rodMinU, rodTopBottomMinV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z - rodWidth, rodMaxU, rodTopBottomMinV);
        tessellator.addVertexWithUV(x + rodWidth, y + 0.0, z + rodWidth, rodMaxU, rodTopBottomMaxV);
        tessellator.addVertexWithUV(x - rodWidth, y + 0.0, z + rodWidth, rodMinU, rodTopBottomMaxV);

        // Top Cube
        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z - cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z - cubeWidth, cubeMinU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z - cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z - cubeWidth, cubeMaxU, cubeMinV);

        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z + cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z + cubeWidth, cubeMinU, cubeMaxV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z + cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z + cubeWidth, cubeMaxU, cubeMinV);

        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z + cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z + cubeWidth, cubeMinU, cubeMaxV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z - cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z - cubeWidth, cubeMaxU, cubeMinV);

        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z - cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z - cubeWidth, cubeMinU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z + cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z + cubeWidth, cubeMaxU, cubeMinV);

        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z + cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z + cubeWidth, cubeMaxU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 1.0, z - cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 1.0, z - cubeWidth, cubeMinU, cubeMaxV);

        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z - cubeWidth, cubeMinU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z - cubeWidth, cubeMaxU, cubeMinV);
        tessellator.addVertexWithUV(x + cubeWidth, y + 0.75, z + cubeWidth, cubeMaxU, cubeMaxV);
        tessellator.addVertexWithUV(x - cubeWidth, y + 0.75, z + cubeWidth, cubeMinU, cubeMaxV);
    }

    @Override
    public boolean shouldItemRender3d() {
        return false;
    }

    @Override
    public float getItemRenderScale() {
        return 0.5F;
    }
}
