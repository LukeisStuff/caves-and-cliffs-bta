package luke.cavecliff.mixin;

import luke.cavecliff.CaveCliffBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLightningBolt;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityLightningBolt.class, remap = false)
public abstract class EntityLightningBoltMixin extends Entity {

	public EntityLightningBoltMixin(World world) {
		super(world);
	}

	@Inject(method = "spawnInit", at = @At(value = "TAIL", target = "Lnet/minecraft/core/entity/EntityLightningBolt;spawnInit()V"), cancellable = true)
	public void spawnInit(CallbackInfo ci) {
		int k;
		int j;
		int i;
		int i1;
		if (this.world.difficultySetting >= 2 && this.world.areBlocksLoaded(MathHelper.floor_double(this.x), MathHelper.floor_double(this.y), MathHelper.floor_double(this.z), 10)) {
			i = MathHelper.floor_double(this.x);
			j = MathHelper.floor_double(this.y);
				if (this.world.getBlockId(i, k = MathHelper.floor_double(this.y), i1 = MathHelper.floor_double(this.z)) == 0 && Block.fire.canPlaceBlockAt(this.world, i, k, i1)) {
					int blockToStrike = world.getBlockId(i, j, i1);
					if (blockToStrike == CaveCliffBlocks.lightningRod.id) {
					this.world.setBlockWithNotify(i, k + 1, i1, Block.fire.id);
				}
				for (j = 0; j < 4; ++j) {
					int k1;
					int j1;
					int l = MathHelper.floor_double(this.x) + this.random.nextInt(3) - 1;
					if (this.world.getBlockId(l, j1 = MathHelper.floor_double(this.y) + this.random.nextInt(3) - 1, k1 = MathHelper.floor_double(this.z) + this.random.nextInt(3) - 1) != 0 || !Block.fire.canPlaceBlockAt(this.world, l, j1, k1) || (blockToStrike == CaveCliffBlocks.lightningRod.id))
						continue;
					this.world.setBlockWithNotify(l, j1, k1, Block.fire.id);
				}
			}
		}
		ci.cancel();
	}
}
