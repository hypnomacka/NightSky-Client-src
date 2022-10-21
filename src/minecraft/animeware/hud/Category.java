package animeware.hud;

public enum Category {
	
	HUD("HUD", 130),
	MISC("Misc", 130*2),
	WORLD("World", 130 * 3),
	PLAYER("Player", 130 * 4),
	/*COSMETIC("Cosmetic", 200 * 4)*/;
	
	
	public String name;
	public int pos;
	Category(String name, int pos) {
		this.name = name;
		this.pos = pos;
	}

}
