package luke.cavecliff.blockmodel;

import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class BlockModelCaveVineGlowing<T extends Block> extends BlockModelCrossedSquares<T> {
	public final IconCoordinate[] growthStageTextures = new IconCoordinate[]{
		TextureRegistry.getTexture(MOD_ID + ":block/cave_vine_flowering"),
		TextureRegistry.getTexture(MOD_ID + ":block/cave_vine_short_flowering"),
	};

	public BlockModelCaveVineGlowing(Block block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.growthStageTextures[MathHelper.clamp(data, 0, 1)];
	}
}
