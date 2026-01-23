package luke.cavecliff.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.entity.particle.ParticleLeaf;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLeavesBase;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;

@Environment(EnvType.CLIENT)
public class ParticleFallingSpore extends ParticleLeaf {
    public ParticleFallingSpore(World world, double x, double y, double z, double d3, double d4, double d5) {
        super(world, x, y, z, d3, d4, d5);
        this.tex = TextureRegistry.getTexture("cavecliff:block/moss");
        this.gravity = 0.05f;
        this.size /= 2.0f;
        this.lifetime = (int) ((float) this.lifetime * 16.0f);
        this.yd = 0.0;
        this.xd = 0.0;
        this.zd = 0.0;
    }

    @Override
    public void tick() {
        float windDirection = this.world.worldType.getWindManager().getWindDirection(this.world, (float) this.x, (float) this.y, (float) this.z);
        float windIntensity = this.world.worldType.getWindManager().getWindIntensity(this.world, (float) this.x, (float) this.y, (float) this.z) * 0.01f;
        float dx = (float) (Math.cos((double) windDirection * Math.PI * 2.0) * (double) windIntensity);
        float dz = (float) (Math.sin((double) windDirection * Math.PI * 2.0) * (double) windIntensity);
        this.xd += dx;
        this.zd += dz;
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        this.yd -= 0.04 * (double) this.gravity;
        if (this.onGround) {
            this.xd *= 0.0;
            this.zd *= 0.0;
            this.remove();
        }
        this.move(this.xd, this.yd, this.zd);
    }

    @Override
    public ParticleFallingSpore init(int x, int y, int z) {
        Block<?> block = Blocks.blocksList[this.world.getBlockId(x, y, z)];
        if (!Block.hasLogicClass(block, BlockLogicLeavesBase.class)) {
            this.remove();
        }

        int col = BlockColorDispatcher.getInstance().getDispatch(block).getWorldColor(this.world, x, y, z);
        this.rCol *= (float) (col >> 16 & 255) / 255.0F;
        this.gCol *= (float) (col >> 8 & 255) / 255.0F;
        this.bCol *= (float) (col & 255) / 255.0F;
        return this;
    }

}
