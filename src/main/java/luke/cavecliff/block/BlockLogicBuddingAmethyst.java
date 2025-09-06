package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicBuddingAmethyst extends BlockLogic {


	public BlockLogicBuddingAmethyst(Block<?> block, Material material) {
		super(block, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case WORLD:
			case EXPLOSION:
			case SILK_TOUCH:
			case PROPER_TOOL: {
				return null;
			}
			case PICK_BLOCK: {
				return new ItemStack[]{new ItemStack(this)};
			}
		}
		return null;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(5) == 0) {
			Side facing = Side.getSideById(rand.nextInt(6));
			int adjX = x + facing.getOffsetX();
			int adjY = y + facing.getOffsetY();
			int adjZ = z + facing.getOffsetZ();
			if (world.isAirBlock(adjX, adjY, adjZ)) {
				int meta = BlockLogicAmethystCluster.getMetadataForFacing(facing);
				world.setBlockAndMetadataWithNotify(adjX, adjY, adjZ, CaveCliffBlocks.AMETHYST_CLUSTER_SMALL.id(), meta);
			}
		}
	}

}
