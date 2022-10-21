package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class DevCape extends CosmeticModule {

	public DevCape() {
		super("Staff Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.DevCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.DevCape = false;
		//super.onDisable();
	}

}
