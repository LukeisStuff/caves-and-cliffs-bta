package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSand;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityFallingBlock;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicDripstone extends BlockLogicSand {
	public static boolean fallInstantly = false;

	public BlockLogicDripstone(Block<?> block, Material material) {
		super(block);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		this.tryToFall(world, x, y, z);
	}

	public void tryToFall(World world, int x, int y, int z) {
		if (canFallBelow(world, x, y - 1, z) && y >= 0 && world.getBlock(x, y + 1, z) == CaveCliffBlocks.DRIPSTONE || world.getBlock(x, y + 1, z) == null) {
			byte byte0 = 32;
			if (!fallInstantly && world.areBlocksLoaded(x - byte0, y - byte0, z - byte0, x + byte0, y + byte0, z + byte0)) {
				EntityFallingBlock entityFallingBlock = new EntityFallingBlock(world, (double) x + 0.5, (double) y + 0.5, (double) z + 0.5, this.block.id(), 0, null);
				world.entityJoinedWorld(entityFallingBlock);
			} else {
				world.setBlockWithNotify(x, y, z, 0);

				while (canFallBelow(world, x, y - 1, z) && y > 0) {
					--y;
				}

				if (y > 0) {
					world.setBlockWithNotify(x, y, z, this.block.id());
				}
			}
		}

	}

	public static boolean canFallBelow(World world, int x, int y, int z) {
		Block<?> block = world.getBlock(x, y, z);
		return block == null || block.hasTag(BlockTags.PLACE_OVERWRITES);
	}
}
