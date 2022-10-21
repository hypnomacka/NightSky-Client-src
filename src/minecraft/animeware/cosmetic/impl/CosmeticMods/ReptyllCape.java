package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class ReptyllCape extends CosmeticModule {

	public ReptyllCape() {
		super("Reptyll Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.ReptyllCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.ReptyllCape = false;
		//super.onDisable();
	}

}
