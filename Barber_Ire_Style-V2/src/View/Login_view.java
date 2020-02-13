package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.Login_controller;

public class Login_view extends JFrame {

	public String uEmail;
	public String uPassword;
	JButton bLogin;
	JButton bSignUp;
	JLabel lEmail;
	public JTextField tEmail;
	JLabel lPassword;
	public JPasswordField tPassword;
	 Login_controller controller;  //we are using this variable to call the controller class
	
	
	//Constructor
	public Login_view (Login_controller bcontroller) {//getting a controller from outside
		
		this.controller = bcontroller;
		setup(); // instantiate the setup
		creatingElements(); //call the method to create our elements of the view
		
		bLogin.addActionListener(controller);
		bLogin.setActionCommand("Login");		
		bSignUp.addActionListener(controller);
		bSignUp.setActionCommand("SignUp"); 
	}
	
	
	//method to set a size of the view
		private void setup() {
			
			
			this.setVisible(true);
			this.setSize(600, 400);
			this.setTitle("Login Page");
			
		}
		
		
		private void creatingElements() {
			
			JPanel PLoginEmail = new JPanel();
			JPanel PLoginPassword = new JPanel();
			JPanel PLoginSubmit = new JPanel();
			
			lEmail = new JLabel("Email: ");
			tEmail = new JTextField(20);//instantiation of a Textfield
			tEmail.setText("");
			lPassword = new JLabel("Password: ");
			tPassword = new JPasswordField(20);//instantiation of Textfield
			tPassword.setText("");
			bLogin = new JButton("Login"); // create and instantiate a button
			bSignUp = new JButton("SignUp");
			
			//adding the elements to the panel
			PLoginEmail.add(lEmail);
			PLoginEmail.add(tEmail);	
			PLoginPassword.add(lPassword);
			PLoginPassword.add(tPassword);
			PLoginSubmit.add(bLogin);
			PLoginSubmit.add(bSignUp);
			
		
			this.add(PLoginEmail, BorderLayout.NORTH);
			this.add(PLoginPassword, BorderLayout.CENTER);
			this.add(PLoginSubmit, BorderLayout.SOUTH);
			//once we add all the elements we repaint, otherwise the program wont show the elements
			//everytime we add any element we have to repaint
			this.validate();
			this.repaint();
			
					
		}


		public JTextField gettEmail() {
			return tEmail;
		}


		public void settEmail(JTextField tEmail) {
			this.tEmail = tEmail;
		}


		public JPasswordField gettPassword() {
			return tPassword;
		}


		public void settPassword(JPasswordField tPassword) {
			this.tPassword = tPassword;
		}
		
}
