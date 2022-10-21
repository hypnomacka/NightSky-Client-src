package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Glasses extends CosmeticModule {

	public Glasses() {
		super("Glasses", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.OTHER);
	}
	@Override
	public void onEnable() {
       Booleans.glasses = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.glasses = false;
		//super.onDisable();
	}

}
