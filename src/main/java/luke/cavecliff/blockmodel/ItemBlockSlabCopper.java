package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockLogicCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockSlab;

public class ItemBlockSlabCopper<T extends BlockLogic> extends ItemBlockSlab<T> {
	public final boolean upperMetadata;

	public ItemBlockSlabCopper(Block<T> block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = true;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((itemstack.getMetadata() & 60) >> 4)] : super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation(itemstack.getMetadata() & 15)];
	}
}
