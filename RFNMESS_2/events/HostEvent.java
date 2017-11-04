package events;


import dataCollection.HostRightData;
import gui.HostRight;
import gui.TableImageButton;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class HostEvent extends Event {

	/**
	 * 
	 */
	private HostRightData hrd; 
	private HostRight hr;
	
	public HostRightData getNode() {
		return this.hrd;
	}
	public HostRight getNodes() {
		return this.hr;
	}

	private String partyField;
	private int tableNumber;

	private static final long serialVersionUID = 6470164552995153411L;

	public static final EventType<HostEvent> table1_click = new EventType<>(Event.ANY, "Table1");

	public static final EventType<HostEvent> reserveClicked = new EventType<>(Event.ANY, "Reserved");

	public String getPartyField() {
		return this.hr.getPartyText();
	}

	public int getTableNumber() {
		return this.hr.getComboBox();
	}

	public HostEvent(Object source, EventTarget target, EventType<? extends HostEvent> type) {
		super(source, target, type);
		
		this.hrd = ((HostRight)target).getText();
	}

}
