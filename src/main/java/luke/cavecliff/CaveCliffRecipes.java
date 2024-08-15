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
		templateItemtoBlock.addInput('X', CaveCliffItems.ingotCopper).create("block_of_copper", new ItemStack(CaveCliffBlocks.amethyst, 1));
		templateItemtoBlock.addInput('X', CaveCliffItems.oreRawCopper).create("block_of_raw_copper", new ItemStack(CaveCliffBlocks.blockCopperRaw, 1));
		templateItemtoBlock.addInput('X', Item.oreRawGold).create("block_of_raw_gold", new ItemStack(CaveCliffBlocks.blockGoldRaw, 1));
		templateItemtoBlock.addInput('X', Item.oreRawIron).create("block_of_raw_iron", new ItemStack(CaveCliffBlocks.blockIronRaw, 1));

		RecipeBuilderShaped templateBricks = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		templateBricks.addInput('X', CaveCliffBlocks.blockCopper).create("copper_bricks", new ItemStack(CaveCliffBlocks.brickCopper, 4));



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

		Registries.ITEM_GROUPS.register("cavecliff:block/copper_ores", Registries.stackListOf(CaveCliffBlocks.oreCopperStone, CaveCliffBlocks.oreCopperBasalt, CaveCliffBlocks.oreCopperGranite, CaveCliffBlocks.oreCopperLimestone));


	}
}
