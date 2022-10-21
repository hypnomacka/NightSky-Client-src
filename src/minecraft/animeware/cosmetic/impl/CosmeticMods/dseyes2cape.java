package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class dseyes2cape extends CosmeticModule {

	public dseyes2cape() {
		super("Demon eyes Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.dseyes2cape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.dseyes2cape = false;
		//super.onDisable();
	}

}
