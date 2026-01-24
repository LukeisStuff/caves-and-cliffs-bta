package luke.cavecliff.model;

import luke.cavecliff.block.BlockLogicVines;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelVinesGlowing<T extends BlockLogicVines> extends BlockModelCrossedSquares<T> {
    public static final IconCoordinate[] vineTextures = new IconCoordinate[2];

    public BlockModelVinesGlowing(Block<T> block) {
        super(block);
    }

    @Override
    public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
        return vineTextures[data & 1];
    }

    static {
        vineTextures[0] = TextureRegistry.getTexture("cavecliff:block/cave_vine_flowering");
        vineTextures[1] = TextureRegistry.getTexture("cavecliff:block/cave_vine_short_flowering");
    }
}
