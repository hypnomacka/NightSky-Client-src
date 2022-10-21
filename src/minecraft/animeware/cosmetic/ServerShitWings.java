package animeware.cosmetic;

import animeware.util.websockets.SocketClient;

public class ServerShitWings {

	public static boolean isWearingQuickCape(String username) {
    	String[] arguments = SocketClient.client.request("isWearingQuickCape", username).toString().split(":");
        if(arguments[0].equals("true") && Booleans.QuickCape == true) {
            //System.out.println("isWearingQuickCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingQuickCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingQuickCape = there was an error for " + username);
        	return false;
        }
    }
	
}
