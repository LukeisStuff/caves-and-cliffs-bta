package luke.cavecliff.blockmodel;

import net.minecraft.client.render.block.model.BlockModelStairs;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;

public class BlockModelStairsCopper<T extends BlockStairs> extends BlockModelStairs<T> {
	public BlockModelStairsCopper(Block block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int meta) {
		meta >>= 4;
		return BlockModelCopperBrick.oxidizeStageTextures[meta & 3];
	}

	public IconCoordinate getBlockTexture(WorldSource blockAccess, int x, int y, int z, Side side) {
		return this.getBlockTextureFromSideAndMetadata(side, blockAccess.getBlockMetadata(x, y, z));
	}
}
