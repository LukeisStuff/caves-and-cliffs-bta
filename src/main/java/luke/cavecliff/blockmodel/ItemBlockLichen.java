package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockLichen;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFluid;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemBlockLichen extends ItemBlock {
	public final BlockLichen blockLichen;

	public ItemBlockLichen(BlockLichen block) {
		super(block);
		this.blockLichen = block;
	}

	public boolean onUseItemOnBlock(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		Block clickedBlock = world.getBlock(x, y, z);
		Side sideForPlacement;
		int meta;
		if (clickedBlock == this.blockLichen && !player.isSneaking()) {
			for(sideForPlacement = this.blockLichen.getSideFromMeta(world.getBlockMetadata(x, y, z)); world.getBlock(x, y, z) == this.blockLichen && this.blockLichen.getSideFromMeta(world.getBlockMetadata(x, y, z)) == sideForPlacement; --y) {
			}

			meta = this.blockLichen.getMetaForSide(sideForPlacement);
			return this.blockLichen.canExistAt(world, x, y, z, meta) && this.placeBlock(world, x, y, z, meta, player, stack, sideForPlacement, 0.5);
		} else {
			if (!world.canPlaceInsideBlock(x, y, z)) {
				x += side.getOffsetX();
				y += side.getOffsetY();
				z += side.getOffsetZ();
			}

			sideForPlacement = this.blockLichen.getSideForPlacement(world, x, y, z, side);
			if (sideForPlacement == null) {
				return false;
			} else {
				meta = this.blockLichen.getMetaForSide(sideForPlacement);
				return this.blockLichen.canExistAt(world, x, y, z, meta) && this.placeBlock(world, x, y, z, meta, player, stack, sideForPlacement, yPlaced);
			}
		}
	}

	public boolean placeBlock(World world, int x, int y, int z, int meta, EntityPlayer player, ItemStack stack, Side side, double sideHeight) {
		Block currentBlock = world.getBlock(x, y, z);
		if (world.canPlaceInsideBlock(x, y, z) && world.canBlockBePlacedAt(this.blockID, x, y, z, false, side) && stack.consumeItem(player)) {
			if (currentBlock != null && !(currentBlock instanceof BlockFluid) && !world.isClientSide) {
				world.playSoundEffect(2001, x, y, z, world.getBlockId(x, y, z));
			}

			if (world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, meta)) {
				Block.getBlock(this.blockID).onBlockPlaced(world, x, y, z, side, player, sideHeight);
				world.playBlockSoundEffect(player, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.blockLichen, EnumBlockSoundEffectType.PLACE);
				return true;
			}
		}

		return false;
	}
}
