package luke.cavecliff;

import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.client.sound.SoundRepository;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "cavecliff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Material copper;

	@Override
	public void onInitialize() {
		LOGGER.info("Caves and Cliffs initialized.");
	}

	@Override
	public void beforeGameStart() {
		copper = (new Material(MaterialColor.paintedOrange)).setConductivity(99999999).setAsMetal().notAlwaysDestroyable();

		SoundTypes.loadSoundsJson(MOD_ID);
		CaveCliffConfig.Setup();
		new CaveCliffBlocks().initializeBlocks();
		new CaveCliffItems().initilizeItems();
		CaveCliffEntities.init();

	}

	@Override
	public void afterGameStart() {
		new CaveCliffBlocks().initializeBlockDetails();
	}

	@Override
	public void beforeClientStart() {
		SoundRepository.registerNamespace(MOD_ID);
		new CaveCliffClient().initializeParticles();
	}

	@Override
	public void afterClientStart() {
		MobInfoRegistry.register(MobGoat.class, "guidebook.section.mob.goat.name", "guidebook.section.mob.goat.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.HORN_GOAT), 1.0f, 0, 2)});

		MobInfoRegistry.register(MobGlowSquid.class, "guidebook.section.mob.squid.glow.name", "guidebook.section.mob.squid.glow.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.INKSAC_GLOW, 1, 0), 1.0f, 1, 3)});

		MobInfoRegistry.register(MobAxolotl.class, "guidebook.section.mob.axolotl.name", "guidebook.section.mob.axolotl.desc",
			8, 500, null);
	}

}
