package luke.cavecliff;

import luke.cavecliff.block.*;
import luke.cavecliff.blockmodel.ItemBlockLichen;
import luke.cavecliff.blockmodel.ItemBlockSlabCopper;
import luke.cavecliff.blockmodel.ItemBlockStairsCopper;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.block.ItemBlockAlgae;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.cavecliff.CaveCliffMod.MOD_ID;
import static net.minecraft.core.block.material.MaterialColor.registerManualBlockColor;
import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;

public class CaveCliffBlocks {
	public static int blockID = CaveCliffConfig.blockIDs;

	public static int blockID(String blockName) {
		try {
			return CaveCliffConfig.cfg.getInt(CaveCliffConfig.BlockIDs + "." + blockName);
		} catch (NullPointerException e) {
			CaveCliffConfig.properties.addEntry(CaveCliffConfig.BlockIDs + "." + blockName, blockID);
			return blockID++;
		}
	}

	public static Block<?> AMETHYST;
	public static Block<?> AMETHYST_BUDDING;
	public static Block<?> AMETHYST_CLUSTER_SMALL;
	public static Block<?> AMETHYST_CLUSTER_MEDIUM;
	public static Block<?> AMETHYST_CLUSTER_LARGE;
	public static Block<?> AMETHYST_CLUSTER;

	public static Block<?> ORE_COPPER_STONE;
	public static Block<?> ORE_COPPER_BASALT;
	public static Block<?> ORE_COPPER_LIMESTONE;
	public static Block<?> ORE_COPPER_GRANITE;
	public static Block<?> ORE_COPPER_PERMAFROST;

	public static Block<BlockLogicCopper> BLOCK_COPPER;
	public static Block<BlockLogicCopper> BRICK_COPPER;

	public static Block<BlockLogicSlabCopper> SLAB_BRICK_COPPER;
	public static Block<BlockLogicStairsCopper> STAIRS_BRICK_COPPER;

	public static Block<?> BLOCK_SNOW_POWDER;

	public static Block<?> CANDLE;
	public static Block<?> CANDLE_LIT;
	public static Block<?> CANDLE_COLORED;
	public static Block<?> CANDLE_COLORED_LIT;

	public static Block<?> DRIPSTONE;

	public static Block<?> LEAVES_AZALEA;
	public static Block<?> LEAVES_AZALEA_FLOWERING;
	public static Block<?> SAPLING_AZALEA;
	public static Block<?> SAPLING_AZALEA_FLOWERING;
	public static Block<?> LOG_AZALEA;

	public static Block<?> BLOCK_MOSS;
	public static Block<?> MOSS_LAYER;

	public static Block<?> DIRT_ROOTED;

	public static Block<?> BLOCK_IRON_RAW;
	public static Block<?> BLOCK_GOLD_RAW;
	public static Block<?> BLOCK_COPPER_RAW;

	public static Block<BlockLogicVines> VINES;
	public static Block<BlockLogicVines> VINES_GLOWING;

	public static Block<BlockLogicLichen> LICHEN;

	public static Block<?> FLOWER_SPORE;
	public static Block<?> DRIPLEAF_BIG;
	public static Block<?> DRIPLEAF_SMALL;

	public static Block<?> ROOTS;

	public static Block<?> LIGHTNING_ROD;

	public static Block<?> TUFF;
	public static Block<?> CALCITE;


	public void initializeBlockDetails() {
		LookupFuelFurnace.instance.addFuelEntry(CaveCliffBlocks.SAPLING_AZALEA.id(), 100);
		LookupFuelFurnace.instance.addFuelEntry(CaveCliffBlocks.SAPLING_AZALEA.id(), 100);

		LookupFuelFurnace.instance.addFuelEntry(CaveCliffBlocks.LOG_AZALEA.id(), 300);


		registerManualBlockColor(AMETHYST, 0, MaterialColor.paintedPurple);
		registerManualBlockColor(AMETHYST_BUDDING, 0, MaterialColor.paintedPurple);
		registerManualBlockColor(DRIPLEAF_SMALL, 0, MaterialColor.paintedPurple);
		registerManualBlockColor(AMETHYST_CLUSTER_MEDIUM, 0, MaterialColor.paintedPurple);
		registerManualBlockColor(AMETHYST_CLUSTER_LARGE, 0, MaterialColor.paintedPurple);
		registerManualBlockColor(AMETHYST_CLUSTER, 0, MaterialColor.paintedPurple);

		registerManualBlockColor(BLOCK_COPPER, 0, MaterialColor.paintedOrange);
		registerManualBlockColor(BLOCK_COPPER, 1, MaterialColor.granite);
		registerManualBlockColor(BLOCK_COPPER, 2, MaterialColor.dirt);
		registerManualBlockColor(BLOCK_COPPER, 3, MaterialColor.diamond);

		registerManualBlockColor(BRICK_COPPER, 0, MaterialColor.paintedOrange);
		registerManualBlockColor(BRICK_COPPER, 1, MaterialColor.granite);
		registerManualBlockColor(BRICK_COPPER, 2, MaterialColor.dirt);
		registerManualBlockColor(BRICK_COPPER, 3, MaterialColor.diamond);

		registerManualBlockColor(SLAB_BRICK_COPPER, 0, MaterialColor.paintedOrange);
		registerManualBlockColor(SLAB_BRICK_COPPER, 16, MaterialColor.granite);
		registerManualBlockColor(SLAB_BRICK_COPPER, 32, MaterialColor.dirt);
		registerManualBlockColor(SLAB_BRICK_COPPER, 48, MaterialColor.diamond);

		for (int i = 0; i < 16; ++i) {
			registerManualBlockColor(STAIRS_BRICK_COPPER, i, MaterialColor.paintedOrange);
			registerManualBlockColor(SLAB_BRICK_COPPER, i, MaterialColor.paintedOrange);
		}
		for (int i = 16; i < 32; ++i) {
			registerManualBlockColor(STAIRS_BRICK_COPPER, i, MaterialColor.granite);
			registerManualBlockColor(SLAB_BRICK_COPPER, i, MaterialColor.granite);
		}
		for (int i = 32; i < 48; ++i) {
			registerManualBlockColor(STAIRS_BRICK_COPPER, i, MaterialColor.dirt);
			registerManualBlockColor(SLAB_BRICK_COPPER, i, MaterialColor.dirt);
		}
		for (int i = 48; i < 64; ++i) {
			registerManualBlockColor(STAIRS_BRICK_COPPER, i, MaterialColor.diamond);
			registerManualBlockColor(SLAB_BRICK_COPPER, i, MaterialColor.diamond);
		}

		registerManualBlockColor(BLOCK_COPPER_RAW, 0, MaterialColor.paintedOrange);
		registerManualBlockColor(BLOCK_IRON_RAW, 0, MaterialColor.dirt);
		registerManualBlockColor(BLOCK_GOLD_RAW, 0, MaterialColor.gold);

		registerManualBlockColor(DRIPSTONE, 0, MaterialColor.dirt);

		registerManualBlockColor(TUFF, 0, MaterialColor.paintedGrey);
		registerManualBlockColor(CALCITE, 0, MaterialColor.paintedWhite);


		miningLevels.put(DRIPSTONE, 0);

		miningLevels.put(AMETHYST, 1);
		miningLevels.put(AMETHYST_BUDDING, 1);
		miningLevels.put(AMETHYST_CLUSTER_SMALL, 1);
		miningLevels.put(AMETHYST_CLUSTER_MEDIUM, 1);
		miningLevels.put(AMETHYST_CLUSTER_LARGE, 1);
		miningLevels.put(AMETHYST_CLUSTER, 1);

		miningLevels.put(BLOCK_COPPER, 1);
		miningLevels.put(BRICK_COPPER, 1);
		miningLevels.put(BLOCK_COPPER_RAW, 1);
		miningLevels.put(BLOCK_IRON_RAW, 1);
		miningLevels.put(STAIRS_BRICK_COPPER, 1);
		miningLevels.put(SLAB_BRICK_COPPER, 1);
		miningLevels.put(LIGHTNING_ROD, 1);
		miningLevels.put(ORE_COPPER_STONE, 1);
		miningLevels.put(ORE_COPPER_BASALT, 1);
		miningLevels.put(ORE_COPPER_GRANITE, 1);
		miningLevels.put(ORE_COPPER_LIMESTONE, 1);
		miningLevels.put(ORE_COPPER_PERMAFROST, 1);

		miningLevels.put(BLOCK_GOLD_RAW, 2);
	}

	public void initializeBlocks() {

		BlockBuilder leaves = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.2F)
			.setResistance(0.2F)
			.setFlammability(30, 60)
			.setLightOpacity(1)
			.setTickOnLoad()
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH);

		BlockBuilder sapling = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR);

		BlockBuilder stone = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder amethyst = stone
			.setBlockSound(new BlockSound("random.glass", "random.glass", 1.0f, 2.0f))
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CAVES_CUT_THROUGH, BlockTags.CAVE_GEN_REPLACES_SURFACE)
			.setResistance(1.5f);

		BlockBuilder ore = stone
			.setHardness(3.0f)
			.setResistance(5.0f);

		BlockBuilder metal = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.5f))
			.setHardness(5.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder grass = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.1f)
			.setResistance(0.1f)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS, BlockTags.GROWS_SUGAR_CANE, BlockTags.GROWS_TREES, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH);


		LOG_AZALEA = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.0F)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.build("log.azalea", "log_azalea", blockID("LOG_AZALEA"), BlockLogicLog::new);

		LEAVES_AZALEA = leaves
			.build("leaves.azalea", "leaves_azalea", blockID("LEAVES_AZALEA"), b -> new BlockLogicLeavesBase(b, Material.leaves, SAPLING_AZALEA));

		SAPLING_AZALEA = sapling
			.build("sapling.azalea", "sapling_azalea", blockID("SAPLING_AZALEA"), b -> new BlockLogicSaplingAzalea(b, LEAVES_AZALEA));

		LEAVES_AZALEA_FLOWERING = leaves
			.build("leaves.azalea.flowering", "leaves_skyroot_flowering", blockID("LEAVES_AZALEA_FLOWERING"), b -> new BlockLogicLeavesBase(b, Material.leaves, SAPLING_AZALEA_FLOWERING));

		SAPLING_AZALEA_FLOWERING = sapling
			.build("sapling.azalea.flowering", "sapling_azalea_flowering", blockID("SAPLING_AZALEA_FLOWERING"), b -> new BlockLogicSaplingAzalea(b, LEAVES_AZALEA_FLOWERING));


		CANDLE = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS)
			.build("candle", "candle", blockID("CANDLE"), b -> new BlockLogicCandleWax(b, Material.decoration, false));

		CANDLE_LIT = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setLuminance(10)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build("candle.lit", "candle_lit", blockID("CANDLE_LIT"), b -> new BlockLogicCandleWax(b, Material.decoration, true));


		CANDLE_COLORED = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS)
			.build("candle.colored", "candle_colored", blockID("CANDLE_COLORED"), b -> new BlockLogicCandleWaxColored(b, Material.decoration, false));


		CANDLE_COLORED_LIT = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.sand", "step.sand", 1.0f, 0.8f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setLuminance(10)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build("candle.colored.lit", "candle_colored_lit", blockID("CANDLE_COLORED_LIT"), b -> new BlockLogicCandleWaxColored(b, Material.decoration, true));


		AMETHYST = amethyst
			.build("amethyst", "amethyst", blockID("AMETHYST"), b -> new BlockLogic(b, Material.stone));

		AMETHYST_BUDDING = amethyst
			.setTicking(true)
			.setTickOnLoad()
			.build("amethyst.budding", "amethyst_budding", blockID("AMETHYST_BUDDING"), b -> new BlockLogicBuddingAmethyst(b, Material.stone));


		AMETHYST_CLUSTER_SMALL = amethyst
			.setLuminance(1)
			.setTicking(true)
			.setTickOnLoad()
			.build("amethyst.cluster.small", "amethyst_cluster_small", blockID("AMETHYST_CLUSTER_SMALL"), block -> new BlockLogicAmethystCluster(block, 0.25f, AMETHYST_CLUSTER_MEDIUM));
		AMETHYST_CLUSTER_MEDIUM = amethyst
			.setLuminance(2)
			.setTicking(true)
			.setTickOnLoad()
			.build("amethyst.cluster.medium", "amethyst_cluster_medium", blockID("AMETHYST_CLUSTER_MEDIUM"), block -> new BlockLogicAmethystCluster(block, 0.3f, AMETHYST_CLUSTER_LARGE));
		AMETHYST_CLUSTER_LARGE = amethyst
			.setLuminance(4)
			.setTicking(true)
			.setTickOnLoad()
			.build("amethyst.cluster.large", "amethyst_cluster_large", blockID("AMETHYST_CLUSTER_LARGE"), block -> new BlockLogicAmethystCluster(block, 0.35f, AMETHYST_CLUSTER));
		AMETHYST_CLUSTER = amethyst
			.setLuminance(5)
			.setTicking(true)
			.setTickOnLoad()
			.build("amethyst.cluster", "amethyst_cluster", blockID("AMETHYST_CLUSTER"), block -> new BlockLogicAmethystCluster(block, 0.4f, null));

		BLOCK_COPPER = metal
			.setTicking(true)
			.build("block.copper", "block_copper", blockID("BLOCK_COPPER"), BlockLogicCopper::new);


		BRICK_COPPER = metal
			.setTicking(true)
			.build("brick.copper", "brick_copper", blockID("BRICK_COPPER"), BlockLogicCopper::new);

		SLAB_BRICK_COPPER = metal
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setTicking(true)
			.setBlockItem(ItemBlockSlabCopper::new)
			.build("slab.brick.copper", "slab_brick_copper", blockID("SLAB_BRICK_COPPER"), b -> new BlockLogicSlabCopper(b, BRICK_COPPER));

		STAIRS_BRICK_COPPER = metal
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setTicking(true)
			.setBlockItem(ItemBlockStairsCopper::new)
			.build("stairs.brick.copper", "stairs_brick_copper", blockID("STAIRS_BRICK_COPPER"), b -> new BlockLogicStairsCopper(b, BRICK_COPPER));


		// Copper Ores
		ORE_COPPER_STONE = ore
			.build("ore.copper.stone", "ore_copper_stone", blockID("ORE_COPPER_STONE"), b -> new BlockLogicOreCopper(b, Blocks.STONE, Material.stone));
		ORE_COPPER_BASALT = ore
			.build("ore.copper.basalt", "ore_copper_basalt", blockID("ORE_COPPER_BASALT"), b -> new BlockLogicOreCopper(b, Blocks.BASALT, Material.basalt));
		ORE_COPPER_LIMESTONE = ore
			.build("ore.copper.limestone", "ore_copper_limestone", blockID("ORE_COPPER_LIMESTONE"), b -> new BlockLogicOreCopper(b, Blocks.LIMESTONE, Material.limestone));
		ORE_COPPER_GRANITE = ore
			.build("ore.copper.granite", "ore_copper_granite", blockID("ORE_COPPER_GRANITE"), b -> new BlockLogicOreCopper(b, Blocks.GRANITE, Material.granite));
		ORE_COPPER_PERMAFROST = ore
			.build("ore.copper.permafrost", "ore_copper_permafrost", blockID("ORE_COPPER_PERMAFROST"), b -> new BlockLogicOreCopper(b, Blocks.PERMAFROST, Material.permafrost));


		BLOCK_IRON_RAW = metal
			.build("block.raw.iron", "block_raw_iron", blockID("BLOCK_IRON_RAW"), b -> new BlockLogic(b, Material.metal));
		BLOCK_GOLD_RAW = metal
			.build("block.raw.gold", "block_raw_gold", blockID("BLOCK_GOLD_RAW"), b -> new BlockLogic(b, Material.metal));
		BLOCK_COPPER_RAW = metal
			.build("block.raw.copper", "block_raw_copper", blockID("BLOCK_COPPER_RAW"), b -> new BlockLogic(b, Material.metal));


		DIRT_ROOTED = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 0.8f))
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS, BlockTags.GROWS_SUGAR_CANE, BlockTags.GROWS_TREES, BlockTags.CAVES_CUT_THROUGH)
			.build("dirt.rooted", "dirt_rooted", blockID("DIRT_ROOTED"), BlockLogicDirtRooted::new);


		DRIPSTONE = stone
			.setTicking(true)
			.setTickOnLoad()
			.build("dripstone", "dripstone", blockID("DRIPSTONE"), b -> new BlockLogicDripstone(b, Material.stone));

		BLOCK_SNOW_POWDER = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setHardness(0.2f)
			.setResistance(0.2f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PREVENT_MOB_SPAWNS)
			.build("block.snow.powder", "block_snow_powder", blockID("BLOCK_SNOW_POWDER"), BlockLogicPowderSnow::new);


		BLOCK_MOSS = grass
			.setFlammability(100, 30)
			.build("block.moss", "block_moss", blockID("BLOCK_MOSS"), b -> new BlockLogicMoss(b, b));


		MOSS_LAYER = grass
			.setFlammability(100, 30)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SHOVEL, BlockTags.BROKEN_BY_FLUIDS, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH)
			.build("moss.layer", "moss_layer", blockID("MOSS_LAYER"), b -> new BlockLogicLayerLeaves(b, BLOCK_MOSS, Material.moss));


		ROOTS = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
			.build("roots", "roots", blockID("ROOTS"), BlockLogicRoots::new);


		VINES = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTicking(true)
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.CAN_HANG_OFF, BlockTags.BROKEN_BY_FLUIDS)
			.build("vines", "vines", blockID("VINES"), b -> new BlockLogicVines(b, Material.leaves, false));


		VINES_GLOWING = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setUseInternalLight()
			.setTicking(true)
			.setLuminance(14)
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.CAN_HANG_OFF, BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build("vines.glowing", "vines_glowing", blockID("VINES_GLOWING"), b -> new BlockLogicVines(b, Material.leaves, true));

		FLOWER_SPORE = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setUseInternalLight()
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
			.build("flower.spore", "flower_spore", blockID("FLOWER_SPORE"), BlockLogicSpore::new);

		DRIPLEAF_SMALL = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR)
			.build("dripleaf.small", "dripleaf_small", blockID("DRIPLEAF_SMALL"), BlockLogicDripleafSmall::new);

		DRIPLEAF_BIG = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
			.setBlockItem(ItemBlockAlgae::new)
			.build("dripleaf.big", "dripleaf_big", blockID("DRIPLEAF_BIG"), block -> new BlockLogicDripleafBig(block, Material.grass));

		LICHEN = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setLuminance(7)
			.setUseInternalLight()
			.setBlockItem(ItemBlockLichen::new)
			.setTags(BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
			.build("lichen", "lichen", blockID("LICHEN"), block -> new BlockLogicLichen(block, Material.grass));

		LIGHTNING_ROD = metal
			.setVisualUpdateOnMetadata()
			.build("lightning.rod", "lightning_rod", blockID("LIGHTNING_ROD"), BlockLogicLightningRod::new);


		TUFF = stone
			.setResistance(6.0f)
			.build("tuff", "tuff", blockID("TUFF"), b -> new BlockLogic(b, Material.basalt));

		CALCITE = stone
			.setHardness(0.75f)
			.setResistance(0.75f)
			.build("calcite", "calcite", blockID("CALCITE"), b -> new BlockLogic(b, Material.marble));

	}

}

