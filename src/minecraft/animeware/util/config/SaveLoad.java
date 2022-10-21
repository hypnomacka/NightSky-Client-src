package animeware.util.config;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import animeware.NightSky;
import animeware.hud.mod.HudMod;
import animeware.hud.mod.HudMod;
import animeware.util.settings.BooleanSetting;
import animeware.util.settings.ModeSetting;
import animeware.util.settings.NumberSetting;
import animeware.util.settings.Setting;
import net.minecraft.client.Minecraft;
//import wtf.monsoon.NightSky;


public class SaveLoad {

	public String configFileName;
	private File dir, configDir;
	private static File dataFile;
	   
	public SaveLoad(String configFileName) {
		this.configFileName = configFileName;
		dir = new File(Minecraft.getMinecraft().mcDataDir, "this.folder.is.useless.but.the.game.crashes.without.it");
		configDir = new File(dir, "Configs");
		if(!dir.exists()) {
			dir.mkdir();
		}
		if(!configDir.exists()) {
			configDir.mkdir();
		}
		dataFile = new File(configDir, configFileName + ".txt");
		if(!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {e.printStackTrace();}
		}
		
		this.load();
	}
	
	public static void save() {
		ArrayList<String> toSave = new ArrayList<String>();
		
		for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
			toSave.add("module:" + mod.getName() + ":" + mod.isEnabled() + ":" + mod.getY() + ":" + mod.getX());
		}
		
		for(HudMod mod : NightSky.INSTANCE.hudManager.hudMods) {
			for(Setting setting : mod.settings) {
				
				if(setting instanceof BooleanSetting) {
					BooleanSetting bool = (BooleanSetting) setting;
					toSave.add("setting:" + mod.name + ":" + setting.name + ":" + bool.isEnabled());
				}
				
				if(setting instanceof NumberSetting) {
					NumberSetting numb = (NumberSetting) setting;
					toSave.add("setting:" + mod.name + ":" + setting.name + ":" + numb.getValue());
				}
				
				if(setting instanceof ModeSetting) {
					ModeSetting mode = (ModeSetting) setting;

					try {
						toSave.add("setting:" + mod.name + ":" + setting.name + ":" + mode.getMode());
					} catch(ArrayIndexOutOfBoundsException e) {
						NightSky.sendMessage("Invalid mode");
						NightSky.sendMessage("Could either be an old config, or someone wanted your game to crash.");
					}
				}
			}
		}
		toSave.add("COMMANDPREFIX:" + ".");
		
		try {
			PrintWriter pw = new PrintWriter(dataFile);
			for(String str : toSave) {
				pw.println(str);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			String line = reader.readLine();
			while(line != null) {
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
			}
		
		for(String s : lines) {
			String[] args = s.split(":");
			if(s.toLowerCase().startsWith("module:")) {
				HudMod m = NightSky.INSTANCE.hudManager.getModule(args[3]);
				if(m != null) {
					if(m.name.equals("ClickGUI") && m.name.equals("hudEditor"))
						m.setEnabledSilent(!Boolean.parseBoolean(args[4]));
					
					if(!m.name.equals("ClickGUI") && !m.name.equals("hudEditor"))
					m.setEnabledSilent(Boolean.parseBoolean(args[4]));
					//m.setKey(Integer.parseInt(args[3]));
				}
			}else if(s.toLowerCase().startsWith("setting:")) {
				HudMod m =  NightSky.INSTANCE.hudManager.getModule(args[1]);
				if(m != null) {
					for(Setting setting : m.settings) {
						if(setting.name.equalsIgnoreCase(args[2]) && setting != null) {
							if(setting instanceof BooleanSetting) {
								((BooleanSetting) setting).setEnabled(Boolean.parseBoolean(args[3]));
							}
							if(setting instanceof NumberSetting) {
								try {
									((NumberSetting)setting).setValue(Double.parseDouble(args[3]));
								} catch(ArrayIndexOutOfBoundsException e) {
									NightSky.sendMessage("Invalid amount " + args[3]);
									NightSky.sendMessage("Could either be an old config, or someone wanted your game to crash.");
								}
							}
							if(setting instanceof ModeSetting) {
								//System.out.println(args[3]);
								try {
									//((ModeSetting) setting).setMode(args[3]);        AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
								} catch(ArrayIndexOutOfBoundsException e) {
									NightSky.sendMessage("Invalid mode " + args[3]);
									NightSky.sendMessage("Could either be an old config, or someone wanted your game to crash.");
								}
							}
						}
					}
				}
			}else if(s.toLowerCase().startsWith("commandprefix:")) {
				//NightSky.INSTANCE.commandManager.setPrefix(args[1]);
			}
		}
	}
}