/**
 * 
 */
package views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
/**
 * @author jay_s
 *
 */
public interface View {
	Node getCenter();
	Node getRight();
	Node getLeft();
	Node getBottom();
	
	
}
