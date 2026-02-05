package luke.cavecliff.compat.aether;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.core.block.material.MaterialColor;
import org.spongepowered.asm.mixin.Mixins;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static net.minecraft.core.block.material.MaterialColor.registerManualBlockColor;

public class CaveCliffAetherMod implements PreLaunchEntrypoint, GameStartEntrypoint, RecipeEntrypoint {
    public static boolean IS_AETHER_LOADED = false;
    public static RecipeEntrypoint recipeEntrypointDelegate;

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();
        IS_AETHER_LOADED = loader.isModLoaded("aether");

        if (IS_AETHER_LOADED) {
            Mixins.addConfiguration("compat/cavecliff/aether/aether.mixins.json");

            try {

                recipeEntrypointDelegate = (RecipeEntrypoint) Class
                    .forName("luke.cavecliff.compat.aether.CaveCliffAetherRecipes")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void beforeGameStart() {
        if (IS_AETHER_LOADED) {
            CaveCliffAetherBlocks.init();
            CaveCliffAetherItems.init();
        }
    }

    @Override
    public void afterGameStart() {
        if (IS_AETHER_LOADED) {
            registerManualBlockColor(CaveCliffAetherBlocks.BLOCK_GRAVITITE_RAW, 0, MaterialColor.paintedPink);
        }
    }

    @Override
    public void onRecipesReady() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.onRecipesReady();
    }

    @Override
    public void initNamespaces() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.initNamespaces();
    }
}
