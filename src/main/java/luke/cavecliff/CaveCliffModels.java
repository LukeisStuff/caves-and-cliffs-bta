package luke.cavecliff;

import luke.cavecliff.blockmodel.BlockModelCandle;
import luke.cavecliff.blockmodel.*;
import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.axolotl.MobRendererAxolotl;
import luke.cavecliff.entity.axolotl.ModelAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.glowsquid.MobRendererGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import luke.cavecliff.entity.goat.MobRendererGoat;
import luke.cavecliff.entity.goat.ModelGoat;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.model.ModelSquid;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class CaveCliffModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.AMETHYST)
			.setAllTextures(0, "cavecliff:block/amethyst"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.AMETHYST_BUDDING)
			.setAllTextures(0, "cavecliff:block/amethyst_budding"));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.ORE_COPPER_STONE)
			.setAllTextures(0, "cavecliff:block/ore/copper/stone").setAllTextures(2, "cavecliff:block/ore/copper/stone_retro"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.ORE_COPPER_BASALT)
			.setAllTextures(0, "cavecliff:block/ore/copper/basalt"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.ORE_COPPER_GRANITE)
			.setAllTextures(0, "cavecliff:block/ore/copper/granite"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.ORE_COPPER_LIMESTONE)
			.setAllTextures(0, "cavecliff:block/ore/copper/limestone"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.ORE_COPPER_PERMAFROST)
			.setAllTextures(0, "cavecliff:block/ore/copper/permafrost"));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.BLOCK_SNOW_POWDER)
			.setAllTextures(0, "cavecliff:block/powder_snow"));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.DRIPSTONE)
			.setTex(0, "cavecliff:block/dripstone/side", Side.sides)
			.setTex(0, "cavecliff:block/dripstone/top", Side.TOP, Side.BOTTOM));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.BLOCK_MOSS)
			.setAllTextures(0, "cavecliff:block/moss"));
		dispatcher.addDispatch(new BlockModelLayer<>(CaveCliffBlocks.MOSS_LAYER)
			.setAllTextures(0, "cavecliff:block/moss"));

		dispatcher.addDispatch(new BlockModelAxisAligned<>(CaveCliffBlocks.LOG_AZALEA)
			.setTex(0, "cavecliff:block/log/azalea_side", Side.sides)
			.setTex(0, "cavecliff:block/log/azalea_top", Side.TOP, Side.BOTTOM));

		dispatcher.addDispatch(CaveCliffBlocks.LEAVES_AZALEA, new BlockModelLeaves<>(CaveCliffBlocks.LEAVES_AZALEA, "cavecliff:block/leaves/azalea", false));
		dispatcher.addDispatch(CaveCliffBlocks.LEAVES_AZALEA_FLOWERING, new BlockModelLeaves<>(CaveCliffBlocks.LEAVES_AZALEA_FLOWERING, "cavecliff:block/leaves/azalea_flowering", false));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.DIRT_ROOTED)
			.setAllTextures(0, "cavecliff:block/dirt_rooted"));

		dispatcher.addDispatch(new BlockModelSpore<>(CaveCliffBlocks.FLOWER_SPORE).setAllTextures(0, "cavecliff:block/spore_blossom_flower")
			.setTex(0, "cavecliff:block/spore_blossom_root", Side.BOTTOM).setTex(0, "cavecliff:block/spore_blossom_flower", Side.TOP));

		dispatcher.addDispatch(new BlockModelDripleafSmall<>(CaveCliffBlocks.DRIPLEAF_SMALL).setAllTextures(0, "cavecliff:block/dripleaf_small")
			.setTex(0, "cavecliff:block/dripleaf_small_stem", Side.BOTTOM).setTex(0, "cavecliff:block/dripleaf_small", Side.TOP));

		dispatcher.addDispatch(new BlockModelDripleafBig<>(CaveCliffBlocks.DRIPLEAF_BIG).setAllTextures(0, "cavecliff:block/dripleaf_big")
			.setTex(0, "cavecliff:block/dripleaf_big_stem", Side.BOTTOM));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.BLOCK_COPPER_RAW)
			.setAllTextures(0, "cavecliff:block/block_copper_raw"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.BLOCK_GOLD_RAW)
			.setAllTextures(0, "cavecliff:block/block_gold_raw"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.BLOCK_IRON_RAW)
			.setAllTextures(0, "cavecliff:block/block_iron_raw"));

		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.TUFF)
			.setAllTextures(0, "cavecliff:block/tuff"));
		dispatcher.addDispatch(new BlockModelStandard<>(CaveCliffBlocks.CALCITE)
			.setAllTextures(0, "cavecliff:block/calcite"));

		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.ROOTS)
			.setAllTextures(0, "cavecliff:block/roots"));

		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.SAPLING_AZALEA)
			.setAllTextures(0, "cavecliff:block/sapling/azalea"));
		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.SAPLING_AZALEA_FLOWERING)
			.setAllTextures(0, "cavecliff:block/sapling/azalea_flowering"));

		dispatcher.addDispatch(new BlockModelLadder<>(CaveCliffBlocks.LICHEN)
			.setAllTextures(0, "cavecliff:block/lichen").setAllTextures(1, "cavecliff:block/lichen_overlay"));

		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.AMETHYST_CLUSTER_SMALL).setAllTextures(0, "cavecliff:block/amethyst_small"));
		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.AMETHYST_CLUSTER_MEDIUM).setAllTextures(0, "cavecliff:block/amethyst_medium"));
		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.AMETHYST_CLUSTER_LARGE).setAllTextures(0, "cavecliff:block/amethyst_large"));
		dispatcher.addDispatch(new BlockModelCrossedSquares<>(CaveCliffBlocks.AMETHYST_CLUSTER).setAllTextures(0, "cavecliff:block/amethyst_cluster"));

		dispatcher.addDispatch(new BlockModelVines<>(CaveCliffBlocks.VINES));
		dispatcher.addDispatch(new BlockModelVinesGlowing<>(CaveCliffBlocks.VINES_GLOWING));

		dispatcher.addDispatch(new BlockModelCandle<>(CaveCliffBlocks.CANDLE).setAllTextures(0, "cavecliff:block/candle/candle"));
		dispatcher.addDispatch(new BlockModelCandle<>(CaveCliffBlocks.CANDLE_LIT).setAllTextures(0, "cavecliff:block/candle/candle"));
		dispatcher.addDispatch(new BlockModelCandlePainted<>(CaveCliffBlocks.CANDLE_COLORED));
		dispatcher.addDispatch(new BlockModelCandlePainted<>(CaveCliffBlocks.CANDLE_COLORED_LIT));

		dispatcher.addDispatch(new BlockModelCopperBlock<>(CaveCliffBlocks.BLOCK_COPPER));
		dispatcher.addDispatch(new BlockModelCopperBrick<>(CaveCliffBlocks.BRICK_COPPER));

		dispatcher.addDispatch(new BlockModelStairsCopper<>(CaveCliffBlocks.STAIRS_BRICK_COPPER));
		dispatcher.addDispatch(new BlockModelSlabCopper<>(CaveCliffBlocks.SLAB_BRICK_COPPER));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.AMETHYST, null).setIcon("cavecliff:item/amethyst"));
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.INGOT_COPPER, null).setIcon("cavecliff:item/ingot_copper"));
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.ORE_RAW_COPPER, null).setIcon("cavecliff:item/ore_raw_copper"));
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.FOOD_GLOW_BERRIES, null).setIcon("cavecliff:item/glowberries").setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.HORN_GOAT, null).setIcon("cavecliff:item/goat_horn").setFull3D());
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.INKSAC_GLOW, null).setIcon("cavecliff:item/inksac_glow").setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffItems.RECORD_OTHERSIDE, null).setIcon("cavecliff:item/otherside"));

		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.CANDLE.asItem(), null).setIcon("cavecliff:item/candle"));
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.CANDLE_LIT.asItem(), null).setIcon("cavecliff:item/candle").setFullBright());

		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.DRIPLEAF_SMALL.asItem(), null).setIcon("cavecliff:block/dripleaf_small_icon"));
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.FLOWER_SPORE.asItem(), null).setIcon("cavecliff:block/spore_blossom_flower"));

		dispatcher.addDispatch(new ItemModelCandleColored(CaveCliffBlocks.CANDLE_COLORED.asItem(), null));
		dispatcher.addDispatch(new ItemModelCandleColored(CaveCliffBlocks.CANDLE_COLORED_LIT.asItem(), null).setFullBright());

		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.VINES_GLOWING.asItem(), null).setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(CaveCliffBlocks.LICHEN.asItem(), null).setFullBright());


	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
		ModelHelper.setEntityModel(MobGoat.class, () -> new MobRendererGoat(new ModelGoat(), 0.6F));
		ModelHelper.setEntityModel(MobAxolotl.class, () -> new MobRendererAxolotl(new ModelAxolotl(), 0.4F));
		ModelHelper.setEntityModel(MobGlowSquid.class, () -> new MobRendererGlowSquid(new ModelSquid(), 0.7F));

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
