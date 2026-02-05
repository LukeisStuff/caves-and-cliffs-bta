package luke.cavecliff.block;

import luke.cavecliff.item.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicDoor;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

public class BlockLogicDoorCopper extends BlockLogicDoor {

    public BlockLogicDoorCopper(Block<?> block, Material material, boolean isTop, boolean requireTool, @Nullable Supplier<Item> droppedItem) {
        super(block, material, isTop, requireTool, droppedItem);
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
                (world.canBlockBeRainedOn(x, y + 1, z)
                    && Objects.requireNonNull(world.getCurrentWeather()).isPrecipitation))) {

            int newMeta = meta + 16;

            if (isTop) {
                world.setBlockAndMetadataWithNotify(x, y - 1, z, CaveCliffBlocks.DOOR_COPPER_BOTTOM.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.DOOR_COPPER_TOP.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y - 1, z, CaveCliffBlocks.DOOR_COPPER_BOTTOM.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.DOOR_COPPER_TOP.id(), newMeta);
            } else {
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.DOOR_COPPER_BOTTOM.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y + 1, z, CaveCliffBlocks.DOOR_COPPER_TOP.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.DOOR_COPPER_BOTTOM.id(), newMeta);
                world.setBlockAndMetadataWithNotify(x, y + 1, z, CaveCliffBlocks.DOOR_COPPER_TOP.id(), newMeta);
            }
        }
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(CaveCliffItems.DOOR_COPPER, 1, (meta >> 4 & 15))};
    }
}
