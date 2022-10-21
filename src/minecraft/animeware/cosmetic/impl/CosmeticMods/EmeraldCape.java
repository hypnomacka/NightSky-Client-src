package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class EmeraldCape extends CosmeticModule {

	public EmeraldCape() {
		super("Emerald Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.EmeraldCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.EmeraldCape = false;
		//super.onDisable();
	}

}
