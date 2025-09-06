package luke.cavecliff.entity.glowsquid;

import luke.cavecliff.CaveCliffItems;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.animal.MobSquid;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class MobGlowSquid extends MobSquid {
	public MobGlowSquid(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("cavecliff", "glowsquid");
		this.setSize(0.95F, 0.95F);
		this.mobDrops.add(new WeightedRandomLootObject(CaveCliffItems.INKSAC_GLOW.getDefaultStack(), 1, 3));
	}


	public boolean canSpawnHere() {
		if (this.world.isDaytime()) {
			return false;
		}
		return this.world.checkIfAABBIsClear(this.bb);
	}

}
