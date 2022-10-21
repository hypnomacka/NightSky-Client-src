package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Sparkofyt2 extends CosmeticModule {

	public Sparkofyt2() {
		super("Sparkofyt cape 2", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.Sparkofyt2 = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Sparkofyt2 = false;
		//super.onDisable();
	}

}
