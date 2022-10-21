package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import animeware.util.websockets.SocketClient;
import net.minecraft.util.ResourceLocation;

public class OwnerCape extends CosmeticModule {

	public OwnerCape() {
		super("Owner Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
	Booleans.OwnerCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.OwnerCape = false;
		//super.onDisable();
	}

}
