package animeware;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData {
	
	public static final ResourceLocation SERVER_ICON = new ResourceLocation("Animeware/icons/server.png");
	
	public ServerDataFeatured(String serverName, String serverIP) {
		super(serverName, serverIP, false);
	}

}
