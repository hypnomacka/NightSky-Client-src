package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class CrystalWings extends CosmeticModule {

	public CrystalWings() {
		super("Crystal Wings", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.WINGS);
	}
	@Override
	public void onEnable() {
       Booleans.CrystalWings = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.CrystalWings = false;
		//super.onDisable();
	}

}
