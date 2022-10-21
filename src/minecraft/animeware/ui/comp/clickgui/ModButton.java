package animeware.ui.comp.clickgui;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animeware.gui.clickgui.ClickGUI;
import animeware.gui.clickgui.GUIType;
import animeware.gui.clickgui.SettingsGUI;
import animeware.hud.mod.HudMod;
import animeware.ui.themes.impl.ThemeManager;
import animeware.util.font.FontUtil;
import animeware.util.notification.Notification;
import animeware.util.notification.NotificationManager;
import animeware.util.notification.NotificationType;
import animeware.util.render.ColorUtils;
import animeware.util.render.DrawUtil;
import animeware.util.render.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class ModButton {
	
	public int x, y, w, h;
	public HudMod m;
	private boolean enabled;
	boolean allowClick;
	boolean allowDraw;
	public static boolean settings;
	
	int width = GuiScreen.width;
	int height = GuiScreen.height;
	
	Minecraft mc = Minecraft.getMinecraft();
	
	public ModButton(int x, int y, int w, int h, HudMod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
		this.enabled = false;
		
	}
	public ModButton() {
		
	}
	
	public void draw() {
		
		Gui.drawRect(x, y, x + w, y + h, new Color(0, 0, 0, 0).getRGB());
		//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 90, y + h, 18.0F, new Color(40, 40, 45, 255).getRGB());
		//RoundedUtils.drawSmoothRoundedRect(x, y, x + w, y + h, 18.0F, new Color(50, 50, 55, 155).getRGB());  //70, 70, 75, 155
		RoundedUtils.drawSmoothRoundedRect(x, y, x + w, y + h, 12.0F, new Color(26, 26, 26, 255).getRGB());
		RoundedUtils.drawSmoothRoundedRect(x + 105, y + 18, x + w -6, y + h - 18, 4.0F, new Color(40, 40, 40, 255).getRGB());
		if(m.isEnabled()) {
			if(ThemeManager.astolfoBtn == true) {
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 288, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 1000L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 290, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 900L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 292, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 800L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 296, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 700L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 300, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 600L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 302, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 500L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 304, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 400L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 306, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 300L));
				RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 308, y + h, 18.0F, ColorUtils.astolfoColors(10, 100, 200L));
				
			} else {
				this.drawCircle(x + 109, y + 16, 8, 8, new Color(0, 255, 255));
				
				//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 288, y + h, 18.0F, new Color(0, 150, 200, 255).getRGB());
				//RoundedUtils.drawRoundedGradientRectCorner(x, y, x + w - 190, y + h, 18.0F, new Color(0, 150, 200, 255).getRGB(), new Color(50, 100, 200, 255).getRGB(), new Color(100, 50, 200, 255).getRGB(), new Color(150, 0, 200, 255).getRGB());
				
			}
			//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 190, y + h, 18.0F, new Color(0, 150, 200, 255).getRGB());
			//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 190, y + h, 18.0F, new Color(0, 0, 0, 155).getRGB());
		//DrawUtil.drawRoundedRect(x - 1, y - 5, x + w + 1, y + h + 1, 7 , new Color(200, 0, 0, 100).getRGB());
		}else {
			this.drawCircle(x + 100, y + 16, 8, 8, new Color(100,100,100));
			//RoundedUtils.drawSmoothRoundedRect(x, y, x + w - 288, y + h, 18.0F, new Color(50, 50, 55, 255).getRGB());
		//DrawUtil.drawRoundedRect(x - 1, y - 5, x + w + 1, y + h + 1, 7 , new Color(105, 105, 105, 100).getRGB());
		}
		FontUtil.normal.drawString(m.name, x + 35, y + 12, getColor());
		FontUtil.normal.drawString("Description", x + 35, y + 23, new Color(70, 70, 75, 255).getRGB());
        //FontUtil.normal.drawString(m.description, x + 35, y + 23, new Color(70, 70, 75, 255).getRGB());
    	
        if(!m.getIcon().getResourcePath().equals("")) {
        	DrawUtil.draw2DImage(m.getIcon(), x + 5, y + 3, 30, 30, Color.WHITE);
        }
        /*int yAdd1 = 0;
        if(m.expanded)
        for (Setting set : m.settings) {

            if(set instanceof BooleanSetting) {
                ClickGUI.settingButtons.add(new SettingButton(this.width / 2 + 100, this.height / 2 - 90 + yAdd1, 60, 20, set));
                yAdd1 += 40;
            } 

        }*/
        
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
			if(Button == 0) {
			m.toggle();
			
			if(m.enabled) {
				NotificationManager.show(new Notification(NotificationType.SUCCESS, m.name, m.name + " was enabled.", m.icon, 1));
			} else if(!m.enabled) {
				NotificationManager.show(new Notification(NotificationType.FAIL, m.name, m.name + " was disabled.", m.icon, 1));
			}else {
				
			}
			
			System.out.println(this.getModNameToggle());
			}
			if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y +h) {
				if(Button == 1) {
					
					//ClickGUI.settings = true;
					//for(HudMod m : HudManager.hudMods) {
				//if(m.settings.size()>0)
				//m.expand();
				
					//}
				
				}
				if(Button == 1) {
					if(m.settings.size()>0 && m.name == "Color Scheme" || m.settings.size()>0 && m.name == "FPS")  //HitColor
					//if(!m.expanded) {
						//m.expand();
					//} else {
						//m.deexpand();
					//}
					
					
				    //mc.displayGuiScreen(new SettingsGUI(m, new ClickGUI(), x, y));
					//mc.displayGuiScreen(new SettingsGUI(m));
					ClickGUI.type = GUIType.SETTINGS;
					mc.displayGuiScreen(new ClickGUI(m));
					settings = true;
				  }
				
			}
			
	     }
		
	  

	}
	private String getModNameToggle() {
		//NotificationManager.show(new Notification(NotificationType.SUCCESS, name, name + " was enabled.", 1));
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
	
	private void drawArc(final int x, final int y, final int radius, final int startAngle, final int endAngle, final Color color) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0.0).endVertex();
        for (int i = (int)(startAngle / 360.0 * 100.0); i <= (int)(endAngle / 360.0 * 100.0); ++i) {
            final double angle = 6.283185307179586 * i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
	
	private void drawCircle(final int x, final int y, final int width, final int height, final Color color) {
        this.drawArc(x + width, y + height / 2, width / 2, 0, 360, color);
    }
	
}
