package luke.cavecliff.block;

import luke.cavecliff.model.ItemBlockSlabCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public class BlockLogicSlabCopper extends BlockLogicSlab {

    public BlockLogicSlabCopper(Block<?> block, Block<?> modelBlock) {
        super(block, modelBlock);
        block.setBlockItem(() -> new ItemBlockSlabCopper<>(block));
    }

    @Override
    public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return stack.getMetadata();
    }

    @Override
    public void onBlockPlacedByMob(World world, int x, int y, int z, @NotNull Side side, Mob mob, double xPlaced, double yPlaced) {
        int meta = mob.getVerticalPlacementDirection(side, yPlaced) == Direction.UP ? 2 : 0;
        world.setBlockMetadataWithNotify(x, y, z, meta | world.getBlockMetadata(x, y, z) & 60);
    }

    @Override
    public void onBlockPlacedOnSide(World world, int x, int y, int z, @NotNull Side side, double xPlaced, double yPlaced) {
        int meta = side == Side.TOP ? 2 : 0;
        world.setBlockMetadataWithNotify(x, y, z, meta | world.getBlockMetadata(x, y, z) & 60);
    }

    @Override
    public String getLanguageKey(int meta) {
        return super.getLanguageKey(meta) + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((meta & 60) >> 4)];
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
