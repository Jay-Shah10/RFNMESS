package gui;

import javafx.geometry.Insets;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;

public class HostCenterGrid extends GridPane {
	private MenuItem reserved;
	private MenuItem busy; 
	private MenuItem available;
	private MenuItem un_reserve;
	private MenuButton mb1, mb2, mb3, mb4, mb5, mb6, mb7, mb8, mb9, mb10, mb11, mb12;

	public HostCenterGrid() {
		this.setPadding(new Insets(15, 5, 5, 5));

		mb1 = new MenuButton("1");
		this.addMenuItem(mb1);
		mb2 = new MenuButton("2");
		this.addMenuItem(mb2);
		mb3 = new MenuButton("3");
		this.addMenuItem(mb3);
		mb4 = new MenuButton("4");
		this.addMenuItem(mb4);
		mb5 = new MenuButton("5");
		this.addMenuItem(mb5);
		mb6 = new MenuButton("6");
		this.addMenuItem(mb6);
		mb7 = new MenuButton("7");
		this.addMenuItem(mb7);
		mb8 = new MenuButton("8");
		this.addMenuItem(mb8);
		mb9 = new MenuButton("9");
		this.addMenuItem(mb9);
		mb10 = new MenuButton("10");
		this.addMenuItem(mb10);
		mb11 = new MenuButton("11");
		this.addMenuItem(mb11);
		mb12 = new MenuButton("12");
		this.addMenuItem(mb12);

		Region r_1 = new Region();
		setHgrow(r_1, Priority.ALWAYS);
		Region r_2 = new Region();
		setHgrow(r_2, Priority.ALWAYS);
		Region r_3 = new Region();
		setHgrow(r_3, Priority.ALWAYS);
		Region r_4 = new Region();
		setHgrow(r_4, Priority.ALWAYS);
		Region r_5 = new Region();
		setHgrow(r_5, Priority.ALWAYS);
		Region r_6 = new Region();
		setHgrow(r_6, Priority.ALWAYS);
		Region r_7 = new Region();
		setHgrow(r_7, Priority.ALWAYS);
		Region r_8 = new Region();
		setHgrow(r_8, Priority.ALWAYS);
		Region r_9 = new Region();
		setHgrow(r_9, Priority.ALWAYS);
		Region r_10 = new Region();
		setHgrow(r_10, Priority.ALWAYS);
		Region r_11 = new Region();
		setHgrow(r_11, Priority.ALWAYS);
		Region r_12 = new Region();
		setHgrow(r_12, Priority.ALWAYS);
		Region r_13 = new Region();
		setHgrow(r_13, Priority.ALWAYS);

		// row1
		add(mb1, 0, 0);
		add(r_1, 1, 0);
		add(mb2, 2, 0);
		add(r_2, 3, 0);
		add(mb3, 4, 0);

		// adds some space between row 1 and row 2.
		add(r_9, 0, 1);
		setVgrow(r_9, Priority.ALWAYS);

		// row2
		add(mb4, 0, 2);
		add(r_3, 1, 2);
		add(mb5, 2, 2);
		add(r_4, 3, 2);
		add(mb6, 4, 2);

		// adds some space between row 2 and row 3
		add(r_10, 0, 3);
		setVgrow(r_10, Priority.ALWAYS);

		// row3
		add(mb7, 0, 4);
		add(r_5, 1, 4);
		add(mb8, 2, 4);
		add(r_6, 3, 4);
		add(mb9, 4, 4);

		// adds some space between row 3 and row 4
		add(r_11, 0, 5);
		setVgrow(r_11, Priority.ALWAYS);

		// row4
		add(mb10, 0, 6);
		add(r_7, 1, 6);
		add(mb11, 2, 6);
		add(r_8, 3, 6);
		add(mb12, 4, 6);

		// adds to some bellow row 4
		add(r_12, 0, 7);
		setVgrow(r_12, Priority.ALWAYS);
		
		this.setStyle(
				"-fx-background-color: rgba(52, 52, 49, 0.83);" + 
				"-fx-border-radius: 50;"
		);
	}

	public void addMenuItem(MenuButton mb) {
		reserved = new MenuItem("Reserve");
		busy = new MenuItem("Busy");
		available = new MenuItem("Available");
		un_reserve = new MenuItem("Cancel Reservation");
		mb.getItems().addAll(reserved, busy, available, un_reserve);

	}
	
	public void setTableReserved() {
		
	}

}
