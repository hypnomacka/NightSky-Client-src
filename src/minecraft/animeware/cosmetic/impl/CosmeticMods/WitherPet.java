package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class WitherPet extends CosmeticModule {

	public WitherPet() {
		super("Wither Pet", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.PET);
	}
	@Override
	public void onEnable() {
       Booleans.Witherpet = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.Witherpet = false;
		//super.onDisable();
	}

}
