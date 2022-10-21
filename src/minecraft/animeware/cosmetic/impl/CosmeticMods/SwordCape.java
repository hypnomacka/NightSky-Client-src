package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class SwordCape extends CosmeticModule {

	public SwordCape() {
		super("Sword Cape", new ResourceLocation("Animeware/icons/cape.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.SwordCape = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.SwordCape = false;
		//super.onDisable();
	}

}
