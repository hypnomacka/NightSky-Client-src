package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class Watermark extends HudMod {

	public Watermark() {
		super("Watermark", "Displays client watermark", new ResourceLocation("Animeware/icons/iconWhite.png"), 0, 0);
	}
	@Override
	public void onEnable() {
       Booleans.watermark = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
	  Booleans.watermark = false;
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
