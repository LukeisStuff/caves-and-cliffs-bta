package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTrapDoor;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public class BlockLogicTrapDoorCopper extends BlockLogicTrapDoor {
    public static final int OXIDATION_MASK = 0x30;

    public BlockLogicTrapDoorCopper(Block<?> block, Material material) {
        super(block, material);
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

    @Override
    public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        int trapdoorMeta = super.getPlacedBlockMetadata(player, stack, world, x, y, z, side, xPlaced, yPlaced);

        int oxidation = stack.getMetadata() & OXIDATION_MASK;
        return trapdoorMeta | oxidation;
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
        int oxidation = meta & OXIDATION_MASK;
        return new ItemStack[]{new ItemStack(this.block, 1, oxidation)};
    }

}
