package luke.cavecliff.blockmodel;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelStairs;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicStairs;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;

@Environment(EnvType.CLIENT)
public class BlockModelStairsCopper<T extends BlockLogicStairs> extends BlockModelStairs<T> {
	public BlockModelStairsCopper(Block<T> block) {
		super(block);
	}

	@Override
	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		int oxidationStage = meta >> 4;
		return BlockModelCopperBrick.oxidizeStageTextures[oxidationStage & 3];
	}

	@Override
	public IconCoordinate getBlockTexture(WorldSource blockAccess, int x, int y, int z, Side side) {
		return this.getBlockTextureFromSideAndMetadata(side, blockAccess.getBlockMetadata(x, y, z));
	}
}
