package animeware.cosmetic.impl.CosmeticMods;

import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.cosmetic.CosmeticType;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class EnchGlint extends CosmeticModule {

	public EnchGlint() {
		super("Enchanting Glint Cosmetic", new ResourceLocation("Animeware/icons/blank.png"), CosmeticType.CAPE);
	}
	@Override
	public void onEnable() {
       Booleans.EnchantingGlint = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.EnchantingGlint = false;
		//super.onDisable();
	}

}
