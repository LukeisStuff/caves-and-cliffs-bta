package luke.cavecliff;

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


	}
}
