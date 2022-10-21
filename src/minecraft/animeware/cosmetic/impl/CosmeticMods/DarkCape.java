package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class DarkCape extends CosmeticModule {

	public DarkCape() {
		super("Dark Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.DarkCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.DarkCape = false;
		//super.onDisable();
	}

}
