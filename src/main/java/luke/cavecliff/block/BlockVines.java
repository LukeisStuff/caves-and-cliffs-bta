package luke.cavecliff.block;

import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockVines extends Block implements IBonemealable {

	public BlockVines(String key, int id, Material material) {
		super(key, id, material);
		this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
	}

	public static int getMetadataForGrowth(int i) {
		return ~i & 3;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isBlockNormalCube(x, y + 1, z) || Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.isBlockNormalCube(x, y + 1, z) || Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF);
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (meta == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 0);
			return new ItemStack[]{new ItemStack(CaveCliffItems.foodGlowBerries, world.rand.nextInt(2) + 1)};
		}
		if (meta == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 2);
			return new ItemStack[]{new ItemStack(CaveCliffItems.foodGlowBerries, world.rand.nextInt(1) + 1)};
		}
        return null;
    }

	public void onBlockLeftClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
		this.onBlockRightClicked(world, x, y, z, player, null, 0.0, 0.0);
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xPlaced, double yPlaced) {
		int meta = world.getBlockMetadata(x, y, z);
		int decayData = meta & 15;
		int growthRate = (meta & 240) >> 4;
		if (growthRate > 0) {
			world.playSoundAtEntity(player, player, "random.pop", 0.2F, 0.5F);
			if (!world.isClientSide) {
				this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, meta, null);
			}

			world.setBlockMetadataWithNotify(x, y, z, decayData);
			world.scheduleBlockUpdate(x, y, z, leavesCherryFlowering.id, this.tickRate());
			return true;
		} else {
			return super.onBlockRightClicked(world, x, y, z, player, side, xPlaced, yPlaced);
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0) {
			if (rand.nextInt(20) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 1 | meta);
			}
		}
		if (meta == 2) {
			if (rand.nextInt(20) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 3 | meta);
			}
		}
	}

	public boolean onBonemealUsed(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int meta = world.getBlockMetadata(blockX, blockY, blockZ);
		if (meta == 0) {
			if (!world.isClientSide) {
				world.setBlockMetadataWithNotify(blockX, blockY, blockZ, 1 | meta);
				if (entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
				}
			}

			return true;
		} else {
			if (meta == 2) {
				if (!world.isClientSide) {
					world.setBlockMetadataWithNotify(blockX, blockY, blockZ, 3 | meta);
					if (entityplayer.getGamemode().consumeBlocks()) {
						--itemstack.stackSize;
					}
				}

				return true;
			} else {
				return false;
			}
		}
	}

}
