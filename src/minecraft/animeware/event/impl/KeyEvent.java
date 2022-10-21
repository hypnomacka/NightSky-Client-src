package animeware.event.impl;

import animeware.event.Event;

public class KeyEvent extends Event {
	
	private static int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}

	public static int getKey() {
		return key;
	}
}
