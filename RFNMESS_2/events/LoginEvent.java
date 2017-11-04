/**
 * 
 */
package events;

import gui.StageView;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import models.Employee;

/**
 * @author nryle
 *
 */
public class LoginEvent extends Event {
	private String 				username,
								password;
	private boolean				authenticated;
	private StageView			defaultView = StageView.Host;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String un) {
		username = un;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pw) {
		password = pw;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean auth) {
		authenticated = auth;
	}

	public StageView getDefaultView() {
		return defaultView;
	}
	public void setDefaultView(StageView v) {
		defaultView = v;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6714648031522567652L;

	/**
     * Fires when someone is trying to login.
     */
    public static final EventType<LoginEvent> AUTHENTICATING = new EventType<>(Event.ANY, "AUTHENTICATING");
    
    /**
     * Fires after a user has been logged in.
     */
    public static final EventType<LoginEvent> AUTHENTICATED = new EventType<>(Event.ANY, "AUTHENTICATED");
    

    /**
     * Fires after a user has been logged out.
     */
    public static final EventType<LoginEvent> LOGOUT = new EventType<>(Event.ANY, "LOGOUT");
	
	/**
	 * @param arg0
	 */
	public LoginEvent(EventType<? extends LoginEvent> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		
		authenticated = false;
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public LoginEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
		
		authenticated = false;
	}
	
	public LoginEvent(Employee emp, EventTarget target, EventType<? extends Event> type) {
		super(emp, target, type);
		
		if(emp==null) {
			authenticated = false;
		}
		else {
			authenticated = true;
			this.setUsername(emp.getUsername());
			this.setAuthenticated(true);
			
			switch(emp.getAccessLevel()) {
				case Default:
				case Host:
				case MasterAdmin:
				default:
					this.setDefaultView(StageView.Host);
					break;
				case Server:
					this.setDefaultView(StageView.Order);
				case Kitchen:
				case Manager:
					this.setDefaultView(StageView.Kitchen);
					break;
			}
		}
	}

}
