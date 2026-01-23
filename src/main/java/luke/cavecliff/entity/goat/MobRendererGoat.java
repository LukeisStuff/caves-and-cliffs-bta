package luke.cavecliff.entity.goat;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;

@Environment(EnvType.CLIENT)
public class MobRendererGoat extends MobRenderer<MobGoat> {
    public MobRendererGoat(ModelBase modelbase, float f) {
        super(modelbase, f);
    }
}
