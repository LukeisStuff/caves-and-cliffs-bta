package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.noise.ImprovedNoise;

import java.util.Random;

public class WorldFeaturePowderSnow extends WorldFeature {
	private static final ImprovedNoise noise = new ImprovedNoise(new Random(0L));

	public WorldFeaturePowderSnow() {
	}

	public boolean generate(World world, Random random, int x, int y, int z) {
		int chunkCoordX = world.getChunkFromBlockCoords(x, z).xPosition * 16;
		int chunkCoordZ = world.getChunkFromBlockCoords(x, z).zPosition * 16;

		for(int chunkX = chunkCoordX; chunkX < chunkCoordX + 16; ++chunkX) {
			for(int chunkZ = chunkCoordZ; chunkZ < chunkCoordZ + 16; ++chunkZ) {
				int yPos = world.getHeightValue(chunkX, chunkZ) - 1;
				float offset = (float)noise.getValue((double)chunkX / 30.0, (double)yPos / 30.0, (double)chunkZ / 30.0) * 0.75F;
				if (offset >= 0.125F) {
					for(int i = 0; i < 5; ++i) {
						if (world.getBlockId(chunkX, yPos - i, chunkZ) == Block.blockSnow.id || world.getBlockId(chunkX, yPos - i, chunkZ) == Block.blockSnow.id) {
							world.setBlockWithNotify(chunkX, yPos - i, chunkZ, CaveCliffBlocks.blockSnowPowder.id);
						}
					}
				}
			}
		}
		return true;
	}
}
