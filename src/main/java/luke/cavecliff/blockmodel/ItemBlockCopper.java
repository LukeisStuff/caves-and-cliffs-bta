package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockWool;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockCopper extends ItemBlock {
	public final boolean upperMetadata;

	public ItemBlockCopper(Block block, boolean upperMetadata) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = upperMetadata;
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockCopper.oxidizeStages[BlockCopper.getMetadataForOxidation((itemstack.getMetadata() & 9) >> 3)] : super.getKey() + "." + BlockCopper.oxidizeStages[BlockCopper.getMetadataForOxidation(itemstack.getMetadata())];
	}
}
