package animeware.util.render.theme;

public class CurrentTheme {
	
	public static Theme current = new RainbowTheme();
	
	public CurrentTheme() {
	}

	public static Theme getCurrent() {
		return current;
	}

	public void setCurrent(Theme current) {
		this.current = current;
	}

}
