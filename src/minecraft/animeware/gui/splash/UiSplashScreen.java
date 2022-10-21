package animeware.gui.splash;

import java.awt.Color;

import animeware.NightSky;
import animeware.util.ClientPanorama;
import animeware.util.render.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class UiSplashScreen {

    private static final int MAX_STEPS = 5;
    private static int currentStep = 0;
    private static String currentText = "";

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void update(String text) {
        ++currentStep;
        currentText = text;
        renderSplashScreen();
    }

    public static void renderSplashScreen() {
        ScaledResolution res = new ScaledResolution(mc);
        int i = res.getScaleFactor();
        Framebuffer framebuffer = new Framebuffer(res.getScaledWidth() * i, res.getScaledHeight() * i, true);
        framebuffer.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0D, (double)res.getScaledWidth(), (double)res.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0F, 0.0F, -2000.0F);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        drawScreen(res);

        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(res.getScaledWidth() * i, res.getScaledHeight() * i);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1F);

        mc.updateDisplay();
    }

    public static void drawScreen(ScaledResolution res) {
        mc.getTextureManager().bindTexture(ClientPanorama.getBackground());
        Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, res.getScaledWidth(), res.getScaledHeight(), res.getScaledWidth(), res.getScaledHeight());

        mc.getTextureManager().bindTexture(new ResourceLocation("lux/logo.png"));
        Gui.drawModalRectWithCustomSizedTexture(res.getScaledWidth() / 2 - 26, res.getScaledHeight() / 2 - 60, 0, 0, 52, 52, 52, 52);
        mc.fontRendererObj.drawString(NightSky.mcname, res.getScaledWidth() / 2, res.getScaledHeight() / 2 - 8, -1);

        GuiUtils.drawRoundedRect(res.getScaledWidth() / 2 - 90, res.getScaledHeight() / 2 + 20, 180, 10, 3, new Color(255, 255, 255, 30).getRGB());

        double progressWidth = ((double) currentStep / MAX_STEPS) * 180;
        if(progressWidth != 0)
            GuiUtils.drawRoundedRect(res.getScaledWidth() / 2 - 90, res.getScaledHeight() / 2 + 19, (int) progressWidth, 12, 3, -1);

        GuiUtils.drawRoundedOutline(res.getScaledWidth() / 2 - 90, res.getScaledHeight() / 2 + 20, res.getScaledWidth() / 2 + 90, res.getScaledHeight() / 2 + 30, 4, res.getScaleFactor(), new Color(255, 255, 255, 150).getRGB());
        mc.fontRendererObj.drawString(currentText.toUpperCase(), res.getScaledWidth() / 2, res.getScaledHeight() / 2 + 32, new Color(255, 255, 255, 150).getRGB());
    }

}
