package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Login_view;
import View.SignUp_view;

public class SignUp_controller implements ActionListener{

	//GLOBAL VARIABLES
	SignUp_view SignUpview; //global variable type class Registration_view
	Login_view Loginview; //global variable type class Login_view
	
	
	//CONSTRUCTOR
	public SignUp_controller() {
		//Loginview = new Login_view(this);  //instantiation of class Login which is a view
		//SignUpview = new SignUp_view(this);
		
		SignUpview.setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
