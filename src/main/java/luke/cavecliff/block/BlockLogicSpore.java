package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLogicSpore extends BlockLogic {


	public BlockLogicSpore(Block<?> block) {
		super(block, Material.grass);
		this.setBlockBounds(0.0625f, 0.75f, 0.0625f, 0.9375f, 1.0f, 0.9375f);

	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return canPlaceBlockAt(world, x, y, z);
	}

}
