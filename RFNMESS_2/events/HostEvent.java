package events;


import gui.HostCenterGrid;
import gui.TableImageButtons;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class HostEvent extends Event {

	/**
	 * 
	 */
	public TableImageButtons tib;
	
	public TableImageButtons getRectangle() {
		return tib;
	}
	
	
	private static final long serialVersionUID = 6470164552995153411L;
	
	public static final EventType<HostEvent> table1_click = new EventType<>(Event.ANY, "Table1");

	public HostEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
		super(arg0, arg1, arg2);
		
		this.tib = ((TableImageButtons)target).getReserved();
	}

}
