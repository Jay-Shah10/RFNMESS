package gui;


import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class Event_Page extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893140816572727659L;
	
	public static final EventType<Event_Page> Login = new EventType<>(Event.ANY, "Login");

	public Event_Page(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);
		// TODO Auto-generated constructor stub
	}

}
