package animeware.cosmetic;

import animeware.util.websockets.SocketClient;

public class ServerShitCapes {

	public static boolean isWearingCape1(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape1", username).toString().split(":");
        if(arguments[0].equals("owns1") && Booleans.QuickCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape2(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape2", username).toString().split(":");
        if(arguments[0].equals("owns2") && Booleans.PlanetsCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape2 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape3(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape3", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.QuavCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape3 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape4(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape4", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.ReptyllCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape4 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape5(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape5", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.SwordCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape5 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape6(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape6", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.EmeraldCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape6 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape7(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape7", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.LCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape7 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape8(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape8", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.NitroCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape8 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape9(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape9", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.DarkCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape9 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape10(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape10", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.Cape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape10 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape11(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape11", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.YTCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape11 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape12(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape12", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.DevCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape12 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape13(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape13", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.OwnerCape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape13 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape14(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape14", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.GradientBlack == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape14 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape15(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape15", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.GradientBlue == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape15 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape16(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape16", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.GradientGreen == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape16 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape17(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape17", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.GradientPurple == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape17 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape18(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape18", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.GradientRed == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape18 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape19(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape19", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.tanjirocape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape19 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape20(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape20", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.kocho2cape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape20 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape21(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape21", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.kocho3cape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape21 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape22(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape22", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.dseyes2cape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape22 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape23(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape23", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.dseyescape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape23 = there was an error for " + username);
        	return false;
        }
    }
	public static boolean isWearingCape24(String username) {
    	String[] arguments = SocketClient.client.request("isWearingCape24", username).toString().split(":");
        if(arguments[0].equals("owns") && Booleans.wintercape == true) {
            //System.out.println("isWearingCape = returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("isWearingCape = returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("isWearingCape24 = there was an error for " + username);
        	return false;
        }
    }
	
}
