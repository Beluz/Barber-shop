package View;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Login_controller;

public class Bookings_view extends JFrame {

	public JLabel lCustomerName;
	Login_controller controller;
	
	
	public Bookings_view(Login_controller Bcontroller) {
		this.controller = Bcontroller;
		
		setupBookings(); // instantiate the setup
		creatingElementsBookings(); //call the method to create our elements of the view
		
		
	}//end of constructor
	
	
	public void setupBookings() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setTitle("Make a Booking");
	}
	
	
	public void creatingElementsBookings() {
		GridLayout frameManager = new GridLayout(0, 1);
		this.setLayout(frameManager);
		
		JPanel PBooking = new JPanel();
		lCustomerName = new JLabel("Welcome " + controller.UserName );
		//adding the elements to the panel
		PBooking.add(lCustomerName);
		
		this.add(PBooking);
		
		this.validate();
		this.repaint();
		
	}
	
	
	
	
}//end of bookings class
