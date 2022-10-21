package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Bandana extends CosmeticModule {

	public Bandana() {
		super("Bandana Cosmetic", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.BANDANA);
	}
	@Override
	public void onEnable() {
       Booleans.Bandana = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Bandana = false;
		//super.onDisable();
	}

}
