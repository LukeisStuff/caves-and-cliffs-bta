package luke.cavecliff.block;

import luke.cavecliff.CaveCliffMod;
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

public class BlockLogicLightningRod extends BlockLogic {

    public BlockLogicLightningRod(Block<?> block) {
        super(block, CaveCliffMod.copper);
        this.setBlockBounds(0.3125f, 0.0f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
    }

    @Override
    public boolean isSolidRender() {
        return false;
    }

    @Override
    public boolean isCubeShaped() {
        return false;
    }

    @Override
    public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return stack.getMetadata();
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        int meta = world.getBlockMetadata(x, y, z);

        if (rand.nextInt(200) == 0 && (world.getBlockMaterial(x, y, z - 1) == Material.water ||
            world.getBlockMaterial(x, y, z + 1) == Material.water ||
            world.getBlockMaterial(x - 1, y, z) == Material.water ||
            world.getBlockMaterial(x + 1, y, z) == Material.water ||
            world.getBlockMaterial(x, y + 1, z) == Material.water ||
            (world.canBlockBeRainedOn(x, y + 1, z) && world.getCurrentWeather().isPrecipitation))) {
            world.setBlockAndMetadataWithNotify(x, y, z, this.id(), meta + 1);
        }
    }

}
