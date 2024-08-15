package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockStairsCopper extends ItemBlock {
	public ItemBlockStairsCopper(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return super.getKey() + "." + BlockCopper.oxidizeStages[BlockCopper.getMetadataForOxidation((itemstack.getMetadata() & 60) >> 4)];
	}
}
