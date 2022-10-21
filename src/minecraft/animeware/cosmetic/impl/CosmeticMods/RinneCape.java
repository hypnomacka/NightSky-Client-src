package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class RinneCape extends CosmeticModule {

	public RinneCape() {
		super("Rinnegan Cape - a", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.ANIM);
	}
	@Override
	public void onEnable() {
       Booleans.RinneCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.RinneCape = false;
		//super.onDisable();
	}

}
