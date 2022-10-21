package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class dseyescape extends CosmeticModule {

	public dseyescape() {
		super("Demon eyes Cape 2", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.dseyescape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.dseyescape = false;
		//super.onDisable();
	}

}
