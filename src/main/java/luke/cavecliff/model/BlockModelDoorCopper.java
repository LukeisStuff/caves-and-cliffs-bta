package luke.cavecliff.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDoor;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicDoor;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelDoorCopper<T extends BlockLogicDoor> extends BlockModelDoor<T> {
    private static final IconCoordinate[][] VARIANT_TEXTURES = new IconCoordinate[4][3];

    private static final int TEX_FRAME_TOP = 0;
    private static final int TEX_BOTTOM = 1;
    private static final int TEX_TOP = 2;

    static {
        VARIANT_TEXTURES[0][TEX_FRAME_TOP] = TextureRegistry.getTexture("cavecliff:block/door/frame_top");
        VARIANT_TEXTURES[0][TEX_BOTTOM] = TextureRegistry.getTexture("cavecliff:block/door/bottom");
        VARIANT_TEXTURES[0][TEX_TOP] = TextureRegistry.getTexture("cavecliff:block/door/top");

        VARIANT_TEXTURES[1][TEX_FRAME_TOP] = TextureRegistry.getTexture("cavecliff:block/door/frame_top_exposed");
        VARIANT_TEXTURES[1][TEX_BOTTOM] = TextureRegistry.getTexture("cavecliff:block/door/bottom_exposed");
        VARIANT_TEXTURES[1][TEX_TOP] = TextureRegistry.getTexture("cavecliff:block/door/top_exposed");

        VARIANT_TEXTURES[2][TEX_FRAME_TOP] = TextureRegistry.getTexture("cavecliff:block/door/frame_top_weathered");
        VARIANT_TEXTURES[2][TEX_BOTTOM] = TextureRegistry.getTexture("cavecliff:block/door/bottom_weathered");
        VARIANT_TEXTURES[2][TEX_TOP] = TextureRegistry.getTexture("cavecliff:block/door/top_weathered");

        VARIANT_TEXTURES[3][TEX_FRAME_TOP] = TextureRegistry.getTexture("cavecliff:block/door/frame_top_oxidized");
        VARIANT_TEXTURES[3][TEX_BOTTOM] = TextureRegistry.getTexture("cavecliff:block/door/bottom_oxidized");
        VARIANT_TEXTURES[3][TEX_TOP] = TextureRegistry.getTexture("cavecliff:block/door/top_oxidized");
    }

    public BlockModelDoorCopper(Block<T> block) {
        super(block);
    }

    @Override
    public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
        int oxidation = (meta >> 4) & 3;

        if (side == Side.TOP || side == Side.BOTTOM) {
            return VARIANT_TEXTURES[oxidation][TEX_FRAME_TOP];
        }

        boolean isTopHalf = this.block.getLogic().isTop;

        if (isTopHalf) {
            return VARIANT_TEXTURES[oxidation][TEX_TOP];
        } else {
            return VARIANT_TEXTURES[oxidation][TEX_BOTTOM];
        }
    }

}
