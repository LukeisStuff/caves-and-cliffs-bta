package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSand;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityFallingBlock;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicDripstone extends BlockLogicSand {


	public BlockLogicDripstone(Block<?> block, Material material) {
		super(block);
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

			if (world.getBlockId(x, i + 1, z) != this.id()) {
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

				if (world.getBlockId(x, i - 1, z) != this.id()) {
					return;
				}
			}

			if (bottomCanFall) {
				for(i = lowest; i <= highest; ++i) {
					EntityFallingBlock entityfallingsand = new EntityFallingBlock(world);
					world.entityJoinedWorld(entityfallingsand);
				}
			}
		}
	}

}
