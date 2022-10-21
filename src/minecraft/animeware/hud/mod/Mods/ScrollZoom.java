package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class ScrollZoom extends HudMod {

	public ScrollZoom() {
		super("ScrollZoom", "Multiplies zoom by scrolling", new ResourceLocation("Animeware/icons/search.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.ScrollZoom = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.ScrollZoom = false;
		//super.onDisable();
	}
	@Override
	public int getWidth() {
		return 0;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}

}
