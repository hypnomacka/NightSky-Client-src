package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class DragonWings extends CosmeticModule {

	public DragonWings() {
		super("Dragon Wings", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.WINGS);
	}
	@Override
	public void onEnable() {
       Booleans.CosmeticWings = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.CosmeticWings = false;
		//super.onDisable();
	}

}
