package luke.cavecliff;

import luke.cavecliff.block.*;
import luke.cavecliff.blockmodel.*;
import luke.cavecliff.blockmodel.BlockModelCandle;
import net.minecraft.client.render.block.model.*;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLayerLeaves;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockLeaves;
import net.minecraft.core.sound.BlockSound;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffBlocks {
	public int blockID(String blockName) {
		return CaveCliffConfig.cfg.getInt("Block IDs." + blockName);
	}

	public static Block amethyst;
	public static Block amethystBudding;
	public static Block amethystCluster;

	public static Block oreCopperStone;
	public static Block oreCopperBasalt;
	public static Block oreCopperLimestone;
	public static Block oreCopperGranite;

	public static Block blockCopper;
	public static Block brickCopper;

	public static Block blockSnowPowder;

	public static Block candle;
	public static Block candleLit;
	public static Block candleColored;
	public static Block candleColoredLit;

	public static Block dripstone;
	public static Block dripstonePointed;

	public static Block leavesAzalea;
	public static Block leavesAzaleaFlowering;
	public static Block saplingAzalea;
	public static Block saplingAzaleaFlowering;
	public static Block logAzalea;

	public static Block moss;
	public static Block mossLayer;

	public static Block dirtRooted;

	public static Block blockIronRaw;
	public static Block blockGoldRaw;
	public static Block blockCopperRaw;

	public static Block vines;

	public static Block lichen;

	public static Block flowerSpore;
	public static Block dripleafBig;
	public static Block dripleafSmall;

	public static Block roots;


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

		BlockBuilder grass = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.1f)
			.setResistance(0.1f)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.GROWS_FLOWERS, BlockTags.GROWS_SUGAR_CANE, BlockTags.GROWS_TREES, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH);


		logAzalea = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.0F)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("cavecliff:block/log_azalea_top", "cavecliff:block/log_azalea"))
			.build(new BlockLog("log.azalea", blockID("logAzalea")));

		leavesAzalea = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.2F)
			.setResistance(0.2F)
			.setFlammability(30, 60)
			.setTickOnLoad()
			.setVisualUpdateOnMetadata()
			.setItemBlock(ItemBlockLeaves::new)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH)
			.setBlockModel(block -> new BlockModelLeaves<>(block, "cavecliff:block/leaves_azalea"))
			.build(new BlockLeavesBase("leaves.azalea", blockID("leavesAzalea"), Material.leaves) {
				@Override
				public Block getSapling() {
					return CaveCliffBlocks.saplingAzalea;
				}
			});

		saplingAzalea = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR)
			.setIcon("cavecliff:block/sapling_azalea")
			.setBlockModel(block -> new DFBlockModelBuilder(MOD_ID).setBlockModel("block/azalea.json").setRender3D(false).build(saplingAzalea))
			.build(new BlockSaplingAzalea("sapling.azalea", blockID("saplingAzalea")));

		leavesAzaleaFlowering = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.2F)
			.setResistance(0.2F)
			.setFlammability(30, 60)
			.setTickOnLoad()
			.setVisualUpdateOnMetadata()
			.setItemBlock(ItemBlockLeaves::new)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH)
			.setBlockModel(block -> new BlockModelLeaves<>(block, "cavecliff:block/leaves_azalea_flowering"))
			.build(new BlockLeavesBase("leaves.azalea.flowering", blockID("leavesAzaleaFlowering"), Material.leaves) {
				@Override
				public Block getSapling() {
					return CaveCliffBlocks.saplingAzaleaFlowering;
				}
			});

		saplingAzaleaFlowering = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setIcon("cavecliff:block/sapling_azalea_flowering")
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR)
			.setBlockModel(block -> new DFBlockModelBuilder(MOD_ID).setBlockModel("block/azalea_flowering.json").setRender3D(false).build(saplingAzaleaFlowering))
			.build(new BlockSaplingAzaleaFlowering("sapling.azalea.flowering", blockID("saplingAzaleaFlowering")));


		candle = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setIcon("cavecliff:item/candle")
			.setTextures("cavecliff:block/candle")
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCandle::new)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS)
			.build(new BlockCandle("candle", blockID("candle"), false));

		candleLit = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setIcon("cavecliff:item/candle")
			.setTextures("cavecliff:block/candle")
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setLuminance(8)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockModel(BlockModelCandle::new)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build(new BlockCandle("candle.lit", blockID("candleLit"), true));


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


		blockIronRaw = metal
			.setTextures("cavecliff:block/block_iron_raw")
			.build(new Block("block.raw.iron", blockID("blockIronRaw"), Material.metal));
		blockGoldRaw = metal
			.setTextures("cavecliff:block/block_gold_raw")
			.build(new Block("block.raw.gold", blockID("blockGoldRaw"), Material.metal));
		blockCopperRaw = metal
			.setTextures("cavecliff:block/block_copper_raw")
			.build(new Block("block.raw.copper", blockID("blockCopperRaw"), Material.metal));


		dirtRooted = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 0.8f))
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS, BlockTags.GROWS_SUGAR_CANE, BlockTags.GROWS_TREES, BlockTags.CAVES_CUT_THROUGH)
			.setTextures("cavecliff:block/dirt_rooted")
			.build(new BlockDirtRooted("dirt.rooted", blockID("dirtRooted")));


		dripstone = stone
			.setTopBottomTextures("cavecliff:block/dripstone_topbottom")
			.setSideTextures("cavecliff:block/dripstone_side")
			.build(new Block("dripstone", blockID("dripstone"), Material.stone));

		blockSnowPowder = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setHardness(0.2f)
			.setResistance(0.2f)
			.setTextures("cavecliff:block/powder_snow")
			.build(new BlockPowderSnow("block.snow.powder", blockID("blockSnowPowder")));


		moss = grass
			.setTextures("cavecliff:block/moss")
			.setFlammability(100, 30)
			.build(new BlockMossy("moss", blockID("moss")));

		mossLayer = grass
			.setBlockModel(block -> new BlockModelLayer<>(block).withTextures("cavecliff:block/moss"))
			.setFlammability(100, 30)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.BROKEN_BY_FLUIDS, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH)
			.build(new BlockLayerLeaves("moss.layer", blockID("mossLayer"), Material.moss));

		roots = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("cavecliff:block/roots"))
			.setVisualUpdateOnMetadata()
			.setUseInternalLight()
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
			.build(new BlockRoots("roots", blockID("roots")));

		vines = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCaveVine::new)
			.setVisualUpdateOnMetadata()
			.setUseInternalLight()
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.CAN_HANG_OFF, BlockTags.BROKEN_BY_FLUIDS)
			.build(new BlockVines("vines", blockID("vines"), Material.leaves));


	}

}

