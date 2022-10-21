package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class GalaxyWings extends CosmeticModule {

	public GalaxyWings() {
		super("Galaxy Wings", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.WINGS);
	}
	@Override
	public void onEnable() {
       Booleans.GalaxyWings = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.GalaxyWings = false;
		//super.onDisable();
	}

}
