package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class QuavCape extends CosmeticModule {

	public QuavCape() {
		super("Quav Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.QuavCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.QuavCape = false;
		//super.onDisable();
	}

}
