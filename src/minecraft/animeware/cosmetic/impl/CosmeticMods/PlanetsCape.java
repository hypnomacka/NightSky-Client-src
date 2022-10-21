package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class PlanetsCape extends CosmeticModule {

	public PlanetsCape() {
		super("Planets Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.PlanetsCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.PlanetsCape = false;
		//super.onDisable();
	}

}
