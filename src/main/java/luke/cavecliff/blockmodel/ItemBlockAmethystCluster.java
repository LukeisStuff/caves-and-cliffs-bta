package luke.cavecliff.blockmodel;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class ItemBlockAmethystCluster<T extends BlockLogic> extends ItemBlock<T> {

	public ItemBlockAmethystCluster(Block<T> block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata();
	}

	@Override
	public String getLanguageKey(ItemStack itemstack) {
		return block.getKey();
	}
}
