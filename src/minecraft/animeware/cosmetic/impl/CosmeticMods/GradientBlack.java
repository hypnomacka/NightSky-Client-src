package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GradientBlack extends CosmeticModule {

	public GradientBlack() {
		super("GradientBlack Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.GradientBlack = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GradientBlack = false;
		//super.onDisable();
	}

}
