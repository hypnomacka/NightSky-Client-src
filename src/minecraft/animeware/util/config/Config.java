package animeware.util.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import animeware.NightSky;
import animeware.cosmetic.CosmeticModule;
import animeware.hud.mod.HudMod;
import animeware.util.account.Account;
import animeware.util.settings.ModeSetting;
import animeware.util.settings.Setting;
import net.minecraft.client.Minecraft;

public class Config {
  public File configFolder = new File("NightSky");
  
  //public File modsFolder = new File("NightSky/Mods");
  
  public Configuration config;
  
  public Configuration configToSave = ConfigurationAPI.newConfiguration(new File("NightSky/Config.ns"));
  
  public final File file = new File("NightSky/Accounts.json");
  
  public final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
  
  public void saveModConfig() {
	    if (!this.configFolder.exists())
	      this.configFolder.mkdirs(); 
	    
	    System.out.println("Saving Module Configuration");
	    for (HudMod m : NightSky.INSTANCE.hudManager.hudMods) {
	      this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " x", m.getX());
	      this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " y", m.getY());
	      this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " enabled", m.isEnabled());
	      for(Setting setting : m.settings) {
	      if(setting instanceof ModeSetting) {
				ModeSetting mode = (ModeSetting) setting;

				try {
					//configToSave.add("setting:" + m.name + ":" + setting.name + ":" + mode.getMode());
					this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " setting " + setting.name, mode.getMode());
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Setting save failed - Config");
				}
			}
	      }      
	    }  
	    System.out.println("Saving Cosmetics Configuration");
	    for (CosmeticModule m : NightSky.INSTANCE.cosManager.cosmetics) {
		      this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " wearing", m.isEnabled());	            
		    }
	    try {
	      this.configToSave.save();
	    } catch (IOException e) {
	      e.printStackTrace();
	      System.out.println("Config Save Failed");
	    } 
	    /*System.out.println("Saving Cosmetic Configuration");
	    for (CosmeticModule m : NightSky.INSTANCE.cosManager.cosmetics) {
	      this.configToSave.set(String.valueOf(m.name.toLowerCase()) + " on", m.isEnabled());	            
	    }     
	    try {
	      this.cosmeticToSave.save();
	    } catch (IOException e) {
	      e.printStackTrace();
	      System.out.println("Cosmetic Config Save Failed");
	    } */
}
  
  public void saveAccount() {
	  try {
	  JsonArray accounts = new JsonArray();
	  try {
		  for (Account a : NightSky.accountManager) {
			  a.setActive(Boolean.valueOf(false));
			  JsonObject jsonAccount = new JsonObject();
			  jsonAccount.addProperty("accessToken", a.getAccessToken());
		      jsonAccount.addProperty("username", a.getUsername());
		      jsonAccount.addProperty("uuid", a.getUuid());
		      jsonAccount.addProperty("email", a.getEmail());
		      jsonAccount.addProperty("microsoft", a.getCracked());
		      if (a.equals(NightSky.accountManager.get(NightSky.accountManager.size() - 1)))
		        a.setActive(Boolean.valueOf(true)); 
		      jsonAccount.addProperty("active", a.getActive());
		      accounts.add((JsonElement)jsonAccount);
		  }
		  /*for(Account a : NightSky.INSTANCE.acc.accounts) {
		  this.accountToSave.get("Name: " + a.getUsername());
	      this.accountToSave.get("UUID: " + a.getUuid());
	      this.accountToSave.get("Cracked: " + a.getCracked());
		  }*/
	  } catch(NullPointerException e) {
		  e.printStackTrace();
		  System.out.println("FAIL");
	  }
	  System.out.println("Saving Account Configuration");
	  if (!this.file.getParentFile().exists())
	      this.file.getParentFile().mkdirs(); 
	    String s = this.gson.toJson((JsonElement)accounts);
	    try {
	      this.file.createNewFile();
	      FileWriter fw = new FileWriter(this.file.getPath());
	      fw.write(s);
	      fw.flush();
	      fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	  } catch(NullPointerException e) {
		  e.printStackTrace();
		  System.out.println("Ahhh shit, here we go again");
	  }
	  /*try {
	      this.accountToSave.save();
	    } catch (IOException e) {
	      e.printStackTrace();
	      System.out.println("Account Save Failed");
	    }*/ 
  }
  
  
  public void loadModConfig() {
    try {
      this.config = ConfigurationAPI.loadExistingConfiguration(new File("NightSky/Config.ns"));
      System.out.println("Load Sucessful");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Failed to load config - Config");
    } 
  }
  
  
}
