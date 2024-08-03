package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;

import java.util.Random;

public class BlockSaplingAzaleaFlowering extends BlockSaplingBase {

	public BlockSaplingAzaleaFlowering(String key, int id) {
		super(key, id);
	}

	public void growTree(World world, int x, int y, int z, Random random) {
		WorldFeature treeFeature;
		world.setBlock(x, y, z, 0);
		treeFeature = new WorldFeatureTreeFancy(CaveCliffBlocks.leavesAzaleaFlowering.id, CaveCliffBlocks.logAzalea.id, 0);
		if (!treeFeature.generate(world, random, x, y, z)) {
			world.setBlock(x, y, z, this.id);
		}

	}

}
