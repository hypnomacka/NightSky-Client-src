package animeware.hud.mod.Mods;

import org.lwjgl.opengl.GL11;

import animeware.hud.ScreenPosition;
import animeware.hud.mod.HudMod;
import animeware.util.render.DrawUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

public class PlayerHead extends HudMod {
			
	public PlayerHead() {
		super("PlayerHead", "Face of your skin", new ResourceLocation("Animeware/icons/placeholder.png"), 85, 5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 20;
	}

	@Override
	public void draw() {
		NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
		if(playerInfo != null) {
			mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Gui.drawScaledCustomSizeModalRect(getX(), getY(), 8F, 8F, 8, 8, 20, 20, 64F, 64F);
		}
	}
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		//fr.drawStringWithShadow("§8[§fFPS:§f" + mc.getDebugFPS() + "§8]", getX(), getY(), -1);
		NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
		if(playerInfo != null) {
			mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Gui.drawScaledCustomSizeModalRect(getX(), getY(), 8F, 8F, 8, 8, 20, 20, 64F, 64F);
		}
		super.renderDummy(mouseX, mouseY);
	}
	
}

