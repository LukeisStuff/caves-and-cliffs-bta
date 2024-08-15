package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockDirtRooted extends Block implements IBonemealable {

	public BlockDirtRooted(String key, int id) {
		super(key, id, Material.dirt);
	}

	@Override
	public boolean onBonemealUsed(ItemStack itemStack, EntityPlayer entityPlayer, World world, int i, int j, int k, Side side, double d, double e) {
		return world.setBlockWithNotify(i, j - 1, k, CaveCliffBlocks.roots.id);
	}

	public void onBlockLeftClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
		if (!Item.hasTag(player.getCurrentEquippedItem(), ItemTags.PREVENT_LEFT_CLICK_INTERACTIONS)) {
			this.onBlockRightClicked(world, x, y, z, player, null, 0.0, 0.0);
		}

	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
		int l = world.getBlockMetadata(x, y, z);
		if  (player.getHeldItem() != null && player.getHeldItem().getItem() == Item.toolShears || player.getHeldItem().getItem() == Item.toolShearsSteel) {
			player.getHeldItem().damageItem(1, player);
			world.setBlockWithNotify(x, y, z, Block.dirt.id);
			world.playSoundAtEntity(player, player, "random.pop", 0.2F, 0.5F);
			world.dropItem(x, y, z, new ItemStack(CaveCliffBlocks.roots, 1));

			return true;
		}
		return false;
	}

}
