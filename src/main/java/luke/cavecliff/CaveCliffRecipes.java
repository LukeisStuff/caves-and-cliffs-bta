package luke.cavecliff;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffRecipes implements RecipeEntrypoint {

	public void initializeRecipes() {

		RecipeBuilderShaped templateItemtoBlock = new RecipeBuilderShaped(MOD_ID, "XXX", "XXX", "XXX");
		templateItemtoBlock.addInput('X', CaveCliffItems.amethyst).create("block_of_amethyst", new ItemStack(CaveCliffBlocks.amethyst, 1));
		templateItemtoBlock.addInput('X', CaveCliffItems.ingotCopper).create("block_of_copper", new ItemStack(CaveCliffBlocks.blockCopper, 1));
		templateItemtoBlock.addInput('X', CaveCliffItems.oreRawCopper).create("block_of_raw_copper", new ItemStack(CaveCliffBlocks.blockCopperRaw, 1));
		templateItemtoBlock.addInput('X', Item.oreRawGold).create("block_of_raw_gold", new ItemStack(CaveCliffBlocks.blockGoldRaw, 1));
		templateItemtoBlock.addInput('X', Item.oreRawIron).create("block_of_raw_iron", new ItemStack(CaveCliffBlocks.blockIronRaw, 1));

		RecipeBuilderShaped templateBricks = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.blockCopper, 1, 0)).create("copper_bricks", new ItemStack(CaveCliffBlocks.brickCopper, 4, 0));
		templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.blockCopper, 1, 1)).create("exposed_copper_bricks", new ItemStack(CaveCliffBlocks.brickCopper, 4, 1));
		templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.blockCopper, 1, 2)).create("weathered_copper_bricks", new ItemStack(CaveCliffBlocks.brickCopper, 4, 2));
		templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.blockCopper, 1, 3)).create("oxidized_copper_bricks", new ItemStack(CaveCliffBlocks.brickCopper, 4, 3));

		RecipeBuilderShaped templateStairs = new RecipeBuilderShaped(MOD_ID, "X ", "XX ", "XXX");
		templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 0)).create("copper_brick_stairs", new ItemStack(CaveCliffBlocks.stairsBrickCopper, 6, 0));
		templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 1)).create("exposed_copper_brick_stairs", new ItemStack(CaveCliffBlocks.stairsBrickCopper, 6, 16));
		templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 2)).create("weathered_copper_brick_stairs", new ItemStack(CaveCliffBlocks.stairsBrickCopper, 6, 32));
		templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 3)).create("oxidized_copper_brick_stairs", new ItemStack(CaveCliffBlocks.stairsBrickCopper, 6, 48));

		RecipeBuilderShaped templateSlab = new RecipeBuilderShaped(MOD_ID, "XXX");
		templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 0)).create("copper_brick_slab", new ItemStack(CaveCliffBlocks.slabBrickCopper, 6, 0));
		templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 1)).create("exposed_copper_brick_slab", new ItemStack(CaveCliffBlocks.slabBrickCopper, 6, 16));
		templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 2)).create("weathered_copper_brick_slab", new ItemStack(CaveCliffBlocks.slabBrickCopper, 6, 32));
		templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.brickCopper, 1, 3)).create("oxidized_copper_brick_slab", new ItemStack(CaveCliffBlocks.slabBrickCopper, 6, 48));


		RecipeBuilder.Shaped(MOD_ID, "S", "P", "E")
			.addInput('S', Item.string)
			.addInput('P', Item.paper)
			.addInput('E', Block.logEucalyptus)
			.create("candle", new ItemStack(CaveCliffBlocks.candle, 4));

		for (int color = 0; color < 16; color++) {
			RecipeBuilder.Shaped(MOD_ID, "CCC", "CDC", "CCC")
				.addInput('C', "cavecliff:block/candles")
				.addInput('D', new ItemStack(Item.dye, 1, 15 - color))
				.create("dyed_candle_dye", new ItemStack(CaveCliffBlocks.candleColored, 8, color));
		}


		RecipeBuilder.Furnace(MOD_ID)
			.setInput(CaveCliffItems.oreRawCopper)
			.create("copper_ingot", CaveCliffItems.ingotCopper.getDefaultStack());

		RecipeBuilder.Furnace(MOD_ID)
			.setInput("cavecliff:block/copper_ores")
			.create("copper_ores_to_copper", CaveCliffItems.ingotCopper.getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(CaveCliffItems.oreRawCopper)
			.create("copper_ingot_blast", CaveCliffItems.ingotCopper.getDefaultStack());

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput("cavecliff:block/copper_ores")
			.create("copper_ores_to_copper_blast", CaveCliffItems.ingotCopper.getDefaultStack());

		RecipeBuilder.initNameSpace(MOD_ID);
	}
	@Override
	public void onRecipesReady() {
		initializeRecipes();
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
		RecipeBuilder.getRecipeNamespace(MOD_ID);

		Registries.ITEM_GROUPS.getItem("minecraft:logs").add(CaveCliffBlocks.logAzalea.getDefaultStack());

		Registries.ITEM_GROUPS.getItem("minecraft:leaves").add(CaveCliffBlocks.leavesAzalea.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("minecraft:leaves").add(CaveCliffBlocks.leavesAzaleaFlowering.getDefaultStack());

		Registries.ITEM_GROUPS.getItem("minecraft:dirt").add(CaveCliffBlocks.dirtRooted.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("minecraft:trommel_dirt").add(CaveCliffBlocks.dirtRooted.getDefaultStack());

		Registries.ITEM_GROUPS.getItem("minecraft:moss_stones").add(CaveCliffBlocks.moss.getDefaultStack());

		Registries.ITEM_GROUPS.register("cavecliff:block/copper_ores", Registries.stackListOf(CaveCliffBlocks.oreCopperStone, CaveCliffBlocks.oreCopperBasalt, CaveCliffBlocks.oreCopperGranite, CaveCliffBlocks.oreCopperLimestone));

		Registries.ITEM_GROUPS.register("cavecliff:block/candles", Registries.stackListOf
			(CaveCliffBlocks.candle,
			new ItemStack(CaveCliffBlocks.candleColored, 1, 0),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 1),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 2),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 3),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 4),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 5),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 6),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 7),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 8),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 9),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 10),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 11),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 12),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 13),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 14),
			new ItemStack(CaveCliffBlocks.candleColored, 1, 15)));


	}
}
