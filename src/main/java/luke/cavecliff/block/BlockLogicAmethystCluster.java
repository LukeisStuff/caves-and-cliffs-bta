package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlockLogicAmethystCluster extends BlockLogic {
    public float size;
    public Block<?> nextStage;

    public BlockLogicAmethystCluster(Block<?> block, float size, Block<?> nextStage) {
        super(block, Material.glass);
        this.size = size;
        this.nextStage = nextStage;
        setBlockBoundsForSize();
    }

    public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
        return stack.getMetadata();
    }

    public void setBlockBoundsForSize() {
        setBlockBounds(0.5F - size, 0.0F, 0.5F - size, 0.5F + size, size * 2.0F, 0.5F + size);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.isBlockNormalCube(x, y - 1, z);
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
        if (!this.canBlockStay(world, x, y, z)) {
            this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null, null);
            world.playBlockSoundEffect(null, (float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f, CaveCliffBlocks.AMETHYST, EnumBlockSoundEffectType.MINE);
            world.setBlockWithNotify(x, y, z, 0);
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        return world.isBlockNormalCube(x, y - 1, z);
    }

    @Override
    public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
        if (nextStage == null) {
            switch (dropCause) {
                case WORLD:
                case EXPLOSION:
                    return new ItemStack[]{new ItemStack(CaveCliffItems.AMETHYST, 2)};
                case PROPER_TOOL:
                    return new ItemStack[]{new ItemStack(CaveCliffItems.AMETHYST, world.rand.nextInt(2) + 2)};
                case SILK_TOUCH:
                case PICK_BLOCK:
                    return new ItemStack[]{new ItemStack(this, 1)};
                default:
                    return null;
            }
        }
        return dropCause == EnumDropCause.SILK_TOUCH || dropCause == EnumDropCause.PICK_BLOCK ? new ItemStack[]{new ItemStack(this, 1)} : null;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (nextStage == null) return;
        int meta = world.getBlockMetadata(x, y, z);
        if (rand.nextInt(100) == 0) {
            world.setBlockAndMetadataWithNotify(x, y, z, nextStage.id(), meta);
        }
    }

    @Override
    public boolean isSolidRender() {
        return false;
    }

    @Override
    public boolean isCubeShaped() {
        return false;
    }

}
