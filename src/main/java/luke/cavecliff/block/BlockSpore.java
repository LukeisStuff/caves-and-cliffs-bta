package luke.cavecliff.block;

import luke.cavecliff.entity.EntityFallingParticlesFX;
import luke.cavecliff.entity.EntityFloatingParticlesFX;
import net.minecraft.client.Minecraft;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockSpore extends Block {
	public BlockSpore(String key, int id) {
		super(key, id, Material.grass);
		this.setBlockBounds(0.0625f, 0.75f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		double random = (world.rand.nextInt(1) - Math.random());
		double randomLarge = (world.rand.nextInt(8) - Math.random());

		Minecraft mc = Minecraft.getMinecraft(Minecraft.class);
		if ( rand.nextInt(5) == 0) {
			mc.effectRenderer.addEffect(new EntityFallingParticlesFX(world, x, (double) y - random, z, 15.0, 0.0, 0.0));
		}


		if ( rand.nextInt(10) == 0) {
			mc.effectRenderer.addEffect(new EntityFloatingParticlesFX(world, x + randomLarge, (double) y - random, z + randomLarge, 0.0, 0.0, 0.0));
		}
		if ( rand.nextInt(10) == 0) {
			mc.effectRenderer.addEffect(new EntityFloatingParticlesFX(world, x - randomLarge, (double) y - random, z + randomLarge, 0.0, 0.0, 0.0));
		}
		if ( rand.nextInt(10) == 0) {
			mc.effectRenderer.addEffect(new EntityFloatingParticlesFX(world, x + randomLarge, (double) y - random, z - randomLarge, 0.0, 0.0, 0.0));
		}
		if ( rand.nextInt(10) == 0) {
			mc.effectRenderer.addEffect(new EntityFloatingParticlesFX(world, x - randomLarge, (double) y - random, z - randomLarge, 0.0, 0.0, 0.0));
		}
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block blockClass = Block.blocksList[world.getBlockId(x, y + 1, z)];
		int block = world.getBlockId(x, y + 1, z);
		return (world.isBlockNormalCube(x, y + 1, z) &&
			Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.FIREFLIES_CAN_SPAWN) ||
			Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.PASSIVE_MOBS_SPAWN) ||
			blockClass instanceof BlockLeavesBase ||
			blockClass instanceof BlockMoss ||
			blockClass instanceof BlockDirtPath ||
			blockClass instanceof BlockLog ||
			blockClass instanceof BlockClay ||
			block == Block.brickStonePolishedMossy.id ||
			block == Block.cobbleStoneMossy.id ||
			Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.GROWS_FLOWERS));
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return canPlaceBlockAt(world, x, y, z);
	}

}
