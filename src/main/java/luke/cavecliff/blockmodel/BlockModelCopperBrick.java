package luke.cavecliff.blockmodel;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelCopperBrick<T extends BlockLogic> extends BlockModelStandard<T> {
	public static final IconCoordinate[] oxidizeStageTextures = new IconCoordinate[4];

	public BlockModelCopperBrick(Block<T> block) {
		super(block);
	}


	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return oxidizeStageTextures[data & 3];
	}

	static {
		oxidizeStageTextures[0] = TextureRegistry.getTexture("cavecliff:block/brick_copper");
		oxidizeStageTextures[1] = TextureRegistry.getTexture("cavecliff:block/brick_copper_exposed");
		oxidizeStageTextures[2] = TextureRegistry.getTexture("cavecliff:block/brick_copper_weathered");
		oxidizeStageTextures[3] = TextureRegistry.getTexture("cavecliff:block/brick_copper_oxidized");
	}
}
