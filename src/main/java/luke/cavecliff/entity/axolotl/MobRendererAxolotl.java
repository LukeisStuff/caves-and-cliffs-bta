package luke.cavecliff.entity.axolotl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;

@Environment(EnvType.CLIENT)
public class MobRendererAxolotl extends MobRenderer<MobAxolotl> {
    public MobRendererAxolotl(ModelBase modelbase, float f) {
        super(modelbase, f);
    }
}
