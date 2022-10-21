package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class RetardEyes extends CosmeticModule {

	public RetardEyes() {
		super("Retard Eyes", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.OTHER);
	}
	@Override
	public void onEnable() {
       Booleans.retardEyes = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.retardEyes = false;
		//super.onDisable();
	}

}
