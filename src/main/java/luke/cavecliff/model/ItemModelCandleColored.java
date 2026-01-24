package luke.cavecliff.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class ItemModelCandleColored extends ItemModelStandard {
    public static IconCoordinate[] dyeIcons = new IconCoordinate[16];

    public ItemModelCandleColored(Item item, String namespace) {
        super(item, namespace);
    }

    @Override
    public @NotNull IconCoordinate getIcon(Entity entity, ItemStack itemStack) {
        int meta = itemStack.getMetadata();
        return dyeIcons[meta & 15];
    }

    static {
        DyeColor[] colors = DyeColor.itemOrderedColors().toArray(new DyeColor[0]);
        for (int i = 0; i < colors.length; i++) {
            DyeColor c = colors[i];
            dyeIcons[15 - i] = TextureRegistry.getTexture("cavecliff:item/candle_" + c.colorID);
        }
    }
}
