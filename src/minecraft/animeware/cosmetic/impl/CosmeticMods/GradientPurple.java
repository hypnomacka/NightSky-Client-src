package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GradientPurple extends CosmeticModule {

	public GradientPurple() {
		super("GradientPurple Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.GradientPurple = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GradientPurple = false;
		//super.onDisable();
	}

}
