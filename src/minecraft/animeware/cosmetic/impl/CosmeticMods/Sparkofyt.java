package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Sparkofyt extends CosmeticModule {

	public Sparkofyt() {
		super("Sparkofyt cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.Sparkofyt = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Sparkofyt = false;
		//super.onDisable();
	}

}
