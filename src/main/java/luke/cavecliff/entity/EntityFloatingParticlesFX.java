package luke.cavecliff.entity;

import net.minecraft.client.entity.fx.EntityLeafFX;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.world.World;

public class EntityFloatingParticlesFX
	extends EntityLeafFX {
	public EntityFloatingParticlesFX(World world, double x, double y, double z, double d3, double d4, double d5) {
		super(world, x, y, z, d3, d4, d5);
		this.particleTexture = TextureRegistry.getTexture("cavecliff:block/moss");
		this.particleGravity = 0.0025f;
		this.particleScale /= 2.0f;
		this.particleMaxAge = (int)((float)this.particleMaxAge * 16.0f);
		this.yd = 0.0;
		this.xd = 0.0;
		this.zd = 0.0;
	}

	@Override
	public void tick() {
		float windDirection = this.world.worldType.getWindManager().getWindDirection(this.world, (float)this.x, (float)this.y, (float)this.z);
		float windIntensity = this.world.worldType.getWindManager().getWindIntensity(this.world, (float)this.x, (float)this.y, (float)this.z) * 0.01f;
		float dx = ((float)(Math.cos((double)windDirection * Math.PI) * (double)windIntensity)) / 5;
		float dz = ((float)(Math.sin((double)windDirection * Math.PI) * (double)windIntensity)) / 5;
		this.xd += dx;
		this.zd += dz;
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.particleAge++ >= this.particleMaxAge) {
			this.remove();
		}
		this.yd -= 0.04 * (double)this.particleGravity;
		if (this.onGround) {
			this.xd *= 0.0;
			this.zd *= 0.0;
			this.remove();
		}
		this.move(this.xd, this.yd, this.zd);
	}

	public EntityFloatingParticlesFX func_4041_a(int i, int j, int k) {
		Block block = Block.blocksList[this.world.getBlockId(i, j, k)];
		if (!(block instanceof BlockLeavesBase)) {
			this.remove();
		}
		int l = BlockColorDispatcher.getInstance().getDispatch(block).getWorldColor(this.world, i, j, k);
		this.particleRed *= (float)(l >> 16 & 0xFF) / 255.0f;
		this.particleGreen *= (float)(l >> 8 & 0xFF) / 255.0f;
		this.particleBlue *= (float)(l & 0xFF) / 255.0f;
		return this;
	}

}
