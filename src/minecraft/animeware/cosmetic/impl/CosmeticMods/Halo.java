package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Halo extends CosmeticModule {

	public Halo() {
		super("Halo", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.HAT);
	}
	@Override
	public void onEnable() {
       Booleans.Halo = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Halo = false;
		//super.onDisable();
	}

}
