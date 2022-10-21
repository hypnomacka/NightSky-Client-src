package animeware.gui.splash;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animeware.util.font.ucfont.UCFontRenderer;
import animeware.util.render.DrawUtil;
import animeware.util.render.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class SplashProgress {
	
	private static final int MAX = 8;
	private static int PROGRESS = 0;
	private static String CURRENT = "";
	private static ResourceLocation splash;
	private static ResourceLocation logo;
	private static UnicodeFontRenderer ufr;
	static UCFontRenderer fr = new UCFontRenderer(new ResourceLocation("Animeware/font/font.ttf"), 23.0f);
    static UCFontRenderer frn = new UCFontRenderer(new ResourceLocation("Animeware/font/font.ttf"), 26.0f);
   
	
	public static void update() {
		if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
			return;
		}		
		drawSplash(Minecraft.getMinecraft().getTextureManager());
	}
	
	public static void setProgress(int givenProgress, String givenText) {
		PROGRESS = givenProgress;
		CURRENT = givenText;
		update();
	}
	
	public static void drawSplash(TextureManager tm) {
		
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		int scaleFactor = scaledResolution.getScaleFactor();
		
		Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
		framebuffer.bindFramebuffer(false);
		
		GlStateManager.matrixMode(GL11.GL_PROJECTION);
		GlStateManager.loadIdentity();
		GlStateManager.ortho(0.0D, (double)scaledResolution.getScaledWidth(), (double)scaledResolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
		GlStateManager.matrixMode(GL11.GL_MODELVIEW);
		GlStateManager.loadIdentity();
		GlStateManager.translate(0.0F, 0.0F, -2000.0F);
		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		GlStateManager.disableDepth();
		GlStateManager.enableTexture2D();
		
		if(splash == null) {
			splash = new ResourceLocation("Animeware/background/old/bg2l.png");
	    }
		tm.bindTexture(splash);
		//DrawUtil.draw2DImage(new ResourceLocation("Animeware/logonobg.png"), GuiScreen.width / 2 - 70, GuiScreen.height / 2 - 117, 137, 135, Color.WHITE);
		//FontUtil.normal.drawCenteredString(".", 213, 148, 0xFFFFFFFF);
		
		GlStateManager.resetColor();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920, 1080);
		drawProgress();
		framebuffer.unbindFramebuffer();
		framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
		
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1F);
		
		Minecraft.getMinecraft().updateDisplay();
	}
	
	private static void drawProgress() {
		
		if(Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
			return;
		}
		
		if(ufr == null) {
		    ufr = UnicodeFontRenderer.getFontOnPC("Calibri", 30);
	    }
	
	    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	    
	    double nProgress = (double)PROGRESS;
	    double calc = (nProgress / MAX) * 150;
	    
	    //Gui.drawRect(100, sr.getScaledHeight() - 35, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0, 0, 0, 50).getRGB());
	    
	    GlStateManager.resetColor();
	    resetTextureState();
	    String step = PROGRESS + "/" + MAX;
	    frn.drawCenteredString("NightSky", 310, 220, 0xFFFFFFFF);
	    fr.drawCenteredString(CURRENT, 310, 265, 0xFFFFFFFF);
	    //FontUtil.normal.drawCenteredString(".", 213, 148, 0xFFFFFFFF);
	    
	    
	    //ufr.drawString(step, sr.getScaledWidth() - 208 - ufr.getStringWidth(step), sr.getScaledHeight() - 80, 0xe1e1e1FF);
	    
	    GlStateManager.resetColor();
	    resetTextureState();
	    //DrawUtil.draw2DImage(new ResourceLocation("Animeware/nightskytext.png"), 800 / 2 - 145, 600 / 2 - 75, 320, 100, Color.WHITE);
	    //DrawUtil.draw2DImage(new ResourceLocation("Animeware/nightskywhite.png"), sr.getScaledWidth(), sr.getScaledHeight(), 10, 10, Color.WHITE);
	    //Gui.drawRect(0, sr.getScaledHeight() - 2, (int)calc, sr.getScaledHeight(), new Color(0, 0, 144).getRGB());	    	    
	    //drawRoundedRect(0, sr.getScaledHeight() - 2, (int)calc, sr.getScaledHeight(), PROGRESS, PROGRESS, null);
	    
	    DrawUtil.drawRoundedRect(200, 245, 150 + 280, sr.getScaledHeight() - 97, 10, new Color(0, 0, 0, 255).getRGB());
	    
	    DrawUtil.drawRoundedRect(200, 245, (int)calc + 280, sr.getScaledHeight() - 97, 10, new Color(0, 200, 240, 255).getRGB());
	    
	    RoundedUtils.drawRoundedOutline(200, 245, 150 + 280, sr.getScaledHeight() - 97, 10, 3, new Color(0, 0, 0, 255).getRGB());
	    	      
	    //Gui.drawRect(0, sr.getScaledHeight() - 2, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0, 0, 0, 10).getRGB());
	    
    }  
     
	private static void resetTextureState() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit]. textureName = -1;
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

}
