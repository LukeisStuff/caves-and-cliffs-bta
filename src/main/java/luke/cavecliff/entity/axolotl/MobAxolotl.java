package luke.cavecliff.entity.axolotl;

import net.minecraft.core.entity.animal.MobWaterAnimal;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class MobAxolotl extends MobWaterAnimal {
	public MobAxolotl(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("cavecliff", "axolotl");
		this.setSize(0.5f, 0.5f);
		this.moveSpeed = 1.1f;
		this.scoreValue = 500;
	}

	@Override
	public String getLivingSound() {
		return "cavecliff.axolotlidle";
	}

	@Override
	public String getHurtSound() {
		return "cavecliff.axolotlhurt";
	}

	@Override
	public String getDeathSound() {
		return "cavecliff.axolotldeath";
	}

	@Override
	public float getSoundVolume() {
		return 0.8f;
	}


}
