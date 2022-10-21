// 
// Decompiled by Procyon v0.5.36
// 

package animeware.gui.mainmenu;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

import animeware.util.font.FontUtil;

import java.io.File;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class MicrosoftButton extends GuiButton
{	
    private int j6;
    private int j10;
    int fade;
    int fade2;
    
    
    public MicrosoftButton(final int i, final int j, final int k, final String s) {
        this(i, j, k, 175, 21, s);
        
    }
    
    public MicrosoftButton(final int i, final int j, final int k, final int l, final int i1, final String s) {
        super(i, j, k, l, i1, s);
        this.enabled = true;
        this.visible = true;
    }
    
    @Override
    protected int getHoverState(final boolean flag) {
        byte byte0 = 1;
        if (!this.enabled) {
            byte0 = 0;
        }
        else if (flag) {
            byte0 = 2;
        }
        return byte0;
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
        int j = -1;
        if (this.hovered) {
            j = new Color(0,210,220,0).getRGB();
        }
        if (!this.hovered) {
            this.fade = 230;
        }
        else {
            if (this.fade <= 50) {
                return;
            }
            if (this.fade != 160) {
                this.fade -= 10;
            }
        }
        if (!this.hovered) {
            this.fade2 = 200;
        }
        else {
            if (this.fade2 <= 30) {
                return;
            }
            if (this.fade2 != 200) {
                this.fade2 += 10;
            }
        }
        final float b = (float)(this.hovered ? new Color(0, 0, 255, 255).getRGB() : new Color(0, 0, 255, 255).getRGB());
        final Color a = new Color(0, 0, 5, 100);
        final Color a2 = new Color(100, 0, 0, this.fade2);
        final Color a3 = new Color(80, 0, 0, this.fade);
        if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
            final int n = 5;
            final FontRenderer fr = mc.fontRendererObj;
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            //this.drawRoundedRect(this.xPosition - 1, this.yPosition - 1, this.width + 2, this.height + 2, 3, a2);
            //this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a3);
            this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a);
            if(hovered) {
            	GlStateManager.color(0.0f, 0.8f, 0.9f);
            } else {
            	GlStateManager.color(1.0f, 0.0f, 0.0f);
            }
            
            //Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/icons/logo.png"));
            //Gui.drawModalRectWithCustomSizedTexture(this.xPosition + 3, this.yPosition + 3, 0.0f, 0.0f, 15, 15, 15.0f, 15.0f);
            //Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/Microsoft.png"));
            //Gui.drawModalRectWithCustomSizedTexture(this.xPosition + 3, this.yPosition + 3, 0.0f, 0.0f, 15, 15, 15.0f, 15.0f);
            FontUtil.normal.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 5) / 2, j);
        }
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
}
