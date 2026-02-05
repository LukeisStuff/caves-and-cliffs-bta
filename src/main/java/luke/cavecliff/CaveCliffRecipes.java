package luke.cavecliff;

import luke.cavecliff.block.CaveCliffBlocks;
import luke.cavecliff.item.CaveCliffItems;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffRecipes implements RecipeEntrypoint {

    public void initializeRecipes() {

        RecipeBuilderShaped templateLogtoPlank = new RecipeBuilderShaped(MOD_ID, "X");
        templateLogtoPlank.addInput('X', CaveCliffBlocks.LOG_AZALEA).create("logAzaleaToPlanks", new ItemStack(Blocks.PLANKS_OAK_PAINTED, 4, 5));

        templateLogtoPlank.addInput('X', CaveCliffBlocks.BLOCK_MOSS).create("block_of_moss_to_moss_layer", new ItemStack(CaveCliffBlocks.MOSS_LAYER, 8));

        RecipeBuilderShaped templateItemtoBlock = new RecipeBuilderShaped(MOD_ID, "XXX", "XXX", "XXX");
        templateItemtoBlock.addInput('X', CaveCliffItems.AMETHYST).create("block_of_amethyst", new ItemStack(CaveCliffBlocks.AMETHYST, 1));
        templateItemtoBlock.addInput('X', CaveCliffItems.ORE_RAW_COPPER).create("block_of_raw_copper", new ItemStack(CaveCliffBlocks.BLOCK_COPPER_RAW, 1));
        templateItemtoBlock.addInput('X', Items.ORE_RAW_GOLD).create("block_of_raw_gold", new ItemStack(CaveCliffBlocks.BLOCK_GOLD_RAW, 1));
        templateItemtoBlock.addInput('X', Items.ORE_RAW_IRON).create("block_of_raw_iron", new ItemStack(CaveCliffBlocks.BLOCK_IRON_RAW, 1));

        RecipeBuilderShaped templateBricks = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
        templateBricks.addInput('X', CaveCliffItems.INGOT_COPPER).create("block_of_copper", new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1));
        templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, 0)).create("copper_bricks", new ItemStack(CaveCliffBlocks.BRICK_COPPER, 4, 0));
        templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, 1)).create("exposed_copper_bricks", new ItemStack(CaveCliffBlocks.BRICK_COPPER, 4, 1));
        templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, 2)).create("weathered_copper_bricks", new ItemStack(CaveCliffBlocks.BRICK_COPPER, 4, 2));
        templateBricks.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1, 3)).create("oxidized_copper_bricks", new ItemStack(CaveCliffBlocks.BRICK_COPPER, 4, 3));

        RecipeBuilderShaped templateStairs = new RecipeBuilderShaped(MOD_ID, "X ", "XX ", "XXX");
        templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 0)).create("copper_brick_stairs", new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 6, 0));
        templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 1)).create("exposed_copper_brick_stairs", new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 6, 16));
        templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 2)).create("weathered_copper_brick_stairs", new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 6, 32));
        templateStairs.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 3)).create("oxidized_copper_brick_stairs", new ItemStack(CaveCliffBlocks.STAIRS_BRICK_COPPER, 6, 48));

        RecipeBuilderShaped templateSlab = new RecipeBuilderShaped(MOD_ID, "XXX");
        templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 0)).create("copper_brick_slab", new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 6, 0));
        templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 1)).create("exposed_copper_brick_slab", new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 6, 16));
        templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 2)).create("weathered_copper_brick_slab", new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 6, 32));
        templateSlab.addInput('X', new ItemStack(CaveCliffBlocks.BRICK_COPPER, 1, 3)).create("oxidized_copper_brick_slab", new ItemStack(CaveCliffBlocks.SLAB_BRICK_COPPER, 6, 48));

        RecipeBuilderShaped templateBlockToItem = new RecipeBuilderShaped(MOD_ID, "X");
        templateBlockToItem.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER, 1)).create("copper_block_to_ingot", new ItemStack(CaveCliffItems.INGOT_COPPER, 4));
        templateBlockToItem.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_COPPER_RAW, 1)).create("block_of_raw_copper_to_raw_copper", new ItemStack(CaveCliffItems.ORE_RAW_COPPER, 9));
        templateBlockToItem.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_GOLD_RAW, 1)).create("block_of_raw_gold_to_raw_gold", new ItemStack(Items.ORE_RAW_GOLD, 9));
        templateBlockToItem.addInput('X', new ItemStack(CaveCliffBlocks.BLOCK_IRON_RAW, 1)).create("block_of_raw_iron_to_raw_iron", new ItemStack(Items.ORE_RAW_IRON, 9));

        RecipeBuilder.Shapeless(MOD_ID)
            .addInput(new ItemStack(CaveCliffItems.INKSAC_GLOW, 1))
            .create("glow_sac_to_cyan_dye", new ItemStack(Items.DYE, 2, 6));

        RecipeBuilder.Shapeless(MOD_ID)
            .addInput(new ItemStack(CaveCliffItems.INKSAC_GLOW, 1))
            .addInput(new ItemStack(Blocks.ALGAE, 1))
            .create("glow_lichen", new ItemStack(CaveCliffBlocks.LICHEN, 1));

        RecipeBuilder.Shaped(MOD_ID, "C", "C", "C")
            .addInput('C', CaveCliffItems.INGOT_COPPER)
            .create("lightning_rod", new ItemStack(CaveCliffBlocks.LIGHTNING_ROD, 2));

        RecipeBuilder.Shaped(MOD_ID, "S", "P", "E")
            .addInput('S', Items.STRING)
            .addInput('P', Items.PAPER)
            .create("candle", new ItemStack(CaveCliffBlocks.CANDLE, 4));

        for (int color = 0; color < 16; color++) {
            RecipeBuilder.Shaped(MOD_ID, "CCC", "CDC", "CCC")
                .addInput('C', "cavecliff:block/candles")
                .addInput('D', new ItemStack(Items.DYE, 1, 15 - color))
                .create("dyed_candle_dye", new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 8, color));
        }

        RecipeBuilder.Shaped(MOD_ID, "CC", "CC", "CC")
            .addInput('C', CaveCliffItems.INGOT_COPPER)
            .create("copper_door", new ItemStack(CaveCliffItems.DOOR_COPPER, 2));

        RecipeBuilder.Shaped(MOD_ID, "CCC", "CCC")
            .addInput('C', CaveCliffItems.INGOT_COPPER)
            .create("copper_trapdoor", new ItemStack(CaveCliffBlocks.TRAPDOOR_COPPER, 6));

        RecipeBuilder.Shaped(MOD_ID, "BCB", "BCB")
            .addInput('C', CaveCliffItems.INGOT_COPPER)
            .addInput('B', CaveCliffBlocks.BLOCK_COPPER)
            .create("copper_fence", new ItemStack(CaveCliffBlocks.FENCE_COPPER, 32));

        RecipeBuilder.Furnace(MOD_ID)
            .setInput(CaveCliffItems.ORE_RAW_COPPER)
            .create("copper_ingot", CaveCliffItems.INGOT_COPPER.getDefaultStack());

        RecipeBuilder.Furnace(MOD_ID)
            .setInput("cavecliff:block/copper_ores")
            .create("copper_ores_to_copper", CaveCliffItems.INGOT_COPPER.getDefaultStack());

        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput(CaveCliffItems.ORE_RAW_COPPER)
            .create("copper_ingot_blast", CaveCliffItems.INGOT_COPPER.getDefaultStack());

        RecipeBuilder.BlastFurnace(MOD_ID)
            .setInput("cavecliff:block/copper_ores")
            .create("copper_ores_to_copper_blast", CaveCliffItems.INGOT_COPPER.getDefaultStack());

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

        Registries.ITEM_GROUPS.getItem("minecraft:logs").add(CaveCliffBlocks.LOG_AZALEA.getDefaultStack());

        Registries.ITEM_GROUPS.getItem("minecraft:leaves").add(CaveCliffBlocks.LEAVES_AZALEA.getDefaultStack());
        Registries.ITEM_GROUPS.getItem("minecraft:leaves").add(CaveCliffBlocks.LEAVES_AZALEA_FLOWERING.getDefaultStack());

        Registries.ITEM_GROUPS.getItem("minecraft:dirt").add(CaveCliffBlocks.DIRT_ROOTED.getDefaultStack());
        Registries.ITEM_GROUPS.getItem("minecraft:trommel_dirt").add(CaveCliffBlocks.DIRT_ROOTED.getDefaultStack());

        Registries.ITEM_GROUPS.getItem("minecraft:moss_stones").add(CaveCliffBlocks.BLOCK_MOSS.getDefaultStack());

        Registries.ITEM_GROUPS.register("cavecliff:block/copper_ores",
            Registries.stackListOf(CaveCliffBlocks.ORE_COPPER_STONE, CaveCliffBlocks.ORE_COPPER_BASALT, CaveCliffBlocks.ORE_COPPER_GRANITE, CaveCliffBlocks.ORE_COPPER_LIMESTONE, CaveCliffBlocks.ORE_COPPER_PERMAFROST));

        Registries.ITEM_GROUPS.register("cavecliff:block/candles", Registries.stackListOf
            (CaveCliffBlocks.CANDLE,
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 0),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 1),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 2),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 3),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 4),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 5),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 6),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 7),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 8),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 9),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 10),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 11),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 12),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 13),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 14),
                new ItemStack(CaveCliffBlocks.CANDLE_COLORED, 1, 15)));


    }
}
