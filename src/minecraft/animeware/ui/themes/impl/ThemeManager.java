package animeware.ui.themes.impl;

import java.util.ArrayList;

import animeware.ui.themes.GUIDark;
import animeware.ui.themes.GUILight;

public class ThemeManager {
	
	public static boolean guidark;
	public static boolean guilight;
	public static boolean astolfoBtn;
	
	public static ArrayList<ThemeMod> themes = new ArrayList<>();
	
	public GUIDark guiDark;
	public GUILight guiLight;
	
	public ThemeManager() {
		themes = new ArrayList<>();
		
		themes.add(guiDark = new GUIDark());
		//themes.add(guiLight = new GUILight());
		
	}
	public static ArrayList<ThemeMod> getThemes() {
		return themes;
	}
	
}
