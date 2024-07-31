package luke.cavecliff;

import luke.cavecliff.block.BlockCopper;
import luke.cavecliff.block.BlockOreCopper;
import luke.cavecliff.blockmodel.BlockModelCopperBlock;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockBed;
import net.minecraft.core.block.BlockSeat;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import java.util.Random;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffBlocks {
	private int blockID(String blockName) {
		return CaveCliffConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block amethyst;
	public static Block amethystBudding;
	public static Block amethystCluster;

	public static Block calcite;
	public static Block tuff;

	public static Block oreCopperStone;
	public static Block oreCopperBasalt;
	public static Block oreCopperLimestone;
	public static Block oreCopperGranite;

	public static Block blockCopper;
	public static Block brickCopper;

	public static Block blockSnowPowder;

	public static Block candle;
	public static Block candleColored;

	public static Block dripstone;
	public static Block dripstonePointed;

	public static Block azaleaBush;
	public static Block leavesAzalea;
	public static Block saplingAzalea;
	public static Block logAzalea;

	public static Block moss;
	public static Block dirtRooted;

	public static Block blockIronRaw;
	public static Block blockGoldRaw;
	public static Block blockCopperRaw;

	public static Block vines;

	public static Block lichen;

	public static Block flowerSpore;


	public void initializeBlockDetails() {

	}

	public void initializeBlocks() {

		BlockBuilder ore = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(3.0f)
			.setResistance(5.0f)
			.setBlockModel(BlockModelStandard::new)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder metal = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.5f))
			.setHardness(5.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);




		blockCopper = metal
			.setBlockModel(BlockModelCopperBlock::new)
			.setTicking(true)
			.build(new BlockCopper("block.copper", blockID("blockCopper"), Material.metal));


		// Copper Ores
		oreCopperStone = ore
			.setTextures("cavecliff:block/ore_copper_stone")
			.build(new BlockOreCopper("ore.copper.stone", blockID("oreCopperStone")));
		oreCopperBasalt = ore
			.setTextures("cavecliff:block/ore_copper_basalt")
			.build(new BlockOreCopper("ore.copper.basalt", blockID("oreCopperBasalt")));
		oreCopperLimestone = ore
			.setTextures("cavecliff:block/ore_copper_limestone")
			.build(new BlockOreCopper("ore.copper.limestone", blockID("oreCopperLimestone")));
		oreCopperGranite = ore
			.setTextures("cavecliff:block/ore_copper_granite")
			.build(new BlockOreCopper("ore.copper.granite", blockID("oreCopperGranite")));


	}

}

