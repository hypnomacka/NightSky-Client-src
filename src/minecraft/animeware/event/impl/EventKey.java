package animeware.event.impl;

import animeware.event.Event;

public class EventKey extends Event {

	public int code;
	
	public EventKey(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
