package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import luke.cavecliff.item.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockAmethystCluster extends Block {


	public BlockAmethystCluster(String key, int id, Material material) {
		super(key, id, material);
		this.setTicking(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		int l = world.getBlockMetadata(x, y, z);
		if (l < 2) {
			float f = this.getGrowthRate(world, x, y, z);
			if (rand.nextInt((int) (100.0F / f)) == 0) {
				++l;
				world.setBlockMetadataWithNotify(x, y, z, l);
			}
		}
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public float getGrowthRate(World world, int x, int y, int z) {
		float growthRate = 1.0F;
		for (int dx = x - 1; dx <= x + 1; ++dx) {
			for (int dz = z - 1; dz <= z + 1; ++dz) {
				int id = world.getBlockId(dx, y - 1, dz);
				float growthRateMod = 0.0F;
				if (id == CaveCliffBlocks.amethystBudding.id) {
					growthRateMod = 1.0F;
					if (world.getBlockMetadata(dx, y - 1, dz) > 0) {
						growthRateMod = 3.0F;
					}
				}
				if (dx != x || dz != z) {
					growthRateMod /= 4.0F;
				}
				growthRate += growthRateMod;
			}
		}
		return growthRate;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return meta != 3 ? new ItemStack[]{new ItemStack(CaveCliffItems.amethyst)} : new ItemStack[]{new ItemStack(CaveCliffItems.amethyst, world.rand.nextInt(1) + 2), new ItemStack(CaveCliffItems.amethyst)};
	}

}

