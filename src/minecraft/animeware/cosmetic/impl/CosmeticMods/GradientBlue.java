package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GradientBlue extends CosmeticModule {

	public GradientBlue() {
		super("GradientBlue Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.GradientBlue = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GradientBlue = false;
		//super.onDisable();
	}

}
