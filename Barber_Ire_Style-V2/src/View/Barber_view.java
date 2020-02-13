package View;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.Login_controller;

public class Barber_view extends JFrame {

	public String uEmail;
	public String uPassword;
	 JButton bLogin;
	public JLabel lEmail;
	public JTextField tEmail;
	 JLabel lPassword;
	 JTextField tPassword;
	 Login_controller controller;  //we are using this variable to call the controller class
	
	
	//Constructor
	public Barber_view (Login_controller bcontroller) {
		
		this.controller = bcontroller;
		
		setup(); // instantiate the setup
		creatingElements(); //call the method to create our elements of the view
		
		bLogin.addActionListener(controller);
		//we dont need to use set actioncommand in this particular case because we are gonna use
		//the actioncommand only in the bottom, but in this case we have only one bottom so
		// there is not point to do it.
		bLogin.setActionCommand("Login");
		
		
			
		
	}
	
	//method to set a size of the view
		private void setup() {
			
			this.setVisible(true);
			this.setSize(800, 200);
			this.setTitle("Login Page");
			
		}
		
		
		private void creatingElements() {
			
			JPanel PLoginEmail = new JPanel();
			JPanel PLoginPassword = new JPanel();
			JPanel PLoginSubmit = new JPanel();
			
			lEmail = new JLabel("Email: ");
			tEmail = new JTextField(20);//instantiation of a Textfield
			tEmail.setText(" ");
			lPassword = new JLabel("Password: ");
			tPassword = new JTextField(20);//instantiation of Textfield
			tPassword.setText(" ");
			bLogin = new JButton("Login"); // create and instantiate a button
			
			//adding the elements to the panel
			PLoginEmail.add(lEmail);
			PLoginEmail.add(tEmail);	
			PLoginPassword.add(lPassword);
			PLoginPassword.add(tPassword);
			PLoginSubmit.add(bLogin);
			
			//now our actionlistener is gonna have a parameter called controller because
			//is the variable we are using to refer the controller class (controller)
			bLogin.addActionListener(controller);
			
			this.add(PLoginEmail, BorderLayout.NORTH);
			this.add(PLoginPassword, BorderLayout.CENTER);
			this.add(PLoginSubmit, BorderLayout.SOUTH);
			//once we add all the elements we repaint, otherwise the program wont show the elements
			//everytime we add any element we have to repaint
			this.validate();
			this.repaint();
			
					
		}
		
	
	
	
}
