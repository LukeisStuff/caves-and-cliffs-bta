package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicMoss;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockLogicMossy extends BlockLogicMoss {

	public BlockLogicMossy(Block<?> block, Block<?> parentBlock, Material material) {
		super(block, parentBlock);
	}

	@Override
	public boolean onBonemealUsed(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			if (player == null || player.getGamemode().consumeBlocks()) {
				--itemstack.stackSize;
			}

			for (int j1 = 0; j1 < 32; ++j1) {
				int k1 = blockX;
				int l1 = blockY;
				int i2 = blockZ;

				int blockId;
				for (blockId = 0; blockId < j1 / 16; ++blockId) {
					k1 += world.rand.nextInt(3) - 1;
					l1 += (world.rand.nextInt(3) - 1) * world.rand.nextInt(3) / 2;
					i2 += world.rand.nextInt(3) - 1;
				}

				if (!Block.isBuried(world, k1, l1, i2) && world.getBlockLightValue(k1, l1 + 1, i2) <= 5 && world.getBlockLightValue(k1, l1 - 1, i2) <= 5 && world.getBlockLightValue(k1 + 1, l1, i2) <= 5 && world.getBlockLightValue(k1 - 1, l1, i2) <= 5 && world.getBlockLightValue(k1, l1, i2 - 1) <= 5 && world.getBlockLightValue(k1, l1, i2 + 1) <= 5) {
					blockId = world.getBlockId(k1, l1, i2);
					if (blockId == Blocks.STONE.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.MOSS_STONE.id());
					} else if (blockId == Blocks.MOSS_STONE.id()) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.BLOCK_MOSS.id());
					} else if (blockId == Blocks.MOSS_BASALT.id()) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.BLOCK_MOSS.id());
					} else if (blockId == Blocks.MOSS_LIMESTONE.id()) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.BLOCK_MOSS.id());
					} else if (blockId == Blocks.MOSS_GRANITE.id()) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.BLOCK_MOSS.id());
					} else if (blockId == Blocks.COBBLE_STONE_MOSSY.id()) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.BLOCK_MOSS.id());
					} else if (blockId == Blocks.LIMESTONE.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.MOSS_LIMESTONE.id());
					} else if (blockId == Blocks.GRANITE.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.MOSS_GRANITE.id());
					} else if (blockId == Blocks.BASALT.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.MOSS_BASALT.id());
					} else if (blockId == Blocks.COBBLE_STONE.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.COBBLE_STONE_MOSSY.id());
					} else if (blockId == Blocks.BRICK_STONE_POLISHED.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.BRICK_STONE_POLISHED_MOSSY.id());
					} else if (blockId == Blocks.LOG_OAK.id()) {
						world.setBlockWithNotify(k1, l1, i2, Blocks.LOG_OAK_MOSSY.id());
					}
				}
			}
		}

		return true;
	}

}

