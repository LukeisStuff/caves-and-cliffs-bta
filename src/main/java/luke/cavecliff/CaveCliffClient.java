package luke.cavecliff;

import luke.cavecliff.entity.ParticleFallingSpore;
import luke.cavecliff.entity.ParticleFloatingSpore;
import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import luke.cavecliff.item.CaveCliffItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.entity.particle.ParticleDispatcher;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.client.sound.SoundRepository;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import static luke.cavecliff.CaveCliffMod.LOGGER;
import static luke.cavecliff.CaveCliffMod.MOD_ID;

public class CaveCliffClient implements ClientModInitializer, ClientStartEntrypoint {

    @Override
    public void beforeClientStart() {
        SoundRepository.registerNamespace(MOD_ID);

        ParticleDispatcher dispatcher = ParticleDispatcher.getInstance();

        dispatcher.addDispatch("sporeFall", (world, x, y, z, xa, ya, za, id) -> new ParticleFallingSpore(world, x, y, z, xa, ya, za));
        dispatcher.addDispatch("sporeFly", (world, x, y, z, xa, ya, za, id) -> new ParticleFloatingSpore(world, x, y, z, xa, ya, za));
    }

    @Override
    public void afterClientStart() {

        MobInfoRegistry.register(MobGoat.class, "guidebook.section.mob.goat.mountain.name", "guidebook.section.mob.goat.mountain.desc",
            10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.HORN_GOAT), 1.0f, 0, 2)});

        MobInfoRegistry.register(MobGlowSquid.class, "guidebook.section.mob.squid.glow.name", "guidebook.section.mob.squid.glow.desc",
            10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.INKSAC_GLOW, 1, 0), 1.0f, 1, 3)});

        MobInfoRegistry.register(MobAxolotl.class, "guidebook.section.mob.axolotl.name", "guidebook.section.mob.axolotl.desc",
            8, 500, null);
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Cave and Cliff client initialized.");
    }
}
