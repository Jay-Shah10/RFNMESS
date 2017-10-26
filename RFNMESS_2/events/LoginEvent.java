/**
 * 
 */
package events;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * @author nryle
 *
 */
public class LoginEvent extends Event {
	private String 				username,
								password;
	
	private boolean				authenticated;
	
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

}
