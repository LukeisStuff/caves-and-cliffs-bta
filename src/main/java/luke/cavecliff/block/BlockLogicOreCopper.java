package luke.cavecliff.block;

import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;

public class BlockLogicOreCopper extends BlockLogic {
	public static WorldFeatureOre.OreMap variantMap = new WorldFeatureOre.OreMap();

	public BlockLogicOreCopper(Block<?> block, Block<?> parentBlock, Material material) {
		super(block, material);
		variantMap.put(parentBlock.id(), block.id());
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			case EXPLOSION:
			case PROPER_TOOL:
				return new ItemStack[]{new ItemStack(CaveCliffItems.ORE_RAW_COPPER, 2 + world.rand.nextInt(4))};
			default:
				return null;
		}
	}
}
