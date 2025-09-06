package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BlockLogicSlabCopper extends BlockLogicSlab {


	public BlockLogicSlabCopper(Block<?> block, Block<?> modelBlock) {
		super(block, modelBlock);
	}

	public void onBlockPlacedByMob(World world, int x, int y, int z, @NotNull Side side, Mob mob, double xPlaced, double yPlaced) {
		int meta = mob.getVerticalPlacementDirection(side, yPlaced) == Direction.UP ? 2 : 0;
		world.setBlockMetadataWithNotify(x, y, z, meta | world.getBlockMetadata(x, y, z) & 60);
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
				world.setBlockAndMetadataWithNotify(x, y, z, this.id(), meta + 16);
			}
		}
	}
}
