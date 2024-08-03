package luke.cavecliff.block;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
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
}
