package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicStairsCopper extends BlockLogicStairs {

    public BlockLogicStairsCopper(Block<?> block, Block<?> modelBlock) {
        super(block, modelBlock);
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
