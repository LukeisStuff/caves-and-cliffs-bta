package luke.cavecliff;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class CaveCliffMod implements ModInitializer, ClientStartEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "cavecliff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
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
