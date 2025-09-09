package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicAlgae;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;

public class BlockLogicDripleafBig extends BlockLogicAlgae implements IBonemealable {
	public BlockLogicDripleafBig(Block<?> block, Material material) {
		super(block, material);
		this.setBlockBounds(0.0, -0.125, 0.0, 1.0, 0.0062500000931322575, 1.0);
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return AABB.getPermanentBB(x + 0.0, y, z + 0.0, x + 1.0, y - 0.125, z + 1.0);
	}

}
