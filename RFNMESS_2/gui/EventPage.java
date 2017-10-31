package gui;


import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class EventPage extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893140816572727659L;
	
	public static final EventType<EventPage> Login = new EventType<>(Event.ANY, "Login");

	public EventPage(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);
		// TODO Auto-generated constructor stub
	}

}
