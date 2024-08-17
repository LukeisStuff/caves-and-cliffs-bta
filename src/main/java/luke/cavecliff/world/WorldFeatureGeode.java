package luke.cavecliff.world;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureGeode extends WorldFeature {

	public WorldFeatureGeode() {
	}

	public boolean generate(World world, Random random, int x, int y, int z) {
		int number = random.nextInt(2) + 1;
		int rand = number * 2 + 2;
		if (world.getBlockId(x, y - 9, z) == 0) {
			return false;
		} else {
			makeSphere(Block.basalt.id, rand + 2, true, world, x, y, z);
			makeSphere(Block.marble.id, rand + 1, true, world, x, y, z);
			makeSphereRandom(CaveCliffBlocks.amethyst.id, CaveCliffBlocks.amethystBudding.id, rand, true, random, world, x, y, z);
			makeSphere(0, rand - 1, true, world, x, y, z);
			return true;
		}
	}

	public int lengthSq(int x, int y, int z) {
		return (x * x + y * y + z * z);
	}

	/*
	 * pos is a Vector containing the x,y,z of the center block of the sphere
	 * block is the block to make the sphere out of radius is the radius of the
	 * sphere filled is whether the sphere is solid or hollow
	 */


	public void makeSphere(int block, double radius, boolean filled, World world, int X, int Y, int Z) {

		radius += 0.5D; // I think they do this so the radius is measured from
		// the center of the block
		double radiusSq = radius * radius; // Square of the radius, so we don't
		// need to use square roots for
		// distance calcs
		double radius1Sq = (radius - 1.0D) * (radius - 1.0D); // Square of the
		// radius of a
		// circle 1
		// block
		// smaller, for
		// making a
		// hollow sphere

		int ceilRadius = (int) Math.ceil(radius); // Round the radius up
		// Loop through x,y,z up to the rounded radius
		for (int x = 0; x <= ceilRadius; x++) {
			for (int y = 0; y <= ceilRadius; y++) {
				for (int z = 0; z <= ceilRadius; z++) {
					double dSq = lengthSq(x, y, z); // Gets the square of the
					// distance from the center
					// (x*x + y*y + z*z). Again
					// using squares, so we don't
					// need to square root

					// If the distance to this point is greater than the radius,
					// skip it (this is what makes this whole thing make a
					// sphere, instead of a cube)
					if (dSq > radiusSq) {
						continue;
					}
					// If sphere should be hollow, and the point is within the
					// sphere, but also within the 1-smaller sphere, skip it
					if ((!filled) && ((dSq < radius1Sq) || ((lengthSq(x + 1, y, z) <= radiusSq)
						&& (lengthSq(x, y + 1, z) <= radiusSq) && (lengthSq(x, y, z + 1) <= radiusSq)))) {
						continue;
					}

					// Place the block in every +/- direction around the center
					if (world.getBlockId(x + X, y + Y, z + Z) != 0) {
						world.setBlockWithNotify(x + X, y + Y, z + Z, block);
					}
					if (world.getBlockId(-x + X, y + Y, z + Z) != 0) {
						world.setBlockWithNotify(-x + X, y + Y, z + Z, block);
					}
					if (world.getBlockId(x + X, -y + Y, z + Z) != 0) {
						world.setBlockWithNotify(x + X, -y + Y, z + Z, block);
					}
					if (world.getBlockId(x + X, y + Y, -z + Z) != 0) {
						world.setBlockWithNotify(x + X, y + Y, -z + Z, block);
					}
					if (world.getBlockId(-x + X, -y + Y, z + Z) != 0) {
						world.setBlockWithNotify(-x + X, -y + Y, z + Z, block);
					}
					if (world.getBlockId(x + X, -y + Y, -z + Z) != 0) {
						world.setBlockWithNotify(x + X, -y + Y, -z + Z, block);
					}
					if (world.getBlockId(-x + X, y + Y, -z + Z) != 0) {
						world.setBlockWithNotify(-x + X, y + Y, -z + Z, block);
					}
					if (world.getBlockId(-x + X, -y + Y, -z + Z) != 0) {
						world.setBlockWithNotify(-x + X, -y + Y, -z + Z, block);
					}
				}
			}
		}
	}

	public void makeSphereRandom(int block, int block2, double radius, boolean filled, Random random, World world, int X, int Y, int Z) {

		radius += 0.5D; // I think they do this so the radius is measured from
		// the center of the block
		double radiusSq = radius * radius; // Square of the radius, so we don't
		// need to use square roots for
		// distance calcs
		double radius1Sq = (radius - 1.0D) * (radius - 1.0D); // Square of the
		// radius of a
		// circle 1
		// block
		// smaller, for
		// making a
		// hollow sphere

		int ceilRadius = (int) Math.ceil(radius); // Round the radius up
		// Loop through x,y,z up to the rounded radius
		for (int x = 0; x <= ceilRadius; x++) {
			for (int y = 0; y <= ceilRadius; y++) {
				for (int z = 0; z <= ceilRadius; z++) {
					double dSq = lengthSq(x, y, z); // Gets the square of the
					// distance from the center
					// (x*x + y*y + z*z). Again
					// using squares, so we don't
					// need to square root

					// If the distance to this point is greater than the radius,
					// skip it (this is what makes this whole thing make a
					// sphere, instead of a cube)
					if (dSq > radiusSq) {
						continue;
					}
					// If sphere should be hollow, and the point is within the
					// sphere, but also within the 1-smaller sphere, skip it
					if ((!filled) && ((dSq < radius1Sq) || ((lengthSq(x + 1, y, z) <= radiusSq)
						&& (lengthSq(x, y + 1, z) <= radiusSq) && (lengthSq(x, y, z + 1) <= radiusSq)))) {
						continue;
					}

					// Place the block in every +/- direction around the center
					if (world.getBlockId(x + X, y + Y, z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(x + X, y + Y, z + Z, block);
						} else {
							world.setBlockWithNotify(x + X, y + Y, z + Z, block2);
						}
					}
					if (world.getBlockId(-x + X, y + Y, z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(-x + X, y + Y, z + Z, block);
						} else {
							world.setBlockWithNotify(-x + X, y + Y, z + Z, block2);
						}
					}
					if (world.getBlockId(x + X, -y + Y, z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(x + X, -y + Y, z + Z, block);
						} else {
							world.setBlockWithNotify(x + X, -y + Y, z + Z, block2);
						}
					}
					if (world.getBlockId(x + X, y + Y, -z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(x + X, y + Y, -z + Z, block);
						} else {
							world.setBlockWithNotify(x + X, y + Y, -z + Z, block2);
						}
					}
					if (world.getBlockId(-x + X, -y + Y, z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(-x + X, -y + Y, z + Z, block);
						} else {
							world.setBlockWithNotify(-x + X, -y + Y, z + Z, block2);
						}
					}
					if (world.getBlockId(x + X, -y + Y, -z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(x + X, -y + Y, -z + Z, block);
						} else {
							world.setBlockWithNotify(x + X, -y + Y, -z + Z, block2);
						}
					}
					if (world.getBlockId(-x + X, y + Y, -z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(-x + X, y + Y, -z + Z, block);
						} else {
							world.setBlockWithNotify(-x + X, y + Y, -z + Z, block2);
						}
					}
					if (world.getBlockId(-x + X, -y + Y, -z + Z) != 0) {
						if (random.nextInt(4) > 0) {
							world.setBlockWithNotify(-x + X, -y + Y, -z + Z, block);
						} else {
							world.setBlockWithNotify(-x + X, -y + Y, -z + Z, block2);
						}
					}
				}
			}
		}
	}

}
