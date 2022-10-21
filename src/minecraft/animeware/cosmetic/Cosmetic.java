package animeware.cosmetic;

import animeware.hud.Category;
import animeware.util.lukflug.Toggleable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public abstract class Cosmetic implements LayerRenderer<AbstractClientPlayer>, Toggleable {
	
	public static RenderPlayer playerRenderer;
	public static Minecraft mc = Minecraft.getMinecraft();
	//public static Cosmetic INSTANCE = new Cosmetic();
	
	public static String name;
	public static boolean cape;
	public static boolean quavcape;
	public boolean wearing;
	public boolean owns;
	public Category c;
	  
	  public String location;
	  
	  public boolean state;
	  
	  public float prog = 0.0F, anim = 22.0F;
	  
	  public float dragY;
	  
	  public float dragX;
	  
	 
	  
	  public Cosmetic(String name, String location) {
	    this.name = name;
	    this.location = location;
	  }
	  
	  public void render(float ticks) {}
	  
	  public void toggle() {
	    this.state = !this.state;
	  }
	  
	  public void setLocation(String in) {
	    this.location = in;
	  }
	  
	  public ResourceLocation getLocation() {
	    return new ResourceLocation(this.location);
	  }
		  
	  
	
	
	public Cosmetic(String name, boolean cape, RenderPlayer playerRenderer) {
		this.name = name;
		this.cape = cape;
		this.playerRenderer = playerRenderer;
	}
	public static RenderPlayer getPlayerRenderer() {
		return playerRenderer;
	}

	public static Minecraft getMc() {
		return mc;
	}

	public static String getName() {
		return name;
	}

	public static boolean isCape() {
		return cape;
	}

	public boolean isOwns() {
		return owns;
	}

	public Category getC() {
		return c;
	}

	public void setWearing(boolean newWearing) {
		wearing = newWearing;
	}
	
	public boolean isWearing() {
		return wearing;
	}
	
	public void toggleWearing() {
		if(owns) {
			wearing = !wearing;
		}
	}
	
	public static boolean ownsCosmetic() { 
		return false;
	}
	
	/*@Override
	public void toggle() {
		if(owns) {
			wearing = !wearing;
		}
		
	}*/

	@Override
	public boolean isOn() {
		return wearing && owns;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if(player.hasPlayerInfo() && !player.isInvisible()) {
			render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
		}
		
	}
	
	public abstract void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale);

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
	public Category getCategory() {
		return c;

	}
	

}
