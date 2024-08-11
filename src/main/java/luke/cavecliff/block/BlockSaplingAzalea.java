package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;

import java.util.Random;

public class BlockSaplingAzalea extends BlockSaplingBase {

	public BlockSaplingAzalea(String key, int id) {
		super(key, id);
		this.setBlockBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	public void growTree(World world, int x, int y, int z, Random random) {
		WorldFeature treeFeature;
		world.setBlock(x, y, z, 0);
		world.setBlock(x, y - 1, z, CaveCliffBlocks.dirtRooted.id);
		treeFeature = new WorldFeatureTreeFancy(CaveCliffBlocks.leavesAzalea.id, CaveCliffBlocks.logAzalea.id, 0);
		if (!treeFeature.generate(world, random, x, y, z)) {
			world.setBlock(x, y, z, this.id);
		}

	}

}
