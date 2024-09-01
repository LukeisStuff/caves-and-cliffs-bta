package luke.cavecliff;

import luke.cavecliff.entity.EntityGlowSquid;
import luke.cavecliff.entity.EntityGoat;
import luke.cavecliff.world.CaveCliffBiomes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.EnumCreatureType;
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
			b.getSpawnableList(EnumCreatureType.waterCreature).add(new SpawnListEntry(EntityGlowSquid.class, 5));
			b.getSpawnableList(EnumCreatureType.creature).add(new SpawnListEntry(EntityGoat.class, 102));
		}
		CaveCliffSounds.init();
		LOGGER.info("Caves and Cliffs initialized.");
	}

	@Override
	public void beforeGameStart() {
		new CaveCliffBlocks().initializeBlocks();
		new CaveCliffItems().initilizeItems();
		new CaveCliffEntities().initializeEntities();
		new CaveCliffBiomes().initializeBiomes();
	}

	@Override
	public void afterGameStart() {
		new CaveCliffBlocks().initializeBlockDetails();

		MobInfoRegistry.register(EntityGoat.class, "guidebook.section.mob.goat.name", "guidebook.section.mob.goat.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.hornGoat), 1.0f, 1, 1)});

		MobInfoRegistry.register(EntityGlowSquid.class, "guidebook.section.mob.squid.glow.name", "guidebook.section.mob.squid.glow.desc",
			10, 10, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(CaveCliffItems.inkSacGlow, 1, 0), 1.0f, 1, 3)});

	}

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {

	}
}
