package animeware.ui.themes.impl;

import java.awt.Color;
import java.util.List;

import com.google.common.collect.Lists;

import animeware.NightSky;
import animeware.event.EventManager;
import animeware.hud.DraggableComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.util.ResourceLocation;

public class ThemeMod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	protected List<GuiButton> buttonList = Lists.<GuiButton>newArrayList();
	protected List<GuiLabel> labelList = Lists.<GuiLabel>newArrayList();
	
	//public List<Setting> settings = new ArrayList<Setting>();
	
	public static boolean expanded;
	public int lenght = 10;
	public String name;
	public String description;
	public ResourceLocation icon;
	//public boolean isEnabled = false;
	public boolean enabled;
	public DraggableComponent drag;
	
	public int index;
	
	public int x, y, w, h;
	
	public ThemeMod(String name, String description, ResourceLocation icon, int x, int y) {
		this.name = name;	
		this.description = description;
		this.icon = icon;
		
		try {
		      this.x = ((Integer)NightSky.INSTANCE.config.config.get(String.valueOf(name.toLowerCase()) + " x")).intValue();
		      this.y = ((Integer)NightSky.INSTANCE.config.config.get(String.valueOf(name.toLowerCase()) + " y")).intValue();
		      setEnabled(((Boolean)NightSky.INSTANCE.config.config.get(String.valueOf(name.toLowerCase()) + " enabled")).booleanValue());
		    } catch (NullPointerException e) {
		      //e.printStackTrace();
		      System.out.println("Conlig Load Failed - ThemeMod");
		      this.x = x;
		      this.y = y;
		      this.enabled = false;
		    } 
		
		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());		
	}
	
	
	public int getWidth() {
		
		return 50;

	}
	
	public int getHeight() {
		return 50;

	}
	public ResourceLocation getIcon() {
		return icon;
	}
	
	public void draw() {

	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);

	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		}
		else {
			onDisable();
		}
	}
	public void setDisabled(boolean enabled) {
		this.enabled = !enabled;
		if(!enabled) {
			onDisable();
		}
		else {
			onEnable();
		}
	}
	
	public void onEnable() {EventManager.register(this);}
	
	public void toggle() {
		this.setEnabled(!enabled);

	}
	public void expand() {
		if(expanded) {
			expanded = false;
		} else {
			expanded = true;
		}

	}
	
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public boolean isDisabled() {
		return !enabled;
	}


	public void onDisable() {
		NightSky.INSTANCE.eventManager.unregister(this);

	}
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        for (int i = 0; i < this.buttonList.size(); ++i)
        {
            ((GuiButton)this.buttonList.get(i)).drawButton(this.mc, mouseX, mouseY);
        }

        for (int j = 0; j < this.labelList.size(); ++j)
        {
            ((GuiLabel)this.labelList.get(j)).drawLabel(this.mc, mouseX, mouseY);
        }
    }
	//@Override
	public String getToggled() {
		return "Toggled";
	}
	public void Notif() {
		
	}

	
}



	

	

