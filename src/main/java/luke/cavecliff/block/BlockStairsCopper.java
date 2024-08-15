package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockStairsCopper extends BlockStairs {

	public BlockStairsCopper(Block block, int id) {
		super(block, id);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		if (world.getBlockMetadata(x, y, z) == 0) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 1) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 2) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 3) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 8) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 9) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 10) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 11) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}


		if (world.getBlockMetadata(x, y, z) == 16) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 17) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 18) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 19) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 24) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 25) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 26) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 27) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}


		if (world.getBlockMetadata(x, y, z) == 32) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 33) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 34) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 35) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 40) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 41) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 42) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 43) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}


		if (world.getBlockMetadata(x, y, z) == 32) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 48) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 49) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 50) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 51) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 57) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 58) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
		if (world.getBlockMetadata(x, y, z) == 59) {
			if (rand.nextInt(200) == 0) {
				if (world.getBlockMaterial(x, y, z - 1) == Material.water || world.getBlockMaterial(x, y, z + 1) == Material.water || world.getBlockMaterial(x - 1, y, z) == Material.water || world.getBlockMaterial(x + 1, y, z) == Material.water || world.getBlockMaterial(x, y + 1, z) == Material.water || (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, meta + 16);
				}
			}
		}
	}

}
