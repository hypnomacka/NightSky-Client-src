package animeware.hud;

import java.awt.Color;
import java.io.IOException;

import animeware.NightSky;
import animeware.gui.clickgui.ClickGUI;
import animeware.gui.mainmenu.ClassicButton;
import animeware.hud.mod.HudMod;
import animeware.util.render.DrawUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class HUDConfigScreen extends GuiScreen {
	
	private HudMod m;
	boolean hovered;
	
	@Override
	public void initGui() {
		super.initGui();
		mc.entityRenderer.loadShader(new ResourceLocation("Animeware/blur.json"));
		//Minecraft.getMinecraft().entityhudMod..loadShader(new ResourceLocation("shaders/post/blur.json"));
		this.buttonList.add(new ClassicButton(69, this.width / 2 - 50, this.height / 2 - 10, 100, 20, "Open GUI"));
		//this.buttonList.add(new ClassicButton(70, this.width / 2 - 50, this.height / 2 + 12, 100, 20, "Jus test"));
		//this.buttonList.add(new ClassicButton(71, this.width / 2 - 50, this.height / 2 + 32, 100, 20, "Open Cosmetics"));
	}
		
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//this.drawHollowRect(m.getX(), m.getY(), m.getWidth(), m.getHeight(), -1);
		//HudMod m = new HudMod(m.name, m.description, m.icon, m.getX(), m.getY());
		//super.drawDefaultBackground();
		//this.drawHollowRect(m.getX(), m.getY(), m.getWidth(), m.getHeight(), -1);
		//Gui.drawRect(m.getY(), partialTicks, m.getX(), partialTicks, mouseY);
		//mc.getTextureManager().bindTexture(new ResourceLocation ("Animeware/nightskywhite.png"));
		//this.drawModalRectWithCustomSizedTexture(355, 70, 0, 0, 250, 250, 250, 250);	
		
		//DrawUtil.draw2DImage(new ResourceLocation("Animeware/nightskywhite.png"), this.width / 2 - 35, this.height / 2 - 90, 70, 70, Color.WHITE);
		DrawUtil.draw2DImage(new ResourceLocation("Animeware/logonobg.png"), this.width / 2 - 59, this.height / 2 - 117, 117, 115, Color.WHITE);
		
		for(HudMod m : NightSky.INSTANCE.hudManager.hudMods) {
			if(m.isEnabled()) {
			m.renderDummy(mouseX, mouseY);
			if(m.getWidth() == 0|| m.getHeight() == 0) {
				
			} else {
			this.drawHollowRect(m.getX(), m.getY(), m.getWidth(), m.getHeight(), -1);
			}
			}
		}
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		switch(button.id) {
		case 69:
			mc.displayGuiScreen(new ClickGUI());
			break;
		
		/*case 71:                                            //VYRIESIT!!!!!
			mc.displayGuiScreen(new CosmeticGUI());
			break;*/
		}
	}
	public void drawHollowRect(int x, int y, int w, int h, int color) {

        this.drawHorizontalLine(x, x + w, y, color);
        this.drawHorizontalLine(x, x + w, y + h, color);

        this.drawVerticalLine(x, y + h, y, color);
        this.drawVerticalLine(x + w, y + h, y, color);

    }
	public static void drawOutlinedRect(int left, int top, int right, int bottom, int rectColor, int outlineColor) {
		Gui gui = new Gui();
    	gui.drawRect(left + 1, top, right - 1, bottom, rectColor);
    	gui.drawHorizontalLine(left, right - 1, top, outlineColor);
    	gui.drawHorizontalLine(left, right - 1, bottom, outlineColor);
    	gui.drawVerticalLine(left, top, bottom, outlineColor);
    	gui.drawVerticalLine(right - 1, top, bottom, outlineColor);
    }
	@Override
    public void onGuiClosed() {
        super.onGuiClosed();
        mc.entityRenderer.stopUseShader();
    }

}
