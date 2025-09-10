package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;

public class BlockLogicLightningRod extends BlockLogic {

	public BlockLogicLightningRod(Block<?> block) {
		super(block, Material.metal);
		this.setBlockBounds(0.3125f, 0.0f, 0.3125f, 0.6875f, 1.0f, 0.6875f);

	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}

}
