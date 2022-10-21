package animeware.util.settings;

import java.awt.Color;

import animeware.util.render.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class BooleanSetting extends Setting {
	
	 private boolean value;
	    public float x;
	    public float y;
	    static float size = 15.0f;
	    String string;

	    public BooleanSetting(float x, float y, String idk) {
	        this.x = x;
	        this.y = y;
	        this.string = idk;
	    }

	    public void render(float x, float y) {
	        this.x = x;
	        this.y = y;
	        GlStateManager.resetColor();
	        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	        GuiUtils.drawRoundedRect(x, y, x + size, y + size, 2.0f, new Color(0, 0, 0, 100).getRGB());
	        GuiUtils.drawRoundedOutline(x, y, x + size, y + size, 2.0f, 1.0f, new Color(200, 200, 200, 200).getRGB());
	        GuiUtils.drawTexture(this.getEnabledIcon(), x - 5.0f, y - 5.0f, size + 10.0f, size + 10.0f);
	        GlStateManager.resetColor();
	        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
	        //Minecraft.getMinecraft().fontRendererObj.drawString(this.string, x + 20.0f, y, new Color(200, 200, 200, 200).getRGB());
	        Minecraft.getMinecraft().fontRendererObj.drawString(this.string, x + 20.0f, y, new Color(200, 200, 200, 200).getRGB(), false);
	    }

	    public ResourceLocation getEnabledIcon() {
	        return this.value ? new ResourceLocation("urban/ui/icons/tick.png") : new ResourceLocation("urban/ui/icons/notick.png");
	    }

	    public void onClick(float mx, float my, int mb) {
	        if (mb == 0 && mx > this.x && mx < this.x + size && my > this.y && my < this.y + size) {
	            this.value = !this.value;
	        }
	    }

	    public boolean isEnabled() {
	        return this.value;
	    }

	    public void setEnabled(boolean value) {
	        this.value = value;
	    }
	    public void toggle() {
	    	value = !value;
		}

	    public float getX() {
	        return this.x;
	    }

	    public float getY() {
	        return this.y;
	    }

	    public void setX(float x) {
	        this.x = x;
	    }

	    public void setY(float y) {
	        this.y = y;
	    }
	
	/*public boolean enabled;

	public BooleanSetting(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void toggle() {
		enabled = !enabled;
	}*/

}
