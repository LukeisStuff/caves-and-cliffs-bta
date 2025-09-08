package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockLogicLichen;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class ItemBlockLichen<T extends BlockLogic> extends ItemBlock<T> {

	public ItemBlockLichen(Block<T> block) {
		super(block);
	}

	public boolean onUseItemOnBlock(ItemStack stack, @Nullable Player player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		Block<?> clickedBlock = world.getBlock(x, y, z);
		BlockLogicLichen lichen = (BlockLogicLichen) this.block.getLogic();
		Side sideForPlacement;
		int meta;
		if (clickedBlock == this.block && player != null && !player.isSneaking()) {
			for (sideForPlacement = lichen.getSideFromMeta(world.getBlockMetadata(x, y, z)); world.getBlock(x, y, z) == this.block && lichen.getSideFromMeta(world.getBlockMetadata(x, y, z)) == sideForPlacement; --y) {
			}

			meta = lichen.getMetaForSide(sideForPlacement);
			return lichen.canExistAt(world, x, y, z, meta) && this.placeBlock(world, x, y, z, meta, player, stack, sideForPlacement, 0.5, 0.5);
		} else {
			if (!world.canPlaceInsideBlock(x, y, z)) {
				x += side.getOffsetX();
				y += side.getOffsetY();
				z += side.getOffsetZ();
			}

			sideForPlacement = lichen.getSideForPlacement(world, x, y, z, side);
			if (sideForPlacement == null) {
				return false;
			} else {
				meta = lichen.getMetaForSide(sideForPlacement);
				return lichen.canExistAt(world, x, y, z, meta) && this.placeBlock(world, x, y, z, meta, player, stack, sideForPlacement, xPlaced, yPlaced);
			}
		}
	}

	public boolean placeBlock(World world, int x, int y, int z, int meta, @Nullable Player player, ItemStack stack, Side side, double xPlaced, double yPlaced) {
		if (world.canPlaceInsideBlock(x, y, z) && world.canBlockBePlacedAt(this.block.id(), x, y, z, false, side) && stack.consumeItem(player) && world.setBlockAndMetadataWithNotify(x, y, z, this.block.id(), meta)) {
			this.block.onBlockPlacedByMob(world, x, y, z, side, player, xPlaced, yPlaced);
			world.playBlockSoundEffect(player, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, this.block, EnumBlockSoundEffectType.PLACE);
			return true;
		} else {
			return false;
		}
	}
}
