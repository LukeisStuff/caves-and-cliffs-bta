package luke.cavecliff.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ItemModelDoorCopper extends ItemModelStandard {
    protected IconCoordinate clean = TextureRegistry.getTexture("cavecliff:item/door_copper");
    protected IconCoordinate exposed = TextureRegistry.getTexture("cavecliff:item/door_copper_exposed");
    protected IconCoordinate weathered = TextureRegistry.getTexture("cavecliff:item/door_copper_weathered");
    protected IconCoordinate oxidized = TextureRegistry.getTexture("cavecliff:item/door_copper_oxidized");

    public ItemModelDoorCopper(Item item, String namespace) {
        super(item, namespace);
    }

    @Override
    public @NotNull IconCoordinate getIcon(@Nullable Entity entity, ItemStack itemStack) {
        if (itemStack.getMetadata() == 1) {
            return this.exposed;
        }
        if (itemStack.getMetadata() == 2) {
            return this.weathered;
        }
        if (itemStack.getMetadata() == 3) {
            return this.oxidized;
        }
        return clean;
    }
}
