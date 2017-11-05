package events;

import dataCollection.HostRightData;
import gui.HostRight;
import gui.TableImageButton;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import models.Table;

public class HostEvent extends Event {

	/**
	 * 
	 */
	private Table t;
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

	public static final EventType<HostEvent> RESERVE_CLICKED = new EventType<>(Event.ANY, "RESERVE_CLICKED");
	
	public static final EventType<HostEvent> DELETE_CLICKED = new EventType<>(Event.ANY, "DELETE_CLICKED");
	

	public String getPartyField() {
		return this.hr.getPartyText();
	}

	public Table getSelectedTable() {
		return this.hr.getComboBox();
	}
	
	public Table getTable() {
		return this.t;
	}

	public HostEvent(Object source, EventTarget target, EventType<? extends HostEvent> type) {
		super(source, target, type);

		this.hrd = ((HostRight) target).getText();
	}
	
	public HostEvent(Table source, EventTarget target, EventType<? extends HostEvent> type) {
		super(source, target, type);

		this.t = source;
	}

}
