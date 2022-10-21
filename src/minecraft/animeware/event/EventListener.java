package animeware.event;

public interface EventListener<T> {
    void call(T event);
}
