package luke.cavecliff.block;

import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockDripleafLarge extends BlockFlower {

	public BlockDripleafLarge(String key, int id) {
		super(key, id);
		this.setBlockBounds(0.1f, 0.9f, 0.1f, 0.9f, 1.0f, 0.9f);
	}

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		int meta = world.getBlockMetadata(x, y, z) & 0x11111100;
		Direction hRotation = entity.getHorizontalPlacementDirection(side);
		if (hRotation == Direction.NORTH) {
			meta |= 0;
		}
		if (hRotation == Direction.EAST) {
			meta |= 1;
		}
		if (hRotation == Direction.SOUTH) {
			meta |= 2;
		}
		if (hRotation == Direction.WEST) {
			meta |= 3;
		}
		world.setBlockMetadataWithNotify(x, y, z, meta);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return AABB.getBoundingBoxFromPool((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
	}


}
