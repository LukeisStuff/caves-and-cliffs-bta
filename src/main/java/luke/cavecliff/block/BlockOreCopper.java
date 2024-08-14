package luke.cavecliff.block;

import luke.cavecliff.item.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockOreCopper extends Block {
	public BlockOreCopper(String key, int id) {
		super(key, id, Material.stone);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			case EXPLOSION:
			case PROPER_TOOL:
				return new ItemStack[]{new ItemStack(CaveCliffItems.oreRawCopper, 2 + world.rand.nextInt(4))};
			default:
				return null;
		}
	}
}
