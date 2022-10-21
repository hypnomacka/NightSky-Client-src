package animeware.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import animeware.NightSky;
import animeware.gui.clickgui.ClickGUI;
import animeware.gui.mainmenu.QuitButton;
import animeware.hud.Category;
import animeware.hud.DraggableComponent;
import animeware.hud.mod.HudMod;
import animeware.hud.mod.Module;
import animeware.ui.comp.CosmeticButton;
import animeware.ui.comp.clickgui.ModButton;
import animeware.ui.comp.clickgui.SettingButton;
import animeware.ui.login.LoginScreen;
import animeware.util.notification.Notification;
import animeware.util.notification.NotificationManager;
import animeware.util.notification.NotificationType;
import animeware.util.render.ColorUtil;
import animeware.util.render.DrawUtil;
import animeware.util.render.RenderUtil;
import animeware.util.render.RoundedUtils;
import animeware.util.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

public class DragGUI extends GuiScreen {

	boolean hovered;
    public DraggableComponent top;
    public int x, y;
    public Category viewing;
    public HudMod configuring;
    public static GuiTextField username;
    ArrayList<GuiTextField> textFields = new ArrayList<>();
    EntityLivingBase entity;
    static float rotate;
    GuiScreen guiScreen;
    //int Button;

    public DragGUI() {
        //this.x = x;
        //this.y = y;

        this.top = new DraggableComponent(100, 100, 177, 20, new Color(0,140,255, 0).getRGB());
    }

    @Override
    public void initGui() {
    	//this.buttonList.add(new QuitButton(1, top.getxPosition() - 27, top.getyPosition(), ""));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	try {
    	this.hovered = (mouseX >= top.getxPosition() + 180 && mouseY >= top.getyPosition() + 2 && mouseX < top.getxPosition() + 180 + 17 && mouseY < top.getyPosition() + 2 + 15);
    	
    	//Playerdraw(top.getxPosition(), top.getyPosition() + 100, 10000, 50.0F, 0.0F, (EntityLivingBase)Minecraft.thePlayer);
    	Playerdraw(top.getxPosition() + 42, top.getyPosition() + 100, 25, 0, 0, mc.thePlayer);
    	RoundedUtils.drawSmoothRoundedRect(top.getxPosition(), top.getyPosition(), top.getxPosition() + 200, top.getyPosition() + 110, 18.0f, new Color(25, 25, 30, 255).getRGB());
    	mc.fontRendererObj.drawString(NightSky.mcname, top.getxPosition() + 70, top.getyPosition() + 82, new Color(255, 255, 254, 255).getRGB());
    	mc.fontRendererObj.drawString(NightSky.rank(), top.getxPosition() + 70, top.getyPosition() + 92, new Color(255, 255, 254, 255).getRGB());
    	//mc.fontRendererObj.drawString(NightSky.DisName, top.getxPosition() + 70, top.getyPosition() + 45, new Color(255, 255, 254, 255).getRGB());
    	//mc.fontRendererObj.drawString(NightSky.DisTag, top.getxPosition() + 70, top.getyPosition() + 55, new Color(255, 255, 254, 255).getRGB());
    	if(hovered) {
    		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/quit.png"), top.getxPosition() + 180, top.getyPosition() + 2, 15, 15, new Color(255, 0, 0));
    		  //if(Button == 1) {
    			  
    		  //}
    		//mc.displayGuiScreen(new ClickGUI());
    	} else {
    	    DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/quit.png"), top.getxPosition() + 180, top.getyPosition() + 2, 15, 15, Color.white);
    	}
    	
        //Gui.drawRect(top.getxPosition() - 3, top.getyPosition() - 3, top.getxPosition() + 423, top.getyPosition() + 328, -1);
        //Gui.drawRect(top.getxPosition(), top.getyPosition() + 5, top.getxPosition() + 420, top.getyPosition() + 325, new Color(33,33,33).getRGB());
        top.draw(mouseX, mouseY);
        } catch (NullPointerException e) {
    		System.out.println("GUI ERROR");
    	}
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    @Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {	
    	if(hovered) {
    		if(mouseButton == 0) {
    			mc.displayGuiScreen(new ClickGUI());
    		}
    	}
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
	}
    @Override
	protected void actionPerformed(GuiButton button) throws IOException {			
		if(button.id == 1) {
			//mc.displayGuiScreen(new GuiSelectWorld(this));
		}		
		super.actionPerformed(button);
	}
	
		



    public static void Playerdraw(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
		try {
			GlStateManager.enableColorMaterial();
	        GlStateManager.pushMatrix();
	        GlStateManager.translate((float)posX, (float)posY, 50.0F);
	        GlStateManager.scale((float)(-40), (float)42, (float)42);
	        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        float f = ent.renderYawOffset;
	        float f1 = ent.rotationYaw;
	        float f2 = ent.rotationPitch;
	        float f3 = ent.prevRotationYawHead;
	        float f4 = ent.rotationYawHead;
	        GlStateManager.rotate(180f, 0.0F, 1.0F, 0.0F);
	        RenderHelper.enableStandardItemLighting();
	        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
	        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
	        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
	        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
	        ent.rotationYawHead = ent.rotationYaw;
	        ent.prevRotationYawHead = ent.rotationYaw;
	        GlStateManager.translate(0.0F, 0.0F, 0.0F);
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
	        rendermanager.setRenderShadow(true);
	        ent.renderYawOffset = f;
	        ent.rotationYaw = f1;
	        ent.rotationPitch = f2;
	        ent.prevRotationYawHead = f3;
	        ent.rotationYawHead = f4;
	        GlStateManager.popMatrix();
	        RenderHelper.disableStandardItemLighting();
	        GlStateManager.disableRescaleNormal();
	        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	        GlStateManager.disableTexture2D();
	        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
		} catch (NullPointerException e) {
    		System.out.println("Playerdraw ERROR");
    	}
    	
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    
}
