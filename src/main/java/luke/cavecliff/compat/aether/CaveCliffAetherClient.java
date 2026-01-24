package luke.cavecliff.compat.aether;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

import static luke.cavecliff.compat.aether.CaveCliffAetherMod.IS_AETHER_LOADED;

public class CaveCliffAetherClient implements ModelEntrypoint {
    public static ModelEntrypoint modelEntrypointDelegate;

    static  {
        if (IS_AETHER_LOADED) {
            try {

                modelEntrypointDelegate = (ModelEntrypoint) Class
                    .forName("luke.cavecliff.compat.aether.CaveCliffAetherModels")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntrypointDelegate.initBlockColors(dispatcher);
    }

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntrypointDelegate.initBlockModels(dispatcher);
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntrypointDelegate.initItemModels(dispatcher);
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntrypointDelegate.initEntityModels(dispatcher);
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntrypointDelegate.initTileEntityModels(dispatcher);
    }
}
