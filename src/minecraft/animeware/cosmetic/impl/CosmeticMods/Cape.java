package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Cape extends CosmeticModule {

	public Cape() {
		super("ZeroTwo Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.Cape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Cape = false;
		//super.onDisable();
	}

}
