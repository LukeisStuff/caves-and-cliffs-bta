package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockSlab;

public class ItemBlockSlabCopper extends ItemBlockSlab {
	public final boolean upperMetadata;

	public ItemBlockSlabCopper(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = true;
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockCopper.oxidizeStages[BlockCopper.getMetadataForOxidation((itemstack.getMetadata() & 60) >> 4)] : super.getKey() + "." + BlockCopper.oxidizeStages[BlockCopper.getMetadataForOxidation(itemstack.getMetadata())];
	}
}
