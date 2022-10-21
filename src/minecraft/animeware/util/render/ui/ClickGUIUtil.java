package animeware.util.render.ui;

import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.lwjgl.opengl.GL11;

import animeware.NightSky;
import animeware.gui.clickgui.ClickGUI;
import animeware.ui.themes.impl.ThemeManager;
import animeware.util.font.ucfont.UCFontRenderer;
import animeware.util.render.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

public class ClickGUIUtil {
	
	Minecraft mc = Minecraft.getMinecraft();
	static UCFontRenderer fr = new UCFontRenderer(new ResourceLocation("Animeware/font/font.ttf"), 19.0f);
	
	public static void renderClickGUI() {
		if(ThemeManager.guilight) {
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 145), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 110), 18.0F, new Color(100, 100, 100, 255).getRGB());
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 - 150), (ClickGUI.height / 2 + 110), 18.0F, new Color(50, 50, 55, 200).getRGB());	    
			//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 + 90), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 110), 18.0F, new Color(150, 150, 155, 155).getRGB());
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 185), (ClickGUI.height / 2 - 74), (ClickGUI.width / 2 - 155), (ClickGUI.height / 2 - 72), 4.0F, new Color(100, 100, 105, 255).getRGB());
			
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 + 115), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 155), 18.0F, new Color(80, 80, 79, 255).getRGB());
		} else {
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 115), 12.0F, new Color(26, 24, 25, 255).getRGB());
			
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 184), (ClickGUI.height / 2 - 104), (ClickGUI.width / 2 - 90), (ClickGUI.height / 2 - 75), 12.0F, new Color(32, 32, 32, 255).getRGB());
		    
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 184), (ClickGUI.height / 2 - 68), (ClickGUI.width / 2 - 90), (ClickGUI.height / 2 + 72), 12.0F, new Color(32, 32, 32, 255).getRGB());
			
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 184), (ClickGUI.height / 2 + 79), (ClickGUI.width / 2 - 90), (ClickGUI.height / 2 + 109), 12.0F, new Color(32, 32, 32, 255).getRGB());
			
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 84), (ClickGUI.height / 2 - 104), (ClickGUI.width / 2 + 184), (ClickGUI.height / 2 - 86), 12.0F, new Color(32, 32, 32, 255).getRGB());

			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 84), (ClickGUI.height / 2 - 79), (ClickGUI.width / 2 + 184), (ClickGUI.height / 2 + 109), 12.0F, new Color(32, 32, 32, 255).getRGB());
			
			
			//0,255,255
			
			
			
			
			//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 145), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 110), 18.0F, new Color(25, 25, 30, 255).getRGB());
			//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 - 150), (ClickGUI.height / 2 + 110), 18.0F, new Color(50, 50, 55, 200).getRGB());
		    
			//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 185), (ClickGUI.height / 2 - 74), (ClickGUI.width / 2 - 155), (ClickGUI.height / 2 - 72), 4.0F, new Color(100, 100, 105, 255).getRGB());
			
			//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 + 115), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 155), 18.0F, new Color(25, 25, 30, 255).getRGB());
			
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime);
		
		fr.drawString(NightSky.mcname , ClickGUI.width / 2 - 150, ClickGUI.height / 2 + 83, new Color(255, 255, 254, 255).getRGB());
		fr.drawString(NightSky.rank() , ClickGUI.width / 2 - 150, ClickGUI.height / 2 + 94, -1);
		
		//Minecraft.getMinecraft().fontRendererObj.drawString("FPS" , ClickGUI.width / 2 + 164, ClickGUI.height / 2 + 125, new Color(255, 255, 254, 255).getRGB());
		//Minecraft.getMinecraft().fontRendererObj.drawString(Minecraft.getMinecraft().getDebugFPS() + "", ClickGUI.width / 2 + 144, ClickGUI.height / 2 + 125, new Color(255, 255, 254, 255).getRGB());	
		//Minecraft.getMinecraft().fontRendererObj.draw
		//Minecraft.getMinecraft().fontRendererObj.drawString(time , ClickGUI.width / 2 + 156, ClickGUI.height / 2 + 137, -1);
				
		NetworkPlayerInfo playerInfo = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID());
		if(playerInfo != null) {
			Minecraft.getMinecraft().getTextureManager().bindTexture(playerInfo.getLocationSkin());
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Gui.drawScaledCustomSizeModalRect(ClickGUI.width / 2 - 180, ClickGUI.height / 2 + 82, 8F, 8F, 8, 8, 24, 24, 64F, 64F);
		}
		
	}
	public static void renderCosmeticMenu() {
		if(ThemeManager.guilight) {
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 145), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 110), 18.0F, new Color(100, 100, 100, 255).getRGB());
		} else {
			RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 145), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 110), 18.0F, new Color(25, 25, 30, 255).getRGB());
		}
	}

}
