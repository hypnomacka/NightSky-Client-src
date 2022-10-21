package animeware.hud.mod.Mods;

import animeware.cosmetic.Booleans;
import animeware.hud.mod.HudMod;
import animeware.util.settings.ModeSetting;
import net.minecraft.util.ResourceLocation;

public class BlockOverlay extends HudMod {

	public ModeSetting color = new ModeSetting("Color", "White", "White", "Blue", "Cyan", "Red", "Purple", "Chroma");
	
	public BlockOverlay() {
		super("BlockOverlay", "Shows overlay over blocks", new ResourceLocation("Animeware/icons/blockoverlay.png"), 0, 0);
		this.addSettings(color);
	}
	@Override
	public void onEnable() {
		if(color.getMode().equals("Blue")) {
			Booleans.BlockOverlayBlue = true;
			//fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			Booleans.BlockOverlayCyan = true;
			//fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			Booleans.BlockOverlayRed = true;
			//fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			Booleans.BlockOverlayPurple = true;
			//fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			Booleans.BlockOverlayChroma = true;
			//ChromaString.drawChromaString("[FPS:" + mc.getDebugFPS() + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			Booleans.BlockOverlayWhite = true;
			//fr.drawStringWithShadow("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		}
       //NightSky.BlockOverlayWhite = true;
		//super.onEnable();
	}
	@Override
	public void onDisable() {
		if(color.getMode().equals("Blue")) {
			Booleans.BlockOverlayBlue = false;
			//fr.drawStringWithShadow("§8[§1FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);			
		} else if(color.getMode().equals("Cyan")) {
			Booleans.BlockOverlayCyan = false;
			//fr.drawStringWithShadow("§8[§bFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Red")) {
			Booleans.BlockOverlayRed = false;
			//fr.drawStringWithShadow("§8[§4FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Purple")) {
			Booleans.BlockOverlayPurple = false;
			//fr.drawStringWithShadow("§8[§5FPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		} else if(color.getMode().equals("Chroma")) {
			Booleans.BlockOverlayChroma = false;
			//ChromaString.drawChromaString("[FPS:" + mc.getDebugFPS() + "]", getX(), getY(), -1);
		} else if(color.getMode().equals("White")) {
			Booleans.BlockOverlayWhite = false;
			//fr.drawStringWithShadow("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		}//super.onDisable();
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
