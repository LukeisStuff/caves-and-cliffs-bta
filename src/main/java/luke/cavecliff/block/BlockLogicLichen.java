package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLadder;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

public class BlockLogicLichen extends BlockLogicLadder {

	public BlockLogicLichen(Block<?> block, Material material) {
		super(block);
	}

	@Override
	public boolean isClimbable(World world, int x, int y, int z) {
		return false;
	}
}
