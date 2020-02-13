package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Login_controller;
import Controller.SignUp_controller;

public class SignUp_view extends JFrame {

	//Global variables
	public String uEmail;
	public String uPassword;
	public JButton bSignUp;
	JLabel lEmail;
	public JTextField tEmail;
	JLabel lPassword;
	public JPasswordField tPassword;
	JLabel lFirstName;
	public JTextField tFirstName;
	JLabel lSecondName;
	public JTextField tSecondName;
	JLabel lPhone;
	public JTextField tPhone;
	JLabel lRole;
	public JRadioButton Customer;
	public JRadioButton Barber;
	public JRadioButton Hairdresser;
	ButtonGroup Role;
	JLabel lLocation;
	public JTextField tLocation;
	JPanel PLoginEmail;
	JPanel PLoginPassword;
	JPanel PFirstName;
	JPanel PSecondName;
	JPanel PPhone;
	JPanel PRole;
	public JPanel PLocation;
	JPanel PLoginSubmit;
	
	//SignUp_controller controller;  //we are using this variable to call the controller class
	Login_controller controller;
	
	// CONSTRUCTOR
	public SignUp_view( Login_controller RUcontroller) {
		this.controller = RUcontroller;
		
		setupRU(); // instantiate the setup
		creatingElementsRU(); //call the method to create our elements of the view
		
		bSignUp.addActionListener(controller);
		bSignUp.setActionCommand("Sign UP!");
		Customer.addActionListener(controller);
		Customer.setActionCommand("Customer");
		Barber.addActionListener(controller);
		Barber.setActionCommand("Barber");
		Hairdresser.addActionListener(controller);
		Hairdresser.setActionCommand("Hairdresser");
		
	}
	
	 

	//method to set a size of the view
	private void setupRU() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setTitle("Sign Up Page");
			
	}
			
	private void creatingElementsRU() {
		
		GridLayout frameManager = new GridLayout(0, 1);
		this.setLayout(frameManager);
		
		PLoginEmail = new JPanel();
		PLoginPassword = new JPanel();
		PFirstName = new JPanel();
		PSecondName = new JPanel();
		PPhone = new JPanel();
	    PRole = new JPanel();
		PLocation = new JPanel();
		PLoginSubmit = new JPanel();
		
		lEmail = new JLabel("Email: ");
		tEmail = new JTextField(30);//instantiation of a Textfield
		tEmail.setText("");
		lPassword = new JLabel("Password: ");
		tPassword = new JPasswordField(30);//instantiation of Textfield
		tPassword.setText("");
		lFirstName = new JLabel("First Name: ");
		tFirstName = new JTextField(30);//instantiation of a Textfield
		tFirstName.setText("");
		lSecondName = new JLabel("Second Name: ");
		tSecondName = new JTextField(30);//instantiation of a Textfield
		tSecondName.setText("");
		lPhone = new JLabel("Phone: ");
		tPhone = new JTextField(30);//instantiation of a Textfield
		tPhone.setText("");
		lRole = new JLabel("Role: ");
		Customer = new JRadioButton("Customer");
		Customer.setActionCommand("Customer");
		Barber = new JRadioButton("Barber");
		Barber.setActionCommand("Barber");
		Hairdresser = new JRadioButton("Hairdresser");
		Hairdresser.setActionCommand("Hairdresser");
		lLocation = new JLabel("Location: ");
		tLocation = new JTextField(30);//instantiation of a Textfield
		tLocation.setText("");
		
		Role = new ButtonGroup();
		Role.add(Customer);
		Role.add(Barber);
		Role.add(Hairdresser);

		bSignUp = new JButton("Sign Up!"); // create and instantiate a button
		
		//adding the elements to the panel
		PLoginEmail.add(lEmail);
		PLoginEmail.add(tEmail);	
		PLoginPassword.add(lPassword);
		PLoginPassword.add(tPassword);
		PFirstName.add(lFirstName);
		PFirstName.add(tFirstName);
		PSecondName.add(lSecondName);
		PSecondName.add(tSecondName);
		PPhone.add(lPhone);
		PPhone.add(tPhone);
		PRole.add(lRole);
		PRole.add(Customer);
		PRole.add(Barber);
		PRole.add(Hairdresser);
		PLocation.add(lLocation);
		PLocation.add(tLocation);
		PLocation.setVisible(false);
		PLoginSubmit.add(bSignUp);
		
		this.add(PLoginEmail);
		this.add(PLoginPassword);
		this.add(PFirstName);
		this.add(PSecondName);
		this.add(PPhone);
		this.add(PRole);
		this.add(PLocation);
		this.add(PLoginSubmit);
		
		//once we add all the elements we repaint, otherwise the program wont show the elements
		// everytime we add any element we have to repaint
		this.validate();
		this.repaint();
		
				
	}
				
}
