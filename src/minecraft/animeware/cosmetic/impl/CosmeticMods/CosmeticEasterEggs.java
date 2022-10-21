package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class CosmeticEasterEggs extends CosmeticModule {

	public CosmeticEasterEggs() {
		super("Cosmetic Eggs", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.OTHER);
	}
	@Override
	public void onEnable() {
       Booleans.CosmeticEasterEggs = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.CosmeticEasterEggs = false;
		//super.onDisable();
	}

}
