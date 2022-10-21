package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class CosmeticWitchHat extends CosmeticModule {

	public CosmeticWitchHat() {
		super("Witch Hat", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.HAT);
	}
	@Override
	public void onEnable() {
       Booleans.CosmeticWitchHat = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.CosmeticWitchHat = false;
		//super.onDisable();
	}

}
