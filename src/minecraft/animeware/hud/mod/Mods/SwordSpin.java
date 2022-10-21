package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class SwordSpin extends HudMod {

	public SwordSpin() {
		super("SwordSpin", "Spins your sword while blocking", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.SwordSpin = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.SwordSpin = false;
		//super.onDisable();
	}

}
