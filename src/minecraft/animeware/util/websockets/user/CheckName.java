package animeware.util.websockets.user;

import animeware.NightSky;
import animeware.ui.login.LoginScreen;
import animeware.util.misc.Identification;
import animeware.util.websockets.SocketClient;
import net.minecraft.client.Minecraft;

public class CheckName {
	
	Minecraft mc = Minecraft.getMinecraft();
	
	public static void DoCheckNameOnLogin() {
		NightSky.hasSent = false;		
	}
	public static void DoCheckName() {
		
			System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":true"));
			System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":trueowner"));
			System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truedev"));
			System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truepurple"));	
		
	}
	public static void DoShutDownCheck() {
		
			System.out.println(SocketClient.client.request("stop_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":true"));
			//System.out.println(SocketClient.client.request("stop_animeware_owner", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":trueowner"));
			//System.out.println(SocketClient.client.request("stop_animeware_dev", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truedev"));
			//System.out.println(SocketClient.client.request("stop_animeware_purple", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truepurple"));
		
				
	}

}
