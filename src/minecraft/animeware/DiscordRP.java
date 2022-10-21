package animeware;

import org.lwjgl.opengl.APPLEYcbcr422;

import com.mojang.authlib.GameProfile;

import animeware.util.lukflug.Toggleable;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class DiscordRP {
	
	private boolean running = true;
	private long created = 0;
	private final GameProfile gameProfile = null;
	
	public static String id;
	public static String idOwner = "Hypnomacka#4765";
	
	public void start( ) {
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			

			@Override
			public void apply(DiscordUser user) {
				    DiscordRP.id = user.username + "#" + user.discriminator;
				
					System.out.println("id = " + user.username + "#" + user.discriminator + " - " + (Minecraft.getMinecraft().getSession().getUsername()));
					if(user.username != "null") {
						NightSky.DisName = user.username;
					} else {
						NightSky.DisName = NightSky.mcname;
					}
					if(user.discriminator != "") {
					    NightSky.DisTag = "#" + user.discriminator;
					} else {
						NightSky.DisTag = "#0000";
					}
				//System.out.println("-_-");
					update("Starting", "");
			}
			
		}).build();
		
		DiscordRPC.discordInitialize("934484321417445437", handlers, true);
		
		new Thread("DRPC Callback") {
			
			@Override
			public void run() {
				
				while(running) {
					DiscordRPC.discordRunCallbacks();
					//PanelManager.showComponent();
				}
				
			}
			
		}.start();
		
	}
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
		
	}
	private String getImager() {
		if(Minecraft.getMinecraft().thePlayer.getName().equals("hypnomacka")) {
			return "owner";
		} else if(Minecraft.getMinecraft().thePlayer.getName().equals("KnownAsR3named")) {
			return "staff";
		} else if(Minecraft.getMinecraft().thePlayer.getName().equals("_Marto__")) {
			return "yt";
		} else {
			return "large";
		}
	}
	public void update(String firstLine, String secondLine) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		
		b.setBigImage("large", "");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
	public static String getDiscordName(DiscordUser user) {
		
		return user.username + "#" + user.discriminator;

	}
}
