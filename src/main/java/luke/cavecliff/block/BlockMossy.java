package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockMoss;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockMossy extends BlockMoss {
	public BlockMossy(String key, int id) {
		super(key, id);
	}
@Override
	public boolean onBonemealUsed(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			if (entityplayer.getGamemode().consumeBlocks()) {
				--itemstack.stackSize;
			}

			for(int j1 = 0; j1 < 64; ++j1) {
				int k1 = blockX;
				int l1 = blockY;
				int i2 = blockZ;

				for(int j2 = 0; j2 < j1 / 32; ++j2) {
					k1 += world.rand.nextInt(5) - 1;
					l1 += world.rand.nextInt(5) - 1;
					i2 += world.rand.nextInt(5) - 1;
				}

				if (world.getBlockLightValue(k1, l1 + 1, i2) <= 5 && world.getBlockLightValue(k1, l1 - 1, i2) <= 5 && world.getBlockLightValue(k1 + 1, l1, i2) <= 5 && world.getBlockLightValue(k1 - 1, l1, i2) <= 5 && world.getBlockLightValue(k1, l1, i2 - 1) <= 5 && world.getBlockLightValue(k1, l1, i2 + 1) <= 5) {
					if (world.getBlockId(k1, l1, i2) == Block.stone.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.mossStone.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.limestone.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.mossLimestone.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.granite.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.mossGranite.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.basalt.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.mossBasalt.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.cobbleStone.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.cobbleStoneMossy.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.brickStonePolished.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.brickStonePolishedMossy.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.logOak.id) {
						world.setBlockWithNotify(k1, l1, i2, Block.logOakMossy.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.mossStone.id) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.moss.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.mossLimestone.id) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.moss.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.mossGranite.id) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.moss.id);
					} else if (world.getBlockId(k1, l1, i2) == Block.mossBasalt.id) {
						world.setBlockWithNotify(k1, l1, i2, CaveCliffBlocks.moss.id);
					}
				}
			}
		}

		return true;
	}

}

