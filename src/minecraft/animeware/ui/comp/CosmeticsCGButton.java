// 
// Decompiled by Procyon v0.5.36
// 

package animeware.ui.comp;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animeware.gui.clickgui.ClickGUI;
import animeware.gui.clickgui.GUIType;
import animeware.util.font.ucfont.UCFontRenderer;
import animeware.util.render.ColorMode;
import animeware.util.render.DrawUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class CosmeticsCGButton extends GuiButton
{
    private int j6;
    private int j10;
    int fade;
    int fade2;
    private final UCFontRenderer fr;
    
    public CosmeticsCGButton(final int i, final int j, final int k, final String s) {
        this(i, j, k, 95, 27, s);
        
    }
    
    public CosmeticsCGButton(final int i, final int j, final int k, final int l, final int i1, final String s) {
        super(i, j, k, l, i1, s);
        this.fr = new UCFontRenderer(new ResourceLocation("Animeware/font/font.ttf"), 19);
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
        final float b = (float)(this.hovered ? new Color(30, 0, 0, 100).getRGB() : new Color(30, 0, 0, 30).getRGB());
        final Color a = new Color(15, 0, 0, this.fade);
        final Color a2 = new Color(100, 0, 0, this.fade2);
        final Color a3 = new Color(80, 0, 0, this.fade);
        if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
            final int n = 10;
            final FontRenderer fr = mc.fontRendererObj;
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            if(!hovered) {
                this.fade = 128;
            }
            else {
                if(this.fade <= 30) {
                    return;
                }
                if(this.fade <= 250) {
                    this.fade += 5;
                }
            }
            int f = 160;
            if(ClickGUI.type == GUIType.CLICK || this.hovered) {
            	this.fr.drawCenteredString(this.displayString, this.xPosition + this.width / 3 + 19, this.yPosition + (this.height - 8) / 2, new Color(this.fade, this.fade, this.fade, 255).getRGB());
        		DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/cosmetics.png"), this.xPosition, this.yPosition, 25, 25, new Color( this.fade, this.fade, this.fade, 255));
        		} else {
        			DrawUtil.draw2DImage(new ResourceLocation("Animeware/icons/cosmetics.png"), this.xPosition, this.yPosition, 25, 25, Color.gray);
        			this.fr.drawCenteredString(this.displayString, this.xPosition + this.width / 3 + 19, this.yPosition + (this.height - 8) / 2, new Color(128, 128, 128).getRGB());
        		}
          }
    } 
        			
    
    private void drawRoundedRect(final int x, final int y, final int width, final int height, final int cornerRadius, final Color color) {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 370, 560, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 280, 370, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 880, color);
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
