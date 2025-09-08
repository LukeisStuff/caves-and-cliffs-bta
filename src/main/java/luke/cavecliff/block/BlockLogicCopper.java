package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlockLogicCopper extends BlockLogic {
	public static final String[] oxidizeStages = new String[]{"oxidized", "weathered", "exposed", "clean"};

	public BlockLogicCopper(Block<?> block) {
		super(block, Material.metal);
	}

	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata() & 3;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this, 1, meta)};
	}

	public static int getMetadataForOxidation(int blockMeta) {
		return ~blockMeta & 3;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);

		if (rand.nextInt(200) == 0) {
			if (world.getBlockMaterial(x, y, z - 1) == Material.water ||
				world.getBlockMaterial(x, y, z + 1) == Material.water ||
				world.getBlockMaterial(x - 1, y, z) == Material.water ||
				world.getBlockMaterial(x + 1, y, z) == Material.water ||
				world.getBlockMaterial(x, y + 1, z) == Material.water ||
				(world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation)) {
				world.setBlockAndMetadataWithNotify(x, y, z, this.id(), meta + 1);
			}
		}
	}

}
