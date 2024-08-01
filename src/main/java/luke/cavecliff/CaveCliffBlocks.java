package luke.cavecliff;

import luke.cavecliff.block.BlockAmethystCluster;
import luke.cavecliff.block.BlockBuddingAmethyst;
import luke.cavecliff.block.BlockCopper;
import luke.cavecliff.block.BlockOreCopper;
import luke.cavecliff.blockmodel.BlockModelAmethystCluster;
import luke.cavecliff.blockmodel.BlockModelCopperBlock;
import luke.cavecliff.blockmodel.BlockModelCopperBrick;
import luke.cavecliff.blockmodel.ItemBlockCopper;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

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

		BlockBuilder stone = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

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




		amethyst = stone
			.setBlockSound(new BlockSound("random.glass", "random.glass", 1.0f, 2.0f))
			.setTextures("cavecliff:block/amethyst")
			.build(new Block("amethyst", blockID("amethyst"), Material.stone));

		amethystBudding = stone
			.setBlockSound(new BlockSound("random.glass", "random.glass", 1.0f, 2.0f))
			.setTextures("cavecliff:block/amethyst_budding")
			.build(new BlockBuddingAmethyst("amethyst.budding", blockID("amethystBudding"), Material.stone));

		amethystCluster = stone
			.setHardness(1.5f)
			.setResistance(1.5f)
			.setLuminance(3)
			.setBlockSound(new BlockSound("random.glass", "random.glass", 1.0f, 2.0f))
			.setBlockModel(BlockModelAmethystCluster::new)
			.build(new BlockAmethystCluster("amethyst.cluster", blockID("amethystCluster"), Material.stone));

		blockCopper = metal
			.setBlockModel(BlockModelCopperBlock::new)
			.setTicking(true)
			.setItemBlock(block -> new ItemBlockCopper(block, false))
			.build(new BlockCopper("block.copper", blockID("blockCopper"), Material.metal));

		brickCopper = metal
			.setBlockModel(BlockModelCopperBrick::new)
			.setTicking(true)
			.setItemBlock(block -> new ItemBlockCopper(block, false))
			.build(new BlockCopper("brick.copper", blockID("brickCopper"), Material.metal));


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

