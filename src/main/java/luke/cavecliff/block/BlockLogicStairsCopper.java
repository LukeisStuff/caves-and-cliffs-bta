package luke.cavecliff.block;

import luke.cavecliff.model.ItemBlockStairsCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Objects;
import java.util.Random;

public class BlockLogicStairsCopper extends BlockLogicStairs {

    public BlockLogicStairsCopper(Block<?> block, Block<?> modelBlock) {
        super(block, modelBlock);
        block.setBlockItem(() -> new ItemBlockStairsCopper<>(block));
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);

        if (rand.nextInt(200) == 0 &&
            (world.getBlockMaterial(x, y, z - 1) == Material.water ||
            world.getBlockMaterial(x, y, z + 1) == Material.water ||
            world.getBlockMaterial(x - 1, y, z) == Material.water ||
            world.getBlockMaterial(x + 1, y, z) == Material.water ||
            world.getBlockMaterial(x, y + 1, z) == Material.water ||
            (world.canBlockBeRainedOn(x, y + 1, z) && Objects.requireNonNull(world.getCurrentWeather()).isPrecipitation))) {
            world.setBlockAndMetadataWithNotify(x, y, z, this.id(), meta + 16);
        }
    }
}
