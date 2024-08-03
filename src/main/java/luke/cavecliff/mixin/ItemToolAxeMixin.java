package luke.cavecliff.mixin;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.player.EntityPlayer;
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


	public ItemToolAxeMixin(String name, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block> tagEffectiveAgainst) {
		super(name, id, damageDealt, toolMaterial, tagEffectiveAgainst);
	}

	@Override
	public boolean onUseItemOnBlock(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int blockToScrape = world.getBlockId(blockX, blockY, blockZ);
		int meta = world.getBlockMetadata(blockX, blockY, blockZ);
		if (blockToScrape == CaveCliffBlocks.blockCopper.id) {
			if (meta == 3) {
				Block scrapedBlock = CaveCliffBlocks.blockCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 2);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.blockCopper.id) {
			if (meta == 2) {
				Block scrapedBlock = CaveCliffBlocks.blockCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 1);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.blockCopper.id) {
			if (meta == 1) {
				Block scrapedBlock = CaveCliffBlocks.blockCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 0);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.brickCopper.id) {
			if (meta == 3) {
				Block scrapedBlock = CaveCliffBlocks.brickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 2);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.brickCopper.id) {
			if (meta == 2) {
				Block scrapedBlock = CaveCliffBlocks.brickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 1);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.brickCopper.id) {
			if (meta == 1) {
				Block scrapedBlock = CaveCliffBlocks.brickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, 0);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		return false;
	}
}
