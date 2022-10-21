package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class QuickCape extends CosmeticModule {

	public QuickCape() {
		super("Quick Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.QuickCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.QuickCape = false;
		//super.onDisable();
	}

}
