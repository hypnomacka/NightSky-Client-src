package animeware.util.backend;

import animeware.util.websockets.SocketClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class WebSockets {
	
	public static String getImage() {
		//if((boolean)SocketClient.isUser(((AbstractClientPlayer) AbstractClientPlayer).getGameProfile().getName())) { 
			if(Minecraft.getMinecraft().thePlayer.getName().equals("hypnomacka")) {
				//Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/nightskyowner.png"));
				return "Animeware/nightskyowner.png";
			} else if(Minecraft.getMinecraft().thePlayer.getName().equals("KnownAsR3named") || Minecraft.getMinecraft().thePlayer.getName().equals("Fofola") || Minecraft.getMinecraft().thePlayer.getName().equals("abcdefgh8") || Minecraft.getMinecraft().thePlayer.getName().equals("slepica") || Minecraft.getMinecraft().thePlayer.getName().equals("nhm")) {
				//Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/nightskystaff.png"));
				return "Animeware/nightskystaff.png";
			} else if(Minecraft.getMinecraft().thePlayer.getName().equals("_Marto__")) {
				//Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/nightskyyt.png"));
				return "Animeware/nightskyyt.png";
			} else if(Minecraft.getMinecraft().thePlayer.getName().equals(Minecraft.getMinecraft().thePlayer.getName())) {
				//Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Animeware/nightskywhite.png"));
				return "Animeware/nightskywhite.png";
			} else {
				return "Animeware/cosmetic/capes/blank.png";	
			}
		//}
		
		
		
	}

}
