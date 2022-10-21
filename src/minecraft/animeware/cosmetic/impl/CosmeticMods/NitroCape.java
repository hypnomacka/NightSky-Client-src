package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class NitroCape extends CosmeticModule {

	public NitroCape() {
		super("Nitro Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.NitroCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.NitroCape = false;
		//super.onDisable();
	}

}
