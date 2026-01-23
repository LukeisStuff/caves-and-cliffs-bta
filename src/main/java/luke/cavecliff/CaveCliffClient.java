package luke.cavecliff;

import luke.cavecliff.entity.ParticleFallingSpore;
import luke.cavecliff.entity.ParticleFloatingSpore;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.entity.particle.ParticleDispatcher;

@Environment(EnvType.CLIENT)
public class CaveCliffClient {
    public void initializeParticles() {
        ParticleDispatcher dispatcher = ParticleDispatcher.getInstance();

		dispatcher.addDispatch("sporeFall", (world, x, y, z, xa, ya, za, id) -> new ParticleFallingSpore(world, x, y, z, xa, ya, za));
		dispatcher.addDispatch("sporeFly", (world, x, y, z, xa, ya, za, id) -> new ParticleFloatingSpore(world, x, y, z, xa, ya, za));
    }
}
