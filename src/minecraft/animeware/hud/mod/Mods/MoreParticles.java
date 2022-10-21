package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class MoreParticles extends HudMod {

	public MoreParticles() {
		super("MoreParticles", "Multiplies particles", new ResourceLocation("Animeware/icons/placeholder.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.MoreParticles = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.MoreParticles = false;
		//super.onDisable();
	}

}
