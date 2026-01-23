package luke.cavecliff.blockmodel;

import luke.cavecliff.block.BlockLogicCopper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockSlab;

@Environment(EnvType.CLIENT)
public class ItemBlockSlabCopper<T extends BlockLogic> extends ItemBlockSlab<T> {
    public final boolean upperMetadata;

    public ItemBlockSlabCopper(Block<T> block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.upperMetadata = true;
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        return this.upperMetadata ? super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation((itemstack.getMetadata() & 60) >> 4)] : super.getKey() + "." + BlockLogicCopper.oxidizeStages[BlockLogicCopper.getMetadataForOxidation(itemstack.getMetadata() & 3)];
    }
}
