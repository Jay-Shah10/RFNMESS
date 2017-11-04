package events;

import gui.HostCenterGrid;
import gui.TableImageButton;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class HostEvent extends Event {

	/**
	 * 
	 */
	public TableImageButton tib;

	public TableImageButton getRectangle() {
		return tib;
	}

	private String partyField;
	private int tableNumber;

	private static final long serialVersionUID = 6470164552995153411L;

	public static final EventType<HostEvent> table1_click = new EventType<>(Event.ANY, "Table1");

	public static final EventType<HostEvent> reserveClicked = new EventType<>(Event.ANY, "Reserved");

	public String getPartyField() {
		return this.partyField;
	}

	public int getTableNumber() {
		return this.tableNumber;
	}

	public HostEvent(Object source, EventTarget target, EventType<? extends HostEvent> type) {
		super(source, target, type);

	}

}
