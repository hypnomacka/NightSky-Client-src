package animeware.gui.mainmenu;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import animeware.NightSky;
import animeware.cosmetic.Booleans;
import animeware.cosmetic.CosmeticModule;
import animeware.gui.clickgui.ClickGUI;
import animeware.ui.comp.CosmeticButton;
import animeware.ui.comp.MainMenuBtn;
import animeware.ui.comp.clickgui.ModButton;
import animeware.ui.login.LoginScreen;
import animeware.util.ClientPanorama;
import animeware.util.animations.Animation;
import animeware.util.font.FontUtil;
import animeware.util.font.JCFont.Fonts;
import animeware.util.font.JCFont.cFontRenderer;
import animeware.util.render.AnimatedResourceLocation;
import animeware.util.render.ColorUtil;
import animeware.util.render.DrawUtil;
import animeware.util.render.RenderUtil;
import animeware.util.render.ui.ClickGUIUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;  

public class  MainMenu  extends GuiScreen {
	
	public cFontRenderer regular = Fonts.getCustomeFont(20, "regular");
	  
	  public cFontRenderer light = Fonts.getCustomeFont(20, "light");
	  
	  public cFontRenderer bold = Fonts.getCustomeFont(20, "bold");
	  
	  public cFontRenderer bold_ = Fonts.getCustomeFont(20, "bold+");
	  
	  public cFontRenderer regularS = Fonts.getCustomeFont(14, "regular");
	  
	  public cFontRenderer lightS = Fonts.getCustomeFont(14, "light");
	  
	  public cFontRenderer boldS = Fonts.getCustomeFont(14, "bold");
	  
	  public cFontRenderer bold_S = Fonts.getCustomeFont(14, "bold+");
	
	private final Object threadLock = new Object();
	
	boolean hovered;
	private String splashText;
	private String openGLWarning1;
	private String openGLWarning2;
	private DynamicTexture viewportTexture;
	private Animation openAnimation;
	ArrayList<CosmeticButton> cosButtons = new ArrayList<>();
	 //private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
	 private float updateCounter;
	 private int field_92024_r;
	    private int field_92023_s;
	    private int field_92022_t;
	    private int field_92021_u;
	    private int field_92020_v;
	    private int field_92019_w;
	    private ResourceLocation backgroundTexture;
	    private int panoramaTimer;
	    
	    private AnimatedResourceLocation gif;
	    
	    private int bgid = 0;
	    public static MMMode mode = MMMode.DEFAULT;
	
	@Override
	public void updateScreen()
    {
        ++this.panoramaTimer;
    }
	
	public static void setMode(MMMode killme2) {
        if(killme2 == MMMode.DEFAULT) {
            mode = MMMode.DEFAULT;
            //this.m = null;
        } else if(killme2 == MMMode.COSMETIC) {
            mode = MMMode.COSMETIC;
            //this.m = null;
        } 
    }
	
	@Override
	public void initGui() {
		//setMode(MMMode.DEFAULT);
		
		//openAnimation = new ElasticAnimation(750, 1, 30.8f, 4.75f, false);
		ScaledResolution sr = new ScaledResolution(mc);
		NightSky.INSTANCE.getDiscordRP().update("Main Menu", "Version: " + NightSky.INSTANCE.VERSION);
		if(!Booleans.ban) {
		gif = new AnimatedResourceLocation("Animeware/cosmetic/capes/anim/lightning", 10, 5);
		NightSky.INSTANCE.getDiscordRP().update("Main Menu", "Version: " + NightSky.INSTANCE.VERSION);
		int i = 24;
        int j = this.height / 4 + 48;
		//this.buttonList.add(new ClassicButton(1, 370, height / 2 + 25, "Singleplayer"));
		//this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 72 + 1, 98, 30, ("options")));
		//this.buttonList.add(new ClassicButton(2, 370, height / 2 + 51, "Multiplayer"));
        
        if(mode == MMMode.COSMETIC) {
        	this.buttonList.add(new QuitButton(11, sr.getScaledWidth() - 135, 70, ""));
        }
		int countCosmetic = 40;
        for(CosmeticModule m  : NightSky.INSTANCE.cosManager.cosmetics) {
        	if(m.name == "Owner Cape" || m.name == "Staff Cape" || m.name == "Creeper Lightning Cosmetic" || m.name == "YT Cape") {
            
        	} else if(mode == MMMode.COSMETIC){
        		this.cosButtons.add(new CosmeticButton(this.width/ 2 - 139,this.height / 2 - 145 + countCosmetic, 323, 35, m));
        		countCosmetic = countCosmetic + 40;
                //System.out.println(countModule);
        	}
        }
        this.buttonList.add(new QuitButton(4, sr.getScaledWidth() - 27, 6, ""));
		//this.buttonList.add(new GuiButton(4, 370, height / 2 + 85, "Quit"));
		//this.buttonList.add(new AltButton(6, 6, 6, ""));
        if(mode == MMMode.DEFAULT) {
		
		
		//this.buttonList.add(new GuiButton(6, 370, height / 2 + 85, "Discord‍"));
		//this.buttonList.add(new DisButton(5, this.width / 2 - 452, this.height / 2 + 235, ""));
		//this.buttonList.add(new Discord(8, 370, height / 2 + 85, ""));
		//this.buttonList.add(new LilButton(7, this.width / 2 - 512, this.height / 2 + 235, ""));
		this.buttonList.add(new SettingsButton(3, this.width / 2 - 0, this.height / 2 + 60, ""));
		//this.buttonList.add(new CosmeticButtonMM(8, this.width / 2 - 25, this.height / 2 + 60, "")); //235
		//this.buttonList.add(new WebsiteButton(9, this.width / 2 - 542, this.height / 2 + 235, ""));
		//this.buttonList.add(new CosmeticsButton(8, 475, height / 2 + 35, ""));
		//this.buttonList.add(new GuiButton(8, 435, height / 2 + 235, "Login"));
		//this.buttonList.add(new LilButton2(10, 930, height / 2 + 235, "BG"));
		
		this.buttonList.add(new MainMenuBtn(1, this.width / 2 - 100, this.height / 2 + 10, 200, 20, 
		     	I18n.format("Singleplayer", new Object[0]))); 
     	this.buttonList.add(new MainMenuBtn(2, this.width / 2 - 100, this.height / 2 + 34, 200, 20, 
     	        I18n.format("Multiplayer", new Object[0]))); 
        }
		
		//this.viewportTexture = new DynamicTexture(256, 256);
        //this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);

        //this.buttonList.add(new ClassicButton(10, width - 187, 3, 80, 20, "Change BG"));


        
        //this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 72 + 1, 98, 30, I18n.format("menu.options", new Object[0])));
        //this.buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        //this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, j + 72 + 12));

        synchronized (this.threadLock)
        {
            this.field_92023_s = this.fontRendererObj.getStringWidth(this.openGLWarning1);
            this.field_92024_r = this.fontRendererObj.getStringWidth(this.openGLWarning2);
            int k = Math.max(this.field_92023_s, this.field_92024_r);
            this.field_92022_t = (this.width - k) / 2;
            this.field_92021_u = ((GuiButton)this.buttonList.get(0)).yPosition - 24;
            this.field_92020_v = this.field_92022_t + k;
            this.field_92019_w = this.field_92021_u + 24;
        }

        this.mc.func_181537_a(false);
		
		
		}else {
			this.buttonList.add(new ClassicButton(4, this.width / 2 - 92, this.height / 2 + 25, 200, 20, 
			     	I18n.format("Banned", new Object[0])));
		}
		super.initGui();
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		
		if(!Booleans.ban) {
			boolean ingame = Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer != null;

	        /*if(!ingame) {
	            GlStateManager.disableAlpha();
	            this.renderSkybox(mouseX, mouseY, partialTicks);
	            GlStateManager.enableAlpha();
	        }*/
			Color gradientColor1 = ColorUtil.interpolateColorsBackAndForth(15, 1, NightSky.INSTANCE.getClientColor(), NightSky.INSTANCE.getAlternateClientColor(), false);
	        Color gradientColor2 = ColorUtil.interpolateColorsBackAndForth(15, 1, NightSky.INSTANCE.getAlternateClientColor(), NightSky.INSTANCE.getClientColor(), false);	        
	         	        		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("Animeware/background/old/bg69.png"));
		Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width, height);
	    
	        DrawUtil.draw2DImage(new ResourceLocation("Animeware/logonobg.png"), this.width / 2 - 70, this.height / 2 - 117, 137, 135, Color.WHITE);
			
			GL11.glColor4f(1, 1, 1, 1);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
			//FontUtil.normal.drawString(NightSky.INSTANCE.NAME + " " + NightSky.INSTANCE.VERSION ,0 + 3, this.height - 11, -1);
			//FontUtil.normal.drawString("Copyright Mojang Studios" ,sr.getScaledWidth() - 135, this.height - 11, -1);
			//this.regular.drawStringWithShadow(NightSky.INSTANCE.NAME + " " + NightSky.INSTANCE.VERSION, 3.0F, (this.height - 12), -1);
		    //this.regular.drawStringWithShadow("Not Affiliated  With Mojang AB.", (this.width - this.regular.getStringWidth("Not Affiliated  Whit Mojang AB.") - 2), (this.height - 12), -1);
			GlStateManager.pushMatrix();
			GlStateManager.scale(3, 3, 1);
			GlStateManager.popMatrix();
	    if(mode == MMMode.COSMETIC) {
	    	GL11.glColor4f(1F, 1F, 1F, 1F);
			GlStateManager.enableAlpha();
			GlStateManager.enableBlend();
						
			ClickGUIUtil.renderCosmeticMenu();
	    }
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		} 
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
				//e.printStackTrace();
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
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {			
		if(button.id == 1) {
			//NightSky.INSTANCE.config.saveAccount();
			mc.displayGuiScreen(new GuiSelectWorld(null));
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if(button.id == 4) {
			//NightSky.INSTANCE.config.saveAccount();
			mc.shutdown();
		}
		if(button.id == 6) {
			mc.displayGuiScreen(new LoginScreen());
		}
		
		if(button.id == 5) {					
		try {
 			  Desktop desktop = java.awt.Desktop.getDesktop();
 			  URI oURL = new URI("https://discord.gg/bCYU3DrW");
 			  desktop.browse(oURL);
 			} catch (Exception e) {
 			  e.printStackTrace();
 			}
      }
		if(button.id == 7) {
			this.mc.displayGuiScreen(new ClickGUI());
		}
		if(button.id == 8) {
			setMode(MMMode.COSMETIC);
			mc.displayGuiScreen(new MainMenu());
		}
		if(button.id == 9) {					
			try {
	 			  Desktop desktop = java.awt.Desktop.getDesktop();
	 			  URI oURL = new URI("https://github.com/hypnomacka");
	 			  desktop.browse(oURL);
	 			} catch (Exception e) {
	 			  e.printStackTrace();
	 			}
			
	      }
		
		if(button.id == 10) {
			bgid++;
			if(bgid == 9) {
				bgid = 0;
			}
		}
		if(button.id == 11) {					
			setMode(MMMode.DEFAULT);
			mc.displayGuiScreen(new MainMenu());
			
	      }
		
	
		
		//if(button.id == 8) {
			
		//}
		//if(button.id == 8) {
			//this.mc.displayGuiScreen(new AnimewareLoginScreen());
		//}
		
		super.actionPerformed(button);
	}
	
	private void drawPanorama(int p_73970_1_, int p_73970_2_, float p_73970_3_)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        int i = 8;

        for (int j = 0; j < i * i; ++j)
        {
            GlStateManager.pushMatrix();
            float f = ((float)(j % i) / (float)i - 0.5F) / 64.0F;
            float f1 = ((float)(j / i) / (float)i - 0.5F) / 64.0F;
            float f2 = 0.0F;
            GlStateManager.translate(f, f1, f2);
            GlStateManager.rotate(MathHelper.sin(((float)this.panoramaTimer + p_73970_3_) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(-((float)this.panoramaTimer + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);

            for (int k = 0; k < 6; ++k)
            {
                GlStateManager.pushMatrix();

                if (k == 1)
                {
                    GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (k == 2)
                {
                    GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (k == 3)
                {
                    GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (k == 4)
                {
                    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                }

                if (k == 5)
                {
                    GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
                }

                this.mc.getTextureManager().bindTexture(ClientPanorama.getTiles()[k]);
                worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                int l = 255 / (j + 1);
                float f3 = 0.0F;
                worldrenderer.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, l).endVertex();
                worldrenderer.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, l).endVertex();
                worldrenderer.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, l).endVertex();
                worldrenderer.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, l).endVertex();
                tessellator.draw();
                GlStateManager.popMatrix();
            }

            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }

        worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }

    /**
     * Rotate and blurs the skybox view in the main menu
     */
    private void rotateAndBlurSkybox(float p_73968_1_)
    {
        this.mc.getTextureManager().bindTexture(this.backgroundTexture);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.colorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        GlStateManager.disableAlpha();
        int i = 3;

        for (int j = 0; j < i; ++j)
        {
            float f = 1.0F / (float)(j + 1);
            int k = this.width;
            int l = this.height;
            float f1 = (float)(j - i / 2) / 256.0F;
            worldrenderer.pos((double)k, (double)l, (double)this.zLevel).tex((double)(0.0F + f1), 1.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
            worldrenderer.pos((double)k, 0.0D, (double)this.zLevel).tex((double)(1.0F + f1), 1.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
            worldrenderer.pos(0.0D, 0.0D, (double)this.zLevel).tex((double)(1.0F + f1), 0.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
            worldrenderer.pos(0.0D, (double)l, (double)this.zLevel).tex((double)(0.0F + f1), 0.0D).color(1.0F, 1.0F, 1.0F, f).endVertex();
        }

        tessellator.draw();
        GlStateManager.enableAlpha();
        GlStateManager.colorMask(true, true, true, true);
    }

    /**
     * Renders the skybox in the main menu
     */
    private void renderSkybox(int p_73971_1_, int p_73971_2_, float p_73971_3_)
    {
        this.mc.getFramebuffer().unbindFramebuffer();
        GlStateManager.viewport(0, 0, 256, 256);
        this.drawPanorama(p_73971_1_, p_73971_2_, p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.mc.getFramebuffer().bindFramebuffer(true);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        float f = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
        float f1 = (float)this.height * f / 256.0F;
        float f2 = (float)this.width * f / 256.0F;
        int i = this.width;
        int j = this.height;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(0.0D, (double)j, (double)this.zLevel).tex((double)(0.5F - f1), (double)(0.5F + f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        worldrenderer.pos((double)i, (double)j, (double)this.zLevel).tex((double)(0.5F - f1), (double)(0.5F - f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        worldrenderer.pos((double)i, 0.0D, (double)this.zLevel).tex((double)(0.5F + f1), (double)(0.5F - f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        worldrenderer.pos(0.0D, 0.0D, (double)this.zLevel).tex((double)(0.5F + f1), (double)(0.5F + f2)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        tessellator.draw();
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
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {								
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		for(CosmeticButton cos : cosButtons) {
			cos.onClick(mouseX, mouseY, mouseButton);
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

}

