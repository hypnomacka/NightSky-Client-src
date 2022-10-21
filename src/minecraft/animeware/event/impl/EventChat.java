package animeware.event.impl;

import animeware.event.Event;

public class EventChat extends Event {

    public String message;

    public EventChat(String text) {
        this.message = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
