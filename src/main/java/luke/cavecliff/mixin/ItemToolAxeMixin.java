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

		//COPPER BLOCK
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


		//COPPER BRICK
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




		//COPPER BRICK SLABS
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 16) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 17) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 18) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}

		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 32) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 33) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 34) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}

		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 48) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 49) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.slabBrickCopper.id) {
			if (meta == 50) {
				Block scrapedBlock = CaveCliffBlocks.slabBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}







		//COPPER BRICK STAIRS
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 59) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 58) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 57) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 56) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 51) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 50) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 49) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 48) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}

		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 43) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 42) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 41) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 40) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 35) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 34) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 33) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 32) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}

		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 27) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 26) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 25) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 24) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 19) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 18) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 17) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}
		if (blockToScrape == CaveCliffBlocks.stairsBrickCopper.id) {
			if (meta == 16) {
				Block scrapedBlock = CaveCliffBlocks.stairsBrickCopper;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 16);
					itemstack.damageItem(1, entityplayer);
					entityplayer.swingItem();
				}
			}
			entityplayer.swingItem();
		}


		return false;
	}
}
