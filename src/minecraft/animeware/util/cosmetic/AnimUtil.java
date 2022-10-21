package animeware.util.cosmetic;

import animeware.NightSky;
import animeware.event.EventTarget;
import animeware.event.impl.EventUpdate;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;

public class AnimUtil {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	private static String folder;
	private static String fileType;
	public static int timer;
	public static int frames;
	
	
	@EventTarget
	public static void anim(EventUpdate e) {		
		Minecraft mc = Minecraft.getMinecraft();
    int maxFrames = 15;
	if(mc.thePlayer != null && mc.theWorld != null) {
		timer++;
		//System.out.println(timer);
		if(timer > 1) {
			timer = 0;
		}
		if(timer == 0) {
			frames++;
		}
		if(frames > maxFrames) {
			frames = 0;
		}
		if(frames == 0) {
			//System.out.println("its 0");
		}
		
		//MotionBlur.createAccumulation();
		//SocketClient.main(null);
		/*System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":true"));
		System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":trueowner"));
		System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truedev"));
		System.out.println(SocketClient.client.request("start_animeware", Minecraft.getMinecraft().thePlayer.getGameProfile().getName() + ":truepurple"));*/
		//hasSent = true;
	    }
	
	}
	

}
