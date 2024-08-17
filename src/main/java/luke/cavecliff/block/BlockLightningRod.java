package luke.cavecliff.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLightningBolt;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLightningRod extends Block {
	public BlockLightningRod(String key, int id, Material material) {
		super(key, id, material);
		this.setBlockBounds(0.3125f, 0.0f, 0.3125f, 0.6875f, 1.0f, 0.6875f);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityLightningBolt) {
			world.setBlockMetadataWithNotify(x, y, z, 1);
			}
		}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getBlockMetadata(x, y, z) == 1) {
			if (rand.nextInt(20) == 0) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, 0);
				}
			}
		}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

}
