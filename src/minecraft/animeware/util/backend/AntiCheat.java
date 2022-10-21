package animeware.util.backend;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Vector;

import org.apache.commons.io.FileUtils;

import animeware.DiscordRP;
import animeware.cosmetic.Booleans;
import animeware.util.misc.WebhookUtil;
import net.minecraft.client.Minecraft;

public class AntiCheat {

	public static String HWID;
	
	public static boolean checkVape() {
        try {
            final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            final Field classesField = ClassLoader.class.getDeclaredField("classes");
            classesField.setAccessible(true);
            final Vector<Class<?>> classes = (Vector<Class<?>>) classesField.get(classLoader);
            for (Class<?> classFor : classes) {
                if (classFor.getName().equalsIgnoreCase("a.A")) {
                    for (Method method : classFor.getMethods()) {
                        if (method.getName().equals("test") && method.getParameterCount() == 0) {
                        	System.out.println("Succesfully checked for Vape v4 = Injected");
                            return true;
                        }
                    }
                }
            }
            System.out.println("Succesfully checked for Vape v4 = Not Injected");
        } catch (Exception e) {
        	System.out.println("Failed the check for Vape v4");
            e.printStackTrace();
        }
        
        return false;
    }
	
	public static boolean checkSigma() {
		if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/sigma").isEmpty()) {
    		return true;
    	} else if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma").isEmpty()) {
    		return true;
    	} if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma5").isEmpty()) {
    		return true;
    	} else return false;
	}
	public static boolean checkZeroDay() {
		if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/ZeroDay").isEmpty()) {
    		return true;
    	} else if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/ZeroDay").isEmpty()) {
    		return true;
    	} else return true;
	}
	public static boolean checkImpact() {
		if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/Impact").isEmpty()) {
    		return true;
    	} else if(!(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/1.16.5-Impact_4.9.1-OptiFine_HD_U_G8").isEmpty()) {
    		return true;
    	} else return false;
	}
	
	public static void doAnticheat() {
		checkVape();
		checkSigma();
		checkZeroDay();
		checkImpact();
		
		if(checkVape() == true) {
			Booleans.ban = true;
			System.out.println(DiscordRP.getDiscordName(null) + " - " + (Minecraft.getMinecraft().getSession().getUsername()) + "HWID: "+ AntiCheat.getHWID() + " was banned for: Vape");
		}
        if(checkSigma() == true) {
			//Animeware.ban = true;
			System.out.println(DiscordRP.getDiscordName(null) + " - " + (Minecraft.getMinecraft().getSession().getUsername()) + " has: Sigma");
		}
        if(checkZeroDay() == true) {
			//Animeware.ban = true;
			System.out.println(DiscordRP.getDiscordName(null) + " - " + (Minecraft.getMinecraft().getSession().getUsername()) + " has: ZeroDay");
		}
        if(checkImpact() == true) {
			//Animeware.ban = true;
			System.out.println(DiscordRP.getDiscordName(null) + " - " + (Minecraft.getMinecraft().getSession().getUsername()) + " has: Impact");
		}
	}
	public static void deleteSigma() {

        File sigmaDataDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/sigma");
        File sigmaVerDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma");
        File sigmaNewVerDir = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/Sigma5");
        try {
            FileUtils.deleteDirectory(sigmaDataDir);
            FileUtils.deleteDirectory(sigmaVerDir);
            FileUtils.deleteDirectory(sigmaNewVerDir);
            System.out.println("HackDelete Succesfull! - Sigma");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("HackDelete Failed! - Sigma");
        }
        
    }
	
	public static void deleteZeroDay() {

        File zeroDayData = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/ZeroDay");
        File zeroDayVer = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/ZeroDay");
        try {
            FileUtils.deleteDirectory(zeroDayData);
            FileUtils.deleteDirectory(zeroDayVer);
            System.out.println("HackDelete Succesfull! - ZeroDay");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("HackDelete Failed! - ZeroDay");
        }
    }	
	public static void deleteImpact() {

        File impactData = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/Impact");
        File impactVer = new File(FileUtils.getUserDirectoryPath() + "/AppData/Roaming/.minecraft/versions/1.16.5-Impact_4.9.1-OptiFine_HD_U_G8");
        try {
            FileUtils.deleteDirectory(impactData);
            FileUtils.deleteDirectory(impactVer);
            System.out.println("HackDelete Succesfull! - Impact");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("HackDelete Failed! - Impact");
        }
    }
	public static void removeCheats() {
		deleteSigma();
		deleteZeroDay();
		deleteImpact();
	}
	public static String getHWID() {
        try{
            String toEncrypt =  System.getenv("COMPUTERNAME") + System.getProperty("user.name") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_LEVEL");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toEncrypt.getBytes());
            StringBuffer hexString = new StringBuffer();
            
            byte byteData[] = md.digest();
            
            for (byte aByteData : byteData) {
                String hex = Integer.toHexString(0xff & aByteData);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            HWID = hexString.toString();
            System.out.println(HWID);
            
            return hexString.toString();
            
        } catch (Exception e) {
            e.printStackTrace(); 
            System.out.println("error");
        	return "Error";
        }
    }
	
}
