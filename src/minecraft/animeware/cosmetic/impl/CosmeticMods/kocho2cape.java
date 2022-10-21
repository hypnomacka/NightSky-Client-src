package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class kocho2cape extends CosmeticModule {

	public kocho2cape() {
		super("Kocho Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.kocho2cape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.kocho2cape = false;
		//super.onDisable();
	}

}
