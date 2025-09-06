package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.Random;

public class BlockLogicVines extends BlockLogic implements IBonemealable {
	public boolean glowing;

	public BlockLogicVines(Block<?> block, Material material, boolean glowing) {
		super(block, material);
		this.setBlockBounds(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
		this.glowing = glowing;
	}


	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isBlockNormalCube(x, y + 1, z) || Blocks.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF);
	}

	public boolean isClimbable(World world, int x, int y, int z) {
		return true;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null, null);
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.isBlockNormalCube(x, y + 1, z) || Blocks.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case WORLD:
			case EXPLOSION:
			case PROPER_TOOL:
				if (glowing) {
					return new ItemStack[]{new ItemStack(CaveCliffItems.FOOD_GLOW_BERRIES, world.rand.nextInt(2) + 1)};
				}
			case PICK_BLOCK:
			case SILK_TOUCH:
				if (glowing) {
					return new ItemStack[]{new ItemStack(CaveCliffItems.FOOD_GLOW_BERRIES, world.rand.nextInt(2) + 1)};
				}
				return new ItemStack[]{new ItemStack(CaveCliffBlocks.VINES)};
			default:
				return null;
		}
	}


	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xHit, double yHit) {
		if (glowing) {
			world.setBlockWithNotify(x, y, z, CaveCliffBlocks.VINES.id());
			world.playSoundAtEntity(player, player, "random.pop", 0.2F, 0.5F);
			world.dropItem(x, y, z, new ItemStack(CaveCliffItems.FOOD_GLOW_BERRIES, world.rand.nextInt(2) + 1));
			player.swingItem();
		}
		return false;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		int blockBelow = world.getBlockId(x, y - 1, z);
		if (!glowing) {
			if (rand.nextInt(20) == 0) {
				if (rand.nextInt(4) == 0) {
					world.setBlockWithNotify(x, y, z, CaveCliffBlocks.VINES_GLOWING.id());
				} else {
					if (blockBelow == 0) {
						world.setBlockAndMetadataWithNotify(x, y - 1, z, CaveCliffBlocks.VINES.id(), 0);
					}
				}
			}
		}
	}

	public boolean onBonemealUsed(ItemStack itemStack, Player Player, World world, int blockX, int blockY, int blockZ, Side side, double d, double e) {
		if (!glowing) {
			if (!world.isClientSide) {
				world.setBlockWithNotify(blockX, blockY, blockZ, CaveCliffBlocks.VINES_GLOWING.id());
				if (Player.getGamemode().consumeBlocks()) {
					--itemStack.stackSize;
				}
				Player.swingItem();
			}
			return true;
		} else {
			return false;
		}
	}

}
