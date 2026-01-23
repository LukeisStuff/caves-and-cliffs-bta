package luke.cavecliff.compat.aether;

import net.minecraft.core.item.ItemStack;
import teamport.aether.item.AetherItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffAetherRecipes implements RecipeEntrypoint {

    @Override
    public void onRecipesReady() {
        RecipeBuilderShaped templateItemtoBlock = new RecipeBuilderShaped(MOD_ID, "XXX", "XXX", "XXX");
        templateItemtoBlock.addInput('X', AetherItems.ORE_RAW_GRAVITITE).create("block_of_raw_gravitite", new ItemStack(CaveCliffAetherBlocks.BLOCK_GRAVITITE_RAW, 1));
    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);

    }
}
