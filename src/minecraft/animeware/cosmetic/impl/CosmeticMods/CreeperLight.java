package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class CreeperLight extends CosmeticModule {

	public CreeperLight() {
		super("Creeper Lightning Cosmetic", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.OTHER);
	}
	@Override
	public void onEnable() {
       Booleans.CreeperLightning = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.CreeperLightning = false;
		//super.onDisable();
	}

}
