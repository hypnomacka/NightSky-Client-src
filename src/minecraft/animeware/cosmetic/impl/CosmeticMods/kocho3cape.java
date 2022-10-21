package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class kocho3cape extends CosmeticModule {

	public kocho3cape() {
		super("Kocho Cape 2", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.kocho3cape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.kocho3cape = false;
		//super.onDisable();
	}

}
