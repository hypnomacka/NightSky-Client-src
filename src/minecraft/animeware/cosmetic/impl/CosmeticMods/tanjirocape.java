package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class tanjirocape extends CosmeticModule {

	public tanjirocape() {
		super("tanjiro Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.tanjirocape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.tanjirocape = false;
		//super.onDisable();
	}

}
