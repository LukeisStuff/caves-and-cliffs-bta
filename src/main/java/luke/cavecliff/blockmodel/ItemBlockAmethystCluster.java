package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockAmethystCluster;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockAmethystCluster extends ItemBlock {
	public final boolean upperMetadata;

	public ItemBlockAmethystCluster(Block block, boolean upperMetadata) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = upperMetadata;
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockAmethystCluster.growthStages[BlockAmethystCluster.getMetadataForGrowth((itemstack.getMetadata() & 9) >> 3)] : super.getKey() + "." + BlockAmethystCluster.growthStages[BlockAmethystCluster.getMetadataForGrowth(itemstack.getMetadata())];
	}
}
