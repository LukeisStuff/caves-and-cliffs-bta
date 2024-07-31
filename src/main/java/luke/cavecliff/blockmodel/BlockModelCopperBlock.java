package luke.cavecliff.blockmodel;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class BlockModelCopperBlock<T extends Block> extends BlockModelStandard<T> { ItemBlockPainted
	public final IconCoordinate[] oxidizeStageTextures = new IconCoordinate[]{
		TextureRegistry.getTexture(MOD_ID + ":block/block_copper"),
		TextureRegistry.getTexture(MOD_ID + ":block/block_copper_exposed"),
		TextureRegistry.getTexture(MOD_ID + ":block/block_copper_weathered"),
		TextureRegistry.getTexture(MOD_ID + ":block/block_copper_oxidized"),
	};

	public BlockModelCopperBlock(Block block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.oxidizeStageTextures[MathHelper.clamp(data, 0, 3)];
	}
}
