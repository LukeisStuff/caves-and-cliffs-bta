package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicFluid;
import net.minecraft.core.block.IPaintable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemFireStriker;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicCandleWax extends BlockLogic implements IPaintable {
    public boolean burning;

    public BlockLogicCandleWax(Block<?> block, Material material, boolean burning) {
        super(block, material);
        this.burning = burning;
        this.setBlockBounds(0.40625F, 0.0F, 0.40625F, 0.59375F, 0.5F, 0.59375F);
    }

    public void setColor(World world, int x, int y, int z, DyeColor color) {
        if (burning) {
            world.setBlock(x, y, z, CaveCliffBlocks.CANDLE_COLORED_LIT.id());
            ((BlockLogicCandleWaxColored) CaveCliffBlocks.CANDLE_COLORED_LIT.getLogic()).setColor(world, x, y, z, color);
        } else {
            world.setBlock(x, y, z, CaveCliffBlocks.CANDLE_COLORED.id());
            ((BlockLogicCandleWaxColored) CaveCliffBlocks.CANDLE_COLORED.getLogic()).setColor(world, x, y, z, color);
        }
    }

    public boolean isSolidRender() {
        return false;
    }

    public boolean isCubeShaped() {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.canPlaceOnSurfaceOfBlock(x, y - 1, z);
    }

    public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
        ItemStack heldItem = player.getHeldItem();
        if (heldItem != null && heldItem.getItem() instanceof ItemFireStriker && !this.burning) {
            Block<?> b;
            if (((b = world.getBlock(x + 1, y, z)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x - 1, y, z)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x, y, z + 1)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x, y, z - 1)) == null || !(b.getLogic() instanceof BlockLogicFluid))) {
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.CANDLE_LIT.id(), 0);
                heldItem.damageItem(1, player);
                world.playSoundEffect(null, SoundCategory.WORLD_SOUNDS, (double) x + 0.5, (double) y + 0.5, (double) z + 0.5, "fire.ignite", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                return true;
            } else {
                return false;
            }
        } else if (heldItem == null && this.burning) {
            world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.CANDLE.id(), 0);
            return true;
        } else {
            return false;
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
        if (!this.canBlockStay(world, x, y, z)) {
            this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null, null);
            world.setBlockWithNotify(x, y, z, 0);
        }

    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        return world.canPlaceOnSurfaceOfBlock(x, y - 1, z);
    }

    public void animationTick(World world, int x, int y, int z, Random rand) {
        if (burning) {
            double d = (double) x + 0.5;
            double d1 = (double) y + 0.7;
            double d2 = (double) z + 0.5;
            world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0, 0);
            world.spawnParticle("flame", d, d1, d2, 0.0, 0.0, 0.0, 0);
        }
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(CaveCliffBlocks.CANDLE)};
    }
}
