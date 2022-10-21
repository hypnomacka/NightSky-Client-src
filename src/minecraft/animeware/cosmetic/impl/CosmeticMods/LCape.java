package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class LCape extends CosmeticModule {

	public LCape() {
		super("L Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.LCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.LCape = false;
		//super.onDisable();
	}

}
