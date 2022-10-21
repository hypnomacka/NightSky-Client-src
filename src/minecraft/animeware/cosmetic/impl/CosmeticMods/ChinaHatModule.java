package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class ChinaHatModule extends CosmeticModule {

	public ChinaHatModule() {
		super("ChinaHat", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.HAT);
	}
	@Override
	public void onEnable() {
       Booleans.ChinaHat = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.ChinaHat = false;
		//super.onDisable();
	}

}
