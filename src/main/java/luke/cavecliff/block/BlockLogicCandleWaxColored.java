package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFluid;
import net.minecraft.core.block.IPainted;
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
import org.jetbrains.annotations.Nullable;

public class BlockLogicCandleWaxColored extends BlockLogicCandleWax implements IPainted {
    public boolean burning;

    public BlockLogicCandleWaxColored(Block<?> block, Material material, boolean burning) {
        super(block, material, burning);
        this.burning = burning;
        this.setBlockBounds(0.40625F, 0.0F, 0.40625F, 0.59375F, 0.5F, 0.59375F);
    }

    public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return stack.getMetadata();
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(this, 1, meta)};
    }

    public DyeColor fromMetadata(int meta) {
        return DyeColor.colorFromBlockMeta(meta & 15);
    }

    public int toMetadata(DyeColor color) {
        return color.blockMeta;
    }

    public int stripColorFromMetadata(int meta) {
        return 0;
    }

    public void removeDye(World world, int x, int y, int z) {
        if (burning) {
            world.setBlockWithNotify(x, y, z, CaveCliffBlocks.CANDLE_LIT.id());
        } else {
            world.setBlockWithNotify(x, y, z, CaveCliffBlocks.CANDLE.id());
        }
    }

    @Override
    public void setColor(World world, int x, int y, int z, DyeColor color) {
        IPainted.super.setColor(world, x, y, z, color);
    }

    public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
        ItemStack heldItem = player.getHeldItem();
        int meta = world.getBlockMetadata(x, y, z);

        if (heldItem != null && heldItem.getItem() instanceof ItemFireStriker && !this.burning) {
            Block<?> b;
            if (((b = world.getBlock(x + 1, y, z)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x - 1, y, z)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x, y, z + 1)) == null || !(b.getLogic() instanceof BlockLogicFluid)) && ((b = world.getBlock(x, y, z - 1)) == null || !(b.getLogic() instanceof BlockLogicFluid))) {
                world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.CANDLE_COLORED_LIT.id(), meta);
                heldItem.damageItem(1, player);
                world.playSoundEffect(null, SoundCategory.WORLD_SOUNDS, (double) x + 0.5, (double) y + 0.5, (double) z + 0.5, "fire.ignite", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
                return true;
            } else {
                return false;
            }
        } else if (heldItem == null && this.burning) {
            world.setBlockAndMetadataWithNotify(x, y, z, CaveCliffBlocks.CANDLE_COLORED.id(), meta);
            return true;
        } else {
            return false;
        }
    }

    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        return new ItemStack[]{new ItemStack(CaveCliffBlocks.CANDLE_COLORED.id(), 1, meta)};
    }

    public String getLanguageKey(int meta) {
        return super.getLanguageKey(meta) + "." + DyeColor.colorFromBlockMeta((meta & 15)).colorID;
    }

}
