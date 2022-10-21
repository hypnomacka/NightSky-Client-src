package animeware.hud.mod.Mods;

import animeware.hud.ScreenPosition;
import animeware.hud.mod.HudMod;
import net.minecraft.util.ResourceLocation;

public class ModParticles extends HudMod {

	public ModParticles() {
		super("No Particles", "Removes all particles", new ResourceLocation("Animeware/icons/quit.png"), 5, 5);
		// TODO Auto-generated constructor stub
	}

	private ScreenPosition pos;

	@Override
	public int getWidth() {
		
		return fr.getStringWidth("");
		
		
//Put Text here if wanted Must be same text as font.drawString ↑
				
				
		
	}

	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

	@Override
	public void draw() {
		//fr.drawStringWithShadow("", pos.getAbsoluteX() + getWidth() + 3, pos.getAbsoluteY() + 4, -1);
		
		//Put Text here if wanted Must be same text as font.drawString ↑
		
		this.mc.gameSettings.particleSetting = 10;
	
	
		
		return;
		
	}

}
