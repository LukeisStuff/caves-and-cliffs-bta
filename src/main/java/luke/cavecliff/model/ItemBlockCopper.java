package luke.cavecliff.model;

import luke.cavecliff.block.BlockLogicCopper;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockCopper<T extends BlockLogic> extends ItemBlock<T> {
    private final boolean upperMetadata;

    public ItemBlockCopper(Block<T> block, boolean upperMetadata) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.upperMetadata = upperMetadata;
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        return this.upperMetadata
            ? super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((itemstack.getMetadata() & 60) >> 4)]
            : super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((itemstack.getMetadata() & 3))];
    }
}
