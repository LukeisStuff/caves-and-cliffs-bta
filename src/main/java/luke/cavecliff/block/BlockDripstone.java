package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockSand;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityFallingSand;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockDripstone extends BlockSand {

	public BlockDripstone(String key, int id, Material material) {
		super(key, id);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		this.tryToFall(world, x, y, z);
	}

	public void tryToFall(World world, int x, int y, int z) {
		boolean topCanFall = false;
		boolean bottomCanFall = false;
		int highest = -1;
		int lowest = -1;

		int i;
		for(i = y; i < 256; ++i) {
			if (canFallBelow(world, x, i + 1, z)) {
				topCanFall = true;
				highest = i;
				break;
			}

			if (world.getBlockId(x, i + 1, z) != this.id) {
				return;
			}
		}

		if (topCanFall) {
			for(i = y; i > 0; --i) {
				if (canFallBelow(world, x, i - 1, z)) {
					bottomCanFall = true;
					lowest = i;
					break;
				}

				if (world.getBlockId(x, i - 1, z) != this.id) {
					return;
				}
			}

			if (bottomCanFall) {
				for(i = lowest; i <= highest; ++i) {
					EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float)x + 0.5F, (float)i + 0.5F, (float)z + 0.5F, this.id);
					world.entityJoinedWorld(entityfallingsand);
				}
			}
		}
	}

	public static boolean canFallBelow(World world, int x, int y, int z) {
		int blockId = world.getBlockId(x, y, z);
		if (blockId == 0) {
			return true;
		} else if (blockId == Block.fire.id) {
			return true;
		} else {
			return Block.hasTag(blockId, BlockTags.IS_WATER) || Block.hasTag(blockId, BlockTags.IS_LAVA);
		}
	}

}
