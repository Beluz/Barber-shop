package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.Login_controller;


public class Customer_view extends JFrame{

	public JLabel lCustomerName;
	public String User;
	public JTable BookingsTable;
	public JScrollPane spBookings;
	Login_controller controller;  //we are using this variable to call the controller class
	public JButton MakeBookings;
	

	
	public Customer_view(Login_controller Ccontroller) {

		this.controller = Ccontroller;
		
		

		//controller.db(); //call connection
		setupCustomer(); // instantiate the setup
		creatingElements(); //call the method to create our elements of the view
		
		MakeBookings.addActionListener(controller);
		MakeBookings.setActionCommand("Make a Booking");
	}
	
	//method to set a size of the view
		private void setupCustomer() {
			
			this.setVisible(true);
			this.setSize(600, 400);
			this.setTitle("Customer Dashboard");
			
		}
		
		
		private void creatingElements() {
			GridLayout frameManager = new GridLayout(0, 1);
			this.setLayout(frameManager);
			
			JPanel PCustomer = new JPanel();
			lCustomerName = new JLabel("Welcome " + User );
			//adding the elements to the panel
			PCustomer.add(lCustomerName);
			
			JPanel PCusBookings = new JPanel();
			BookingsTable = new JTable(controller.dataBookings, controller.datacolumnNames);
			spBookings = new JScrollPane(BookingsTable);
			//PCusBookings.add(BookingsTable);
			PCusBookings.add(spBookings);
			
			JPanel PButtomMakeBooking = new JPanel();
			MakeBookings = new JButton ("Book Now");
			PButtomMakeBooking.add(MakeBookings);
			
			
			this.add(PCustomer);
			this.add(PCusBookings);
			this.add(PButtomMakeBooking);
			//once we add all the elements we repaint, otherwise the program wont show the elements
			//everytime we add any element we have to repaint
			this.validate();
			this.repaint();
			
					
		}
		
			
			
		
			

}
