package luke.cavecliff;

import luke.cavecliff.entity.EntityGlowSquid;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.enums.EnumCreatureType;
import net.minecraft.core.world.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "cavecliff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	static {
		SoundHelper.addStreaming(MOD_ID, "otherside.ogg");
	}

	@Override
	public void onInitialize() {
		for (Biome b : Registries.BIOMES) {
			b.getSpawnableList(EnumCreatureType.waterCreature).add(new SpawnListEntry(EntityGlowSquid.class, 5));
		}
		LOGGER.info("Caves and Cliffs initialized.");
	}

	@Override
	public void beforeGameStart() {
		new CaveCliffBlocks().initializeBlocks();
		new CaveCliffItems().initilizeItems();
		new CaveCliffEntities().initializeEntities();
	}

	@Override
	public void afterGameStart() {
		new CaveCliffBlocks().initializeBlockDetails();
	}

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {

	}
}
