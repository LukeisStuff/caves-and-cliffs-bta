package luke.cavecliff.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelTrapDoor;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicTrapDoor;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;

@Environment(EnvType.CLIENT)
public class BlockModelTrapDoorCopper<T extends BlockLogic> extends BlockModelTrapDoor<T> {
    private static final IconCoordinate[][] TEXTURES = new IconCoordinate[4][2];

    public BlockModelTrapDoorCopper(Block<T> block) {
        super(block);
        float thickness = 0.1875F;
        this.withCustomItemBounds(0.0, 0.0, 0.0, 1.0, thickness, 1.0);
    }

    @Override
    public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
        int oxidation = (data >> 4) & 3;
        int orientation = data & 3;

        IconCoordinate topTex = TEXTURES[oxidation][0];
        IconCoordinate sideTex = TEXTURES[oxidation][1];

        if (BlockLogicTrapDoor.isTrapdoorOpen(data)) {
            int index = Sides.orientationLookUpTrapdoorOpen[6 * orientation + side.getId()];
            return index < 2 ? topTex : sideTex;
        } else {
            return side.getAxis() == Axis.Y ? topTex : sideTex;
        }
    }

    static {
        TEXTURES[0][0] = TextureRegistry.getTexture("cavecliff:block/trapdoor/top");
        TEXTURES[0][1] = TextureRegistry.getTexture("cavecliff:block/trapdoor/side");

        TEXTURES[1][0] = TextureRegistry.getTexture("cavecliff:block/trapdoor/top_exposed");
        TEXTURES[1][1] = TextureRegistry.getTexture("cavecliff:block/trapdoor/side_exposed");

        TEXTURES[2][0] = TextureRegistry.getTexture("cavecliff:block/trapdoor/top_weathered");
        TEXTURES[2][1] = TextureRegistry.getTexture("cavecliff:block/trapdoor/side_weathered");

        TEXTURES[3][0] = TextureRegistry.getTexture("cavecliff:block/trapdoor/top_oxidized");
        TEXTURES[3][1] = TextureRegistry.getTexture("cavecliff:block/trapdoor/side_oxidized");
    }
}
