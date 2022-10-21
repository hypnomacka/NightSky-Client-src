package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GradientGreen extends CosmeticModule {

	public GradientGreen() {
		super("GradientGreen Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.GradientGreen = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GradientGreen = false;
		//super.onDisable();
	}

}
