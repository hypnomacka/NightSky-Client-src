package animeware.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import animeware.NightSky;
import animeware.cosmetic.CosmeticModule;
import animeware.gui.clickgui.GUITheme;
import animeware.gui.clickgui.GUIType;
import animeware.hud.HUDConfigScreen;
import animeware.hud.mod.HudMod;
import animeware.ui.comp.CosmeticButton;
import animeware.ui.comp.clickgui.ModButton;
import animeware.ui.comp.clickgui.SettingButton;
import animeware.ui.themes.impl.ThemeButton;
import animeware.util.render.ColorMode;
import animeware.util.render.RenderUtil;
import animeware.util.render.ui.ClickGUIUtil;
import net.arikia.dev.drpc.DiscordUser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

public class CosmeticGUI extends GuiScreen {
	
	public boolean isCGOn = false;
	public boolean cgon;
	
	private int field_146445_a;
    private int field_146444_f;
    
    float anim = 0.0F;
    
    private float currentScroll;
    
    HudMod m;
    
    public static boolean settings; 
    
	private static String TntTime = "TntTimer";
	
	public int x, y, w, h;
	
	ArrayList<CosmeticButton> cosButtons = new ArrayList<>();
	ArrayList<ModButton> modButtons = new ArrayList<>();
	ArrayList<ThemeButton> tButtons = new ArrayList<>();
	ArrayList<SettingButton> settingButtons = new ArrayList<>();
	
	public static GUIType type = GUIType.CLICK;
	public static GUITheme theme = GUITheme.DARK;
	
	public void checkMouseWheel(int mouseX, int mouseY) {
    	int mouseScroll = Mouse.getDWheel();
    	if(mouseScroll > 0) {
    		for(ModButton b : modButtons) {
    			b.y += 15;
    		}
    	} else if(mouseScroll < 0) {
    		for(ModButton b : modButtons) {
    			b.y -= 15;
    		}
    	}
    }
	public void checkMouseWheelCosmetic(int mouseX, int mouseY) {
    	int mouseScrollCos = Mouse.getDWheel();
    	if(mouseScrollCos > 0) {
    		for(CosmeticButton b : cosButtons) {
    			b.y += 15;
    		}
    	} else if(mouseScrollCos < 0) {
    		for(CosmeticButton b : cosButtons) {
    			b.y -= 15;
    		}
    	}
    }
	
	@Override
	public void initGui() {
		super.initGui();
		mc.entityRenderer.loadShader(new ResourceLocation("Animeware/blur.json"));
		this.anim = 80.0F;
		super.initGui();
		this.field_146445_a = 0;
        this.buttonList.clear();
        int i = -16;
        int j = 98;
        
               	
        /*this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 165, 323, 35, NightSky.INSTANCE.cosManager.darkCape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 205, 323, 35, NightSky.INSTANCE.cosManager.deamoneyes));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 245, 323, 35, NightSky.INSTANCE.cosManager.deamoneyes2));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 285, 323, 35, NightSky.INSTANCE.cosManager.ecape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 325, 323, 35, NightSky.INSTANCE.cosManager.gblack));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 365, 323, 35, NightSky.INSTANCE.cosManager.gblue));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 405, 323, 35, NightSky.INSTANCE.cosManager.ggreen));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 445, 323, 35, NightSky.INSTANCE.cosManager.gpurple));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 485, 323, 35, NightSky.INSTANCE.cosManager.gred));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 525, 323, 35, NightSky.INSTANCE.cosManager.kcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 565, 323, 35, NightSky.INSTANCE.cosManager.kcape2));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 605, 323, 35, NightSky.INSTANCE.cosManager.lcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 645, 323, 35, NightSky.INSTANCE.cosManager.ncape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 685, 323, 35, NightSky.INSTANCE.cosManager.pcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 725, 323, 35, NightSky.INSTANCE.cosManager.quavcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 765, 323, 35, NightSky.INSTANCE.cosManager.quickcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 805, 323, 35, NightSky.INSTANCE.cosManager.rcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 845, 323, 35, NightSky.INSTANCE.cosManager.scape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 885, 323, 35, NightSky.INSTANCE.cosManager.tcape));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 925, 323, 35, NightSky.INSTANCE.cosManager.sofyt));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 965, 323, 35, NightSky.INSTANCE.cosManager.sofyt2));
		
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1005, 323, 35, NightSky.INSTANCE.cosManager.dwings));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1045, 323, 35, NightSky.INSTANCE.cosManager.gwings));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1085, 323, 35, NightSky.INSTANCE.cosManager.cwings));
		
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1125, 323, 35, NightSky.INSTANCE.cosManager.eggs));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1165, 323, 35, NightSky.INSTANCE.cosManager.witchhat));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1205, 323, 35, NightSky.INSTANCE.cosManager.glasses));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1245, 323, 35, NightSky.INSTANCE.cosManager.halo));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1285, 323, 35, NightSky.INSTANCE.cosManager.retardeyes));
		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 161, 1325, 323, 35, NightSky.INSTANCE.cosManager.blaze));*/
        
        int countCosmetic = 40;
        for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
        	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape") {
            
        	} else {
        		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 145 + countCosmetic, 323, 35, m));
        		countCosmetic = countCosmetic + 40;
                //System.out.println(countModule);
        	}
        }
    		
    		
        //this.buttonList.add(new LogoButtonWhite(69, this.width / 2 - 186, this.height / 2 - 109, ""));
		//this.buttonList.add(new HomeCGButton(1, this.width / 2 - 188, this.height / 2 - 70, ""));
		//this.buttonList.add(new CosmeticsCGButton(3, this.width / 2 - 188, this.height / 2 - 40, ""));
		//this.buttonList.add(new ToggleableCGButton(2, this.width / 2 - 188, this.height / 2 - 12, ""));	
		//this.buttonList.add(new ServersCGButton(4, this.width / 2 - 188, this.height / 2 + 30, ""));
		//this.buttonList.add(new SettingsCGButton(5, this.width / 2 - 188, this.height / 2 + 60, ""));
				
		
}	
	
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			type = GUIType.CLICK;
			mc.displayGuiScreen(new CosmeticGUI());
			//mc.displayGuiScreen(new ClickGUI());
			
		}
		if(button.id == 5) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(button.id == 3) {
			setType(GUIType.COSMETIC);
			mc.displayGuiScreen(new CosmeticGUI());
			//type = GUIType.COSMETIC;
			//mc.displayGuiScreen(new CosmeticGUINew());
		}
		if(button.id == 2) {
			setType(GUIType.PROFILE);
			mc.displayGuiScreen(new CosmeticGUI());
			//type = GUIType.PROFILE;
			//mc.displayGuiScreen(new ClickGUI2());
		}
		if(button.id == 4) {
			setType(GUIType.THEME);
			mc.displayGuiScreen(new CosmeticGUI());
			//mc.displayGuiScreen(new GuiMultiplayerIngame());
		}
		if(button.id == 6) {
			try {
	 			  Desktop desktop = java.awt.Desktop.getDesktop();
	 			  URI oURL = new URI("http://hynomacka.ddns.net");
	 			  desktop.browse(oURL);
	 			} catch (Exception e) {
	 			  e.printStackTrace();
	 			}
		}
		
		if(button.id == 8) {
			type = GUIType.COSMETIC;
			mc.displayGuiScreen(new CosmeticGUI());
			//mc.displayGuiScreen(new CosmeticGUINew());
		}
		if(button.id == 9) {
			mc.displayGuiScreen(new CosmeticGUI());
		}
		if(button.id == 0) {
			type = GUIType.PROFILE;
			mc.displayGuiScreen(new CosmeticGUI());
			//mc.displayGuiScreen(new ProfileCGui(null));
		}
	}
	
//}
	public static void setType(GUIType killme) {
        if(killme == GUIType.CLICK) {
            type = GUIType.CLICK;
            //this.m = null;
        } else if(killme == GUIType.COSMETIC) {
            type = GUIType.COSMETIC;
            //this.m = null;
        } else if(killme == GUIType.PROFILE) {
            type = GUIType.PROFILE ;
            //this.m = null;
        }else if(killme == GUIType.THEME) {
            type = GUIType.THEME ;
        }
    }
	public static void setTheme(GUITheme killme) {
        if(killme == GUITheme.DARK) {
            theme = GUITheme.DARK;
            //this.m = null;
        } else if(killme == GUITheme.LIGHT) {
            theme = GUITheme.LIGHT;
            //this.m = null;
        }
    }
	
	//public ParticleEngine engine = new ParticleEngine();
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		//FontUtilCedo.normal.drawString("l", 340, 135, new Color(50, 50, 50, 255).getRGB());
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		ScaledResolution sr = new ScaledResolution(mc);
		
		ClickGUIUtil.renderCosmeticMenu();
		
		/*RoundedUtils.drawSmoothRoundedRect((this.width / 2 - 190), (this.height / 2 - 110), (this.width / 2 + 190), (this.height / 2 + 110), 18.0F, new Color(25, 25, 30, 255).getRGB());
		RoundedUtils.drawSmoothRoundedRect((this.width / 2 - 190), (this.height / 2 - 110), (this.width / 2 - 150), (this.height / 2 + 110), 18.0F, new Color(50, 50, 55, 155).getRGB());	    
		RoundedUtils.drawSmoothRoundedRect((this.width / 2 + 90), (this.height / 2 - 110), (this.width / 2 + 190), (this.height / 2 + 110), 18.0F, new Color(50, 50, 55, 155).getRGB());
		RoundedUtils.drawSmoothRoundedRect((this.width / 2 - 185), (this.height / 2 - 74), (this.width / 2 - 155), (this.height / 2 - 72), 4.0F, new Color(100, 100, 105, 255).getRGB());
		
		
		//Gui.drawHorizontalLine(this.width / 2 - 185, this.height / 2 - 63 , this.height / 2 - 77, -1);
		
		
		/*DrawUtil.draw2DImage(new ResourceLocation("Animeware/nightskywhite.png"), this.width / 2 - 189 + 3, this.height / 2 - 112 + 3, 30, 30, Color.WHITE);
		if(type == GUIType.CLICK) {
		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/home.png"), this.width / 2 - 188 + 3, this.height / 2 - 70 + 3, 30, 30, Color.WHITE);
		} else {
			DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/home.png"), this.width / 2 - 188 + 3, this.height / 2 - 70 + 3, 30, 30, Color.GRAY);
		}
		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/positioning.png"), this.width / 2 - 188 + 3, this.height / 2 + 60 + 3, 30, 30, Color.WHITE);
	    if(type == GUIType.COSMETIC) {
		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/cosmetics.png"), this.width / 2 - 188 + 3, this.height / 2 - 40 + 3, 30, 30, Color.WHITE);
	    } else {
	    	DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/cosmetics.png"), this.width / 2 - 188 + 3, this.height / 2 - 40 + 3, 30, 30, Color.GRAY);
	    } if(type == GUIType.PROFILE) {
		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/togglesprint.png"), this.width / 2 - 188 + 3, this.height / 2 - 5 - 2, 30, 30, Color.WHITE);
	    } else {
	    	DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/togglesprint.png"), this.width / 2 - 188 + 3, this.height / 2 - 5 - 2, 30, 30, Color.GRAY);
	    } if(type == GUIType.THEME) {
	    DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/settings.png"), this.width / 2 - 188 + 3, this.height / 2 + 30 - 2, 30, 30, Color.WHITE);
	    } else {
	    	DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/settings.png"), this.width / 2 - 188 + 3, this.height / 2 + 30 - 2, 30, 30, Color.GRAY);
	    }*/
	    	
		try {
		if(MinecraftServer.getServer().isSinglePlayer()) {
			
			NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
			if(playerInfo != null) {
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
			} else if(Minecraft.getMinecraft().getCurrentServerData() != null) {
				NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
				if(playerInfo != null) {
					GL11.glColor4f(1F, 1F, 1F, 1F);
				}
				
			} else {
				
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
        	GL11.glDisable(GL11.GL_SCISSOR_TEST);
			checkMouseWheelCosmetic(mouseX, mouseY);
			GL11.glPushMatrix();
			GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
			{
				RenderUtil.scissor(this.width / 2 - 190, this.height / 2 - 110, this.width / 2 + 190, this.height / 2 + 110);
				//RenderUtil.scissor2(this.width / 2 - 190, this.height / 2 - 110, 1920, 1080);
				//RenderUtil.scissor(this.width / 2 - 100, -300, 1920, 1080);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
			}		
			
			super.drawScreen(mouseX, mouseY, partialTicks);
			for(CosmeticButton cos : cosButtons) {
				cos.draw();		
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopAttrib();
			GL11.glPopMatrix();
         /*else if(type == GUIType.PROFILE) {
        	GL11.glDisable(GL11.GL_SCISSOR_TEST);
			checkMouseWheelCosmetic(mouseX, mouseY);
			GL11.glPushMatrix();
			GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
			{
				RenderUtil.scissor(this.width / 2 - 190, this.height / 2 - 110, this.width / 2 + 190, this.height / 2 + 110);
				//RenderUtil.scissor2(this.width / 2 - 190, this.height / 2 - 110, 1920, 1080);
				//RenderUtil.scissor(this.width / 2 - 100, -300, 1920, 1080);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
			}		
			
			super.drawScreen(mouseX, mouseY, partialTicks);
			for(CosmeticButton cos : cosButtons) {
				cos.draw();		
			}
			GL11.glDisable(GL11.GL_SCISSOR_TEST);
			GL11.glPopAttrib();
			GL11.glPopMatrix();
        }*/
		
		
		
}
	
	
	
	
	
	//@Override
	public int dname(DiscordUser user) {
			return fontRendererObj.drawString(user.username + "#" + user.discriminator, 352, 373, ColorMode.getWhiteColor());	
	}
	 
	@Override
	public void draw() {

		GL11.glColor4f(1F, 1F, 1F, 1F);

			Playerdraw(15 + 15, 15 + 50, 25, 50, 0, null);
			
		super.draw();
	}
	public static void Playerdraw(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
    {
		if(MinecraftServer.getServer().isSinglePlayer()) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-65), (float)65, (float)65);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(155.0F, 0.0F, 1.0F, 0.0F);
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
    } else if(Minecraft.getMinecraft().getCurrentServerData() != null) {
    	GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-65), (float)65, (float)65);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(155.0F, 0.0F, 1.0F, 0.0F);
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
	} else {
		
	}
    }
    
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {								
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
		for(CosmeticButton cos : cosButtons) {
			cos.onClick(mouseX, mouseY, mouseButton);
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	private void drawRoundedRect(final int x, final int y, final int width, final int height, final int cornerRadius, final Color color) {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
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
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        mc.entityRenderer.stopUseShader();
    }
    
    
}
