package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureDripleaf extends WorldFeature {
	public WorldFeatureDripleaf() {
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		for (int l = 0; l < 128; ++l) {
			int i1 = x + random.nextInt(8) - random.nextInt(8);
			int k1 = z + random.nextInt(8) - random.nextInt(8);
			if (world.getBlockId(i1, y, k1) == Blocks.FLUID_WATER_STILL.id() && world.getBlockMaterial(i1, y + 1, k1) == Material.air) {
				world.setBlock(i1, y + 1, k1, CaveCliffBlocks.DRIPLEAF_BIG.id());
			}
		}

		return true;
	}
}
