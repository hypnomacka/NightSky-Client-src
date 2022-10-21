package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GradientRed extends CosmeticModule {

	public GradientRed() {
		super("GradientRed Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.GradientRed = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GradientRed = false;
		//super.onDisable();
	}

}
