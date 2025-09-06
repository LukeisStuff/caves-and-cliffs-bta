package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockLogicAmethystCluster extends BlockLogic {
	private final float size; // Fixed size per block
	private final Block<?> nextStage; // Next growth stage (null for cluster)

	public BlockLogicAmethystCluster(Block<?> block, float size, Block<?> nextStage) {
		super(block, Material.glass);
		this.size = size;
		this.nextStage = nextStage;
		setBlockBoundsForSize();
	}

	private void setBlockBoundsForSize() {
		setBlockBounds(0.5F - size, 0.0F, 0.5F - size, 0.5F + size, size * 2.0F, 0.5F + size);
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
		float growthRate = getGrowthRate(world, x, y, z);
		if (rand.nextInt((int) (100.0F / growthRate)) == 0) {
			world.setBlockAndMetadataWithNotify(x, y, z, nextStage.id(), meta);
		}
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}


	public boolean canPlaceBlockAt(World world, int x, int y, int z, int meta) {
		Side facing = getFacingFromMetadata(meta);
		int adjX = x - facing.getOffsetX();
		int adjY = y - facing.getOffsetY();
		int adjZ = z - facing.getOffsetZ();
        return world.isBlockNormalCube(adjX, adjY, adjZ) || world.getBlockId(adjX, adjY, adjZ) == CaveCliffBlocks.AMETHYST_BUDDING.id();
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		int meta = world.getBlockMetadata(x, y, z);
		if (!canPlaceBlockAt(world, x, y, z, meta)) {
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	public float getGrowthRate(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		Side facing = getFacingFromMetadata(meta);
		int adjX = x - facing.getOffsetX();
		int adjY = y - facing.getOffsetY();
		int adjZ = z - facing.getOffsetZ();
		float growthRate = 1.0F;
		for (int dx = adjX - 1; dx <= adjX + 1; ++dx) {
			for (int dz = adjZ - 1; dz <= adjZ + 1; ++dz) {
				int id = world.getBlockId(dx, adjY, dz);
				float growthRateMod = 0.0F;
				if (id == CaveCliffBlocks.AMETHYST_BUDDING.id()) {
					growthRateMod = 1.0F;
					if (world.getBlockMetadata(dx, adjY, dz) > 0) {
						growthRateMod = 3.0F;
					}
				}
				if (dx != adjX || dz != adjZ) {
					growthRateMod /= 4.0F;
				}
				growthRate += growthRateMod;
			}
		}
		return growthRate;
	}

	public static Side getFacingFromMetadata(int meta) {
		switch (meta) {
            case 1: return Side.TOP;
			case 2: return Side.NORTH;
			case 3: return Side.SOUTH;
			case 4: return Side.WEST;
			case 5: return Side.EAST;
			default: return Side.BOTTOM;
		}
	}

	public static int getMetadataForFacing(Side facing) {
		switch (facing) {
            case TOP: return 1;
			case NORTH: return 2;
			case SOUTH: return 3;
			case WEST: return 4;
			case EAST: return 5;
			default: return 0;
		}
	}
}
