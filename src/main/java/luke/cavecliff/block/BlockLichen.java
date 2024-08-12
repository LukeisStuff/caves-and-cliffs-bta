package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLichen extends Block {
	public BlockLichen(String key, int id) {
		super(key, id, Material.grass);
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isClimbable(World world, int x, int y, int z) {
		return false;
	}

	public void setBlockBoundsBasedOnState(WorldSource world, int x, int y, int z) {
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public AABB getSelectedBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!this.canExistAt(world, x, y, z, world.getBlockMetadata(x, y, z))) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, blockId, null);
			world.setBlockWithNotify(x, y, z, 0);
		}

	}

	public final boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return true;
	}

	public final boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return true;
	}

	public Side getSideForPlacement(World world, int x, int y, int z, Side clickedSide) {
		if (!world.canPlaceInsideBlock(x, y, z)) {
			x += clickedSide.getOffsetX();
			y += clickedSide.getOffsetY();
			z += clickedSide.getOffsetZ();
		}

		if (clickedSide != null && this.canExistAt(world, x, y, z, this.getMetaForSide(clickedSide))) {
			return clickedSide;
		} else if (this.canExistAt(world, x, y, z, this.getMetaForSide(Side.NORTH))) {
			return Side.NORTH;
		} else if (this.canExistAt(world, x, y, z, this.getMetaForSide(Side.SOUTH))) {
			return Side.SOUTH;
		} else if (this.canExistAt(world, x, y, z, this.getMetaForSide(Side.WEST))) {
			return Side.WEST;
		} else {
			return this.canExistAt(world, x, y, z, this.getMetaForSide(Side.EAST)) ? Side.EAST : null;
		}
	}

	public boolean canExistAt(World world, int x, int y, int z, int meta) {
		Side side = this.getSideFromMeta(meta).getOpposite();
		x += side.getOffsetX();
		y += side.getOffsetY();
		z += side.getOffsetZ();
		return world.isBlockNormalCube(x, y, z);
	}

	public void setBlockBounds(int meta) {
		Side side = this.getSideFromMeta(meta);
		float width = 0.1875F;
		if (side == Side.SOUTH) {
			this.setBlockBounds(0.0, 0.0, 0.0, 1.0, 1.0, (double)width);
		} else if (side == Side.WEST) {
			this.setBlockBounds((double)(1.0F - width), 0.0, 0.0, 1.0, 1.0, 1.0);
		} else if (side == Side.EAST) {
			this.setBlockBounds(0.0, 0.0, 0.0, (double)width, 1.0, 1.0);
		} else {
			this.setBlockBounds(0.0, 0.0, (double)(1.0F - width), 1.0, 1.0, 1.0);
		}

	}

	public Side getSideFromMeta(int meta) {
		if (meta == 2) {
			return Side.NORTH;
		} else if (meta == 3) {
			return Side.SOUTH;
		} else if (meta == 4) {
			return Side.WEST;
		} else {
			return meta == 5 ? Side.EAST : Side.NONE;
		}
	}

	public int getMetaForSide(Side side) {
		if (side == Side.NORTH) {
			return 2;
		} else if (side == Side.SOUTH) {
			return 3;
		} else if (side == Side.WEST) {
			return 4;
		} else {
			return side == Side.EAST ? 5 : 0;
		}
	}
}
