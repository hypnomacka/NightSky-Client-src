package animeware.ui.comp;

import java.awt.Color;

import animeware.cosmetic.CosmeticModule;
import animeware.hud.mod.HudMod;
import animeware.ui.themes.impl.ThemeManager;
import animeware.util.font.FontUtil;
import animeware.util.render.ColorUtils;
import animeware.util.render.DrawUtil;
import animeware.util.render.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class CosmeticButton {
	
	public int x, y, w, h;
	public CosmeticModule m;
	private boolean enabled;
	boolean allowClick;
	boolean allowDraw;
	
	int width = GuiScreen.width;
	int height = GuiScreen.height;
	
	Minecraft mc = Minecraft.getMinecraft();
	
	public CosmeticButton(int x, int y, int w, int h, CosmeticModule m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
		this.enabled = false;
		
	}
	
	public void draw() {
		Gui.drawRect(x, y, x + w, y + h, new Color(0, 0, 0, 0).getRGB());
		//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 90, y + h, 18.0F, new Color(40, 40, 45, 255).getRGB());
		RoundedUtils.drawSmoothRoundedRect(x, y, x + w, y + h, 18.0F, new Color(50, 50, 55, 155).getRGB());  //70, 70, 75, 155
		if(m.isEnabled()) {
			if(ThemeManager.astolfoBtn == true) {
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 210, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 100L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 190, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 900L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 192, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 800L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 196, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 700L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 200, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 600L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 202, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 500L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 204, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 400L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 206, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 300L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 208, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 200L));
				
			} else {
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 288, y + h, 18.0F, new Color(0, 150, 200, 255).getRGB());
			}//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 190, y + h, 18.0F, new Color(0, 150, 200, 255).getRGB());
		//DrawUtil.drawRoundedRect(x - 1, y - 5, x + w + 1, y + h + 1, 7 , new Color(200, 0, 0, 100).getRGB());
		}else {
			RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 288, y + h, 18.0F, new Color(50, 50, 55, 255).getRGB());
		//DrawUtil.drawRoundedRect(x - 1, y - 5, x + w + 1, y + h + 1, 7 , new Color(105, 105, 105, 100).getRGB());
		}
		//DrawUtil.drawRoundedRect(x, y - 4, x + w, y + h, 7 , new Color(205, 205, 205, 0).getRGB());
		//DrawUtil.drawRoundedRect(x, y - 4, x + w, y + h, 7 , new Color(15, 15, 15, 255).getRGB());
        FontUtil.normal.drawString(m.name, x + 45, y + 16, getColor());
        //FontUtil.normal.drawString(m.description, x + 45, y + 25, new Color(70, 70, 75, 255).getRGB());
        if(!m.getIcon().getResourcePath().equals("")) {
        	DrawUtil.draw2DImage(m.getIcon(), x + 5, y + 5, 25, 25, Color.WHITE);
        }
        //GuiScreen.buttonList.add(new SettingsCGButton(2, 262, height / 3 - 10, ""));
        //Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation ("Animeware/background/logo.png"));
	}
	
	
	private int getColor() {
		if(m.isEnabled()) {
			return new Color(155, 155, 155, 250).getRGB();
		}else {
			return new Color(155, 155, 155, 250).getRGB();
		}

	}
	
	public void onClick(int mouseX, int mouseY, int Button) {
		if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y +h) {
			m.toggle();
			System.out.println(this.getModNameToggle());
		}		

	}
	private String getModNameToggle() {
		if(m.enabled) {
		return m.name + ": enabled";
		} else if(!m.enabled) {
			return m.name + ": disabled";
		}else {
			return m.name;
		}
	}
	private String getModName() {
		return m.name;
	}
	

}
