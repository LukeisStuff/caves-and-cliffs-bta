package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureAlgae;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldGenTreeShapeSwamp extends WorldFeature {
	protected int leavesID;
	protected int logID;
	protected int heightMod;
	protected Random treeRand = new Random();

	public WorldGenTreeShapeSwamp(int leavesID, int logID, int heightMod) {
		this.leavesID = leavesID;
		this.logID = logID;
		this.heightMod = heightMod;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		int trunkLength = random.nextInt(4) + this.heightMod;
		boolean flag = true;
		if (y < 1 || y + trunkLength + 1 > world.getHeightBlocks()) {
			return false;
		}
		for (int i1 = y; i1 <= y + 1 + trunkLength; ++i1) {
			int byte0 = 1;
			if (i1 == y) {
				byte0 = 0;
			}
			if (i1 >= y + 1 + trunkLength - 2) {
				byte0 = 2;
			}
			for (int i2 = x - byte0; i2 <= x + byte0 && flag; ++i2) {
				for (int l2 = z - byte0; l2 <= z + byte0 && flag; ++l2) {
					if (i1 >= 0 && i1 < world.getHeightBlocks()) {
						int j3 = world.getBlockId(i2, i1, l2);
						if (j3 == 0 || j3 == this.leavesID) continue;
						flag = false;
						continue;
					}
					flag = false;
				}
			}
		}
		if (!flag) {
			return false;
		}
		int sinkToFloor = 0;
		while (world.getBlockId(x, y - sinkToFloor - 1, z) == Block.fluidWaterStill.id) {
			if (sinkToFloor > 3) {
				return false;
			}
			++sinkToFloor;
		}
		int oldY = y;
		int idBelow = world.getBlockId(x, (y -= sinkToFloor) - 1, z);
		if (!Block.hasTag(idBelow, BlockTags.GROWS_TREES) || y >= world.getHeightBlocks() - trunkLength + sinkToFloor - 1) {
			return false;
		}
		WorldFeatureTree.onTreeGrown(world, x, y, z);
		world.setBlockWithNotify(x, y - 1, z, Block.dirt.id);
		for (int k1 = y - 3 + trunkLength + sinkToFloor; k1 <= y + trunkLength + sinkToFloor; ++k1) {
			int j2 = k1 - (y + trunkLength + sinkToFloor);
			int i3 = 2 - j2 / 2;
			for (int k3 = x - i3; k3 <= x + i3; ++k3) {
				int l3 = k3 - x;
				for (int i4 = z - i3; i4 <= z + i3; ++i4) {
					int j4 = i4 - z;
					if (Math.abs(l3) == i3 && Math.abs(j4) == i3 && (random.nextInt(2) == 0 || j2 == 0) || Block.solid[world.getBlockId(k3, k1, i4)]) continue;
					world.setBlockWithNotify(k3, k1, i4, this.leavesID);
					if (this.treeRand.nextInt(5) != 0) continue;
					int vineLength = this.treeRand.nextInt(5);
					for (int q = 0; q < vineLength; ++q) {
						if (world.getBlockId(k3, k1 - q, i4) != 0) continue;
						world.setBlock(k3, k1 - q, i4, CaveCliffBlocks.vines.id);
					}
				}
			}
		}
		for (int l1 = 0; l1 < trunkLength + sinkToFloor; ++l1) {
			int k2 = world.getBlockId(x, y + l1, z);
			if (k2 != 0 && k2 != this.leavesID && k2 != Block.fluidWaterStill.id && k2 != Block.fluidWaterFlowing.id) continue;
			world.setBlockWithNotify(x, y + l1, z, this.logID);
		}
		new WorldFeatureAlgae().generate(world, this.treeRand, x, oldY - 1, z);
		return true;
	}
}
