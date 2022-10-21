package animeware.ui.comp.clickgui;

import animeware.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class SettingFrame extends GuiScreen {
	
	int x, y, width, height;
	int mouseX, mouseY;
	
	Minecraft mc = Minecraft.getMinecraft();
	//public static VoyageFontFromAsset font = new VoyageFontFromAsset(new ResourceLocation("Voyage/font/AntipastoPro-DemiBold_trial.ttf"), 23.0F);
	
	public SettingFrame(HudMod mod, int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 395;
		this.height = 300;
	}
		
	
	public void render(int mouseX, int mouseY) {
		//DrawUtil.drawRoundedRect(x, y, x + width, y + height, 10, new Color(0, 0, 0, 75).getRGB());
	}
}