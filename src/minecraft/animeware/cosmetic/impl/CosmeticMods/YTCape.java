package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class YTCape extends CosmeticModule {

	public YTCape() {
		super("YT Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.YTCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.YTCape = false;
		//super.onDisable();
	}

}
