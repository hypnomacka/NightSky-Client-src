package animeware.cosmetic;

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

public class CosmeticModule {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	protected List<GuiButton> buttonList = Lists.<GuiButton>newArrayList();
	protected List<GuiLabel> labelList = Lists.<GuiLabel>newArrayList();
	
	//public List<Setting> settings = new ArrayList<Setting>();
	
	public int lenght = 10;
	public String name;
	//public String description;
	public ResourceLocation iconcos;
	public CosmeticType type;
	//public boolean isEnabled = false;
	public boolean enabled;
	public DraggableComponent drag;
	
	public int x, y, w, h;
	
	public CosmeticModule(String name, ResourceLocation iconcos, CosmeticType type) {
		this.name = name;
		if(type == CosmeticType.CAPE) {
			this.iconcos = new ResourceLocation("Animeware/icons/cape.png");
		} else if(type == CosmeticType.WINGS) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(type == CosmeticType.HAT) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(type == CosmeticType.PET) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(type == CosmeticType.OTHER) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(type == CosmeticType.BANDANA) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(type == CosmeticType.ANIM) {
			this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		} else if(name.equals("Rinnegan Cape - a")) {
			this.iconcos = new ResourceLocation("Animeware/icons/cape.png");
		} else {
		this.iconcos = new ResourceLocation("Animeware/icons/blank.png");
		}
		this.type = type;      
		
		try {
			
		      setEnabled(((Boolean)NightSky.INSTANCE.config.config.get(String.valueOf(name.toLowerCase()) + " wearing")));	
			
		    } catch (NullPointerException e) {
		      //System.out.println("CosConfig Load Failed - CosmeticManager = " + name);
		    	e.printStackTrace();
		      this.enabled = false;
		 } 
		
		//drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());		
	}
	
	
	public int getWidth() {
		
		return 50;

	}
	
	public int getHeight() {
		return 50;

	}
	public ResourceLocation getIcon() {
		return iconcos;
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
		/*if(!mc.thePlayer.getName().equals("hypnomacka") && this.name == "Owner Cape") {
			
		} else if(!mc.thePlayer.getName().equals("hypnomacka")  || !mc.thePlayer.getName().equals("KnownAsR3named")  || !mc.thePlayer.getName().equals("slepica")  || !mc.thePlayer.getName().equals("Fofola")  && this.name == "Staff Cape") {
			
		} else if(!mc.thePlayer.getName().equals("hypnomacka")  || !mc.thePlayer.getName().equals("MartoSVK") && this.name == "YT Cape") {
			
		} else {*/
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		}
		else {
			onDisable();
		}
		//}
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



	

	

