package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockBuddingAmethyst extends Block {

	public BlockBuddingAmethyst(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case WORLD:
			case EXPLOSION:
			case SILK_TOUCH:
			case PROPER_TOOL: {
				return null;
			}
			case PICK_BLOCK: {
				return new ItemStack[]{new ItemStack(this)};
			}
		}
		return null;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if ((world.getBlockId(x, y + 1, z)) == 0) {
			if (rand.nextInt(5) == 0) {
				world.setBlockAndMetadataWithNotify(x, y + 1, z, CaveCliffBlocks.amethystCluster.id, 0);
			}
		}
	}

}
