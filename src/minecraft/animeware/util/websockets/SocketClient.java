package animeware.util.websockets;

import java.io.IOException;
import co.gongzh.procbridge.Client;
import net.minecraft.client.Minecraft;

import java.net.ServerSocket;

import animeware.NightSky;

public class SocketClient {

    public static final Client client = new Client("127.0.0.1", 7331); //130.61.181.86

    public static void main(String[] args) {
        //client.request("startmonsoon", "its_quick:quick:true");

        //client.request("isUser", "its_quick");
        /*String[] arguments = client.request("isUser", "its_quick").toString().split(":");
        if(arguments[0].equals("true")) {
            System.out.println("returned as true");
        } else if (arguments[0].equals("false")) {
                System.out.println("returned as false");
        }*/

        while(true) {
            //client.getHost()
        }
    }

    public static Object sendRequest(String... args) {
        return client.request("echo", String.join(" ", args));
    }
    
    public static boolean isUser(String username) {
    	//if(NightSky.hasSent == false) {
    		String[] arguments = client.request("isUser", username).toString().split(":");
    		if(arguments[0].equals("true")) {
            	NightSky.isUser = true;
                //System.out.println("returned as true for user " + username);
            	return true;
            } else if (arguments[0].equals("false")) {
            	//System.out.println("returned as false for user " + username);
            	return false;
            } else {
            	System.out.println("there was an error for " + username);
            	return false;
            }
    	
    	
        
    }
    public static boolean isOwner(String username) {
    	String[] arguments = client.request("isOwner", username).toString().split(":");
        if(arguments[0].equals("trueowner")) {
            //System.out.println("returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("there was an error for " + username);
        	return false;
        }
    }
    public static boolean isDev(String username) {
    	String[] arguments = client.request("isDev", username).toString().split(":");
        if(arguments[0].equals("truedev")) {
            //System.out.println("returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("there was an error for " + username);
        	return false;
        }
    }
    public static boolean isPurple(String username) {
    	String[] arguments = client.request("isPurple", username).toString().split(":");
        if(arguments[0].equals("truepurple")) {
            //System.out.println("returned as true for user " + username);
        	return true;
        } else if (arguments[0].equals("false")) {
        	//System.out.println("returned as false for user " + username);
        	return false;
        } else {
        	System.out.println("there was an error for " + username);
        	return false;
        }
    }
    

    public static double randomNumber(double max, double min) {
        return (Math.random() * (max - min)) + min;
    }
    public static String isUserResult() {
    if(NightSky.results == false) {
    	if(isUser(Minecraft.getMinecraft().thePlayer.getName()) == true) {
        	return "true";
        } else
        	return "false";
        }
    return null;
    }
    
}