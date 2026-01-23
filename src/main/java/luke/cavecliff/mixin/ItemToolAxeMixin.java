package luke.cavecliff.mixin;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = ItemToolAxe.class, remap = false)
public class ItemToolAxeMixin extends ItemTool {

    public ItemToolAxeMixin(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
        super(name, namespaceId, id, 3, enumtoolmaterial, BlockTags.MINEABLE_BY_AXE);
    }

    @Override
    public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
        int blockToScrape = world.getBlockId(blockX, blockY, blockZ);
        int meta = world.getBlockMetadata(blockX, blockY, blockZ);

        //COPPER BLOCK
        if (blockToScrape == CaveCliffBlocks.BLOCK_COPPER.id() && meta > 0) {
            Block<?> scrapedBlock = CaveCliffBlocks.BLOCK_COPPER;
            world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
            if (!world.isClientSide) {
                world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id(), meta - 1);
                itemstack.damageItem(1, player);
                player.swingItem();
            }
        }

        //COPPER BRICK
        if (blockToScrape == CaveCliffBlocks.BRICK_COPPER.id() && meta > 0) {
            Block<?> scrapedBlock = CaveCliffBlocks.BRICK_COPPER;
            world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
            if (!world.isClientSide) {
                world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id(), meta - 1);
                itemstack.damageItem(1, player);
                player.swingItem();
            }
        }

        //COPPER BRICK SLABS
        if (blockToScrape == CaveCliffBlocks.SLAB_BRICK_COPPER.id() && meta > 15) {
            Block<?> scrapedBlock = CaveCliffBlocks.SLAB_BRICK_COPPER;
            world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
            if (!world.isClientSide) {
                world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id(), meta - 16);
                itemstack.damageItem(1, player);
                player.swingItem();
            }
        }

        //COPPER BRICK STAIRS
        if (blockToScrape == CaveCliffBlocks.STAIRS_BRICK_COPPER.id() && meta > 15) {
            Block<?> scrapedBlock = CaveCliffBlocks.STAIRS_BRICK_COPPER;
            world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
            if (!world.isClientSide) {
                world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id(), meta - 16);
                itemstack.damageItem(1, player);
                player.swingItem();
            }
        }

        return false;
    }

}
