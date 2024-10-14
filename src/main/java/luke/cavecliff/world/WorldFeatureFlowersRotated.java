package luke.cavecliff.world;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.MethodParametersAnnotation;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureFlowersRotated
	extends WorldFeature {
	public final int plantBlockId;

	@MethodParametersAnnotation(names={"plantBlockId"})
	public WorldFeatureFlowersRotated(int plantBlockId) {
		this.plantBlockId = plantBlockId;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int l = 0; l < 64; ++l) {
			int k1;
			int j1;
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			if (!world.isAirBlock(i1, j1 = y + random.nextInt(4) - random.nextInt(4), k1 = z + random.nextInt(8) - random.nextInt(8)) || !Block.blocksList[this.plantBlockId].canBlockStay(world, i1, j1, k1)) continue;
			world.setBlockAndMetadata(i1, j1, k1, this.plantBlockId, random.nextInt(3));
		}
		return true;
	}
}
