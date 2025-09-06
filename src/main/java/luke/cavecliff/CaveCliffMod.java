package luke.cavecliff;

import luke.cavecliff.entity.axolotl.MobAxolotl;
import luke.cavecliff.entity.glowsquid.MobGlowSquid;
import luke.cavecliff.entity.goat.MobGoat;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.MobCategory;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "cavecliff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		for (Biome b : Registries.BIOMES) {
			b.getSpawnableList(MobCategory.waterCreature).add(new SpawnListEntry(MobGlowSquid.class, 5));
			b.getSpawnableList(MobCategory.waterCreature).add(new SpawnListEntry(MobAxolotl.class, 25));
			b.getSpawnableList(MobCategory.creature).add(new SpawnListEntry(MobGoat.class, 102));
		}

		LOGGER.info("Caves and Cliffs initialized.");
	}

	@Override
	public void beforeGameStart() {
		CaveCliffConfig.Setup();
		new CaveCliffBlocks().initializeBlocks();
		new CaveCliffItems().initilizeItems();
		CaveCliffEntities.init();
	}

	@Override
	public void afterGameStart() {
		new CaveCliffBlocks().initializeBlockDetails();

		MobInfoRegistry.register(MobGoat.class, "guidebook.section.mob.goat.name", "guidebook.section.mob.goat.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.HORN_GOAT), 1.0f, 0, 2)});

		MobInfoRegistry.register(MobGlowSquid.class, "guidebook.section.mob.squid.glow.name", "guidebook.section.mob.squid.glow.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.INKSAC_GLOW, 1, 0), 1.0f, 1, 3)});

		MobInfoRegistry.register(MobAxolotl.class, "guidebook.section.mob.axolotl.name", "guidebook.section.mob.axolotl.desc",
			8, 500, null);

	}

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {
	}
}
