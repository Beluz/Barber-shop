package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import Model.Barber_model;
import Model.Customer_model;
import Model.Login_model;
import View.Bookings_view;
import View.Customer_view;
import View.Login_view;
import View.SignUp_view;

public class Login_controller extends JFrame implements ActionListener{
	
	//global atrray to store the data obteined from the connection to database
	public String[][] data = new String[100][7];
	public String[][] dataBookings = new String[50][7]; //array to store the bookings of customers
	public String[] datacolumnNames =  {"Booking No.", "Date", "Time", "Status","Barber/Hairdresser"}; //array to store the coliumn names of bookings query
	
	//Global variables
		Login_view Loginview; //global variable type class Login_view
		SignUp_view SignUpview; //global variable type class SignUp_view
		Barber_model bmodel; //global variable type class Model
		Customer_view Customerview; //global variable type class Customer
		Login_model Loginmodel;
		Customer_model Customermodel;
		Bookings_view Bookingsview;
		public String Email; //variable to store the email in the textfield on login view
		public String Password; //variable to store the password in the textfield on login view
		public boolean logged = false; //variable to indicate if the query has results which means the user exists in the database
		public String UserName; //variable to store the username from the query
		public String Window=""; //variable to know which window is currently used.
		public String RoleUser=""; 
		
		
				
		//we have a constructor
		public Login_controller() {
		//we instantiate a new View and Model
			Loginview = new Login_view(this);  //instantiation of class Login which is a view
			SignUpview = new SignUp_view(this);
			bmodel = new Barber_model(); //instantiation of class Model which is a view
			//Customerview = new Customer_view(this);  //instantiation of class Customer which is a view
			Loginmodel = new Login_model(this);
			Customermodel = new Customer_model(this);
			Bookingsview = new Bookings_view(this);
			
			Loginview.setVisible(true);
			//Customerview.setVisible(false);
			SignUpview.setVisible(false);
			Bookingsview.setVisible(false);
			
		}
		
		
		/////////////////////////////////method to create a connection to database
//		public void db() {
//			try{
//				// Load the database driver
//				//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
//				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
//				
//				String dbServer = "jdbc:mysql://localhost:3306/bh_system";
//				String user = "root";
//				String password = "";
//				String query="";
//				
//				if (getWindow() == "Login") {
//					query = "SELECT U_fName, U_Role FROM users where U_Email='"+ Email +"' and U_Password= '"+ Password +"'";			
//				}else if(getWindow()=="SignUp") {
//					query = "INSERT INTO USERS VALUES('"+ Email +"','"+ Password +"','"+SignUpview.tFirstName.getText()+"','"+ SignUpview.tSecondName.getText()+"','"+ RoleUser  +"', '"+ SignUpview.tPhone.getText() +"','Pending','"+ SignUpview.tLocation.getText() +"')";
//					
//				}
//				
//
//				//object from my driver i get the connection
//				//.getConnection is a static method
//				// Get a connection to the database
//				Connection conn = DriverManager.getConnection(dbServer, user, password) ;
//
//				// Get a statement from the connection
//				//statement is to say what do i want to do (queries)
//				Statement stmt = conn.createStatement() ;
//
//				if (getWindow() =="Login") {
//					// Execute the query
//					//resultset is a set of values because we usually get a group of values after execute a query from statement
//					ResultSet rs = stmt.executeQuery(query) ;
//					// Loop through the result set
//					int i=0; //variable to loop the results
//					while(rs.next()) {
//						logged = true; //if there is results of the query
//						if (getWindow() == "Login") {
//							data[i][0] = rs.getString("U_fName");
//							UserName = rs.getString("U_fName").toString();
//							System.out.println(""+ UserName +"");
//							RoleUser = rs.getString("U_Role"); //get the user's role in Login page
//							i++;	
//						}else if (getWindow() == "SignUp") {
//							System.out.println("inserted");
//						}
//					}
//					rs.close() ;
//				}else if(getWindow()=="SignUp") {
//					stmt.executeUpdate(query) ;
//					JOptionPane.showMessageDialog(this, "You have been Sign Up!");
//				}
//				
//				
//
//				// Close the result set, statement and the connection
//				
//				stmt.close() ;
//				conn.close() ;
//			}
//			catch( SQLException se ){
//				System.out.println( "SQL Exception:" ) ;
//
//				// Loop through the SQL Exceptions
//				while( se != null ){
//					System.out.println( "State  : " + se.getSQLState()  ) ;
//					System.out.println( "Message: " + se.getMessage()   ) ;
//					System.out.println( "Error  : " + se.getErrorCode() ) ;
//
//					se = se.getNextException() ;
//				}
//			}
//			catch( Exception e ){
//				System.out.println( e ) ;
//			}
//			
//			
//			
//		}//end method db
		
		
		
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		if(arg0.getActionCommand().equals("Login")) {
			Email = Loginview.tEmail.getText();
			Password = Loginview.tPassword.getText();
			
			Window="Login";
			Loginmodel.db();
			if (logged==true) {
				if(RoleUser.equals("Customer")) {
					Window="Customer";
					//Loginmodel.db();//call connection to fill the bookings table
					Loginview.setVisible(false);
					Customermodel.db();
					Customerview = new Customer_view(this);  //instantiation of class Customer which is a view

					Customerview.setVisible(true);
					Customerview.lCustomerName.setText("Welcome: " + UserName);
					Customerview.User = UserName;
					
					//Customerview.BookingsTable = new JTable (dataBookings, datacolumnNames);
					//Customerview.FillTableBookings(dataBookings, datacolumnNames);
					

					//Customerview.BookingsTable = new JTable (dataBookings, datacolumnNames);
					//Customerview.BookingsTable(dataBookings, datacolumnNames);
					
				}else if (RoleUser == "Barber") {
					
				}
				
			}else {
				//if connection was not successful the show this message
				JOptionPane.showMessageDialog(this, "Try again, your Email or Password are incorrect ");
					
			}
			//String text1 = view.getTextTF1();
			//System.out.println(""+ Email  +"");
			//Loginview.setVisible(false);
			
			
		}else if(arg0.getActionCommand().equals("SignUp")) {
			Loginview.setVisible(false);
			SignUpview.setVisible(true);
			SignUpview.tEmail.setText(Loginview.tEmail.getText());
			
			
		}else if(arg0.getActionCommand().equals("Customer")) {
			SignUpview.PLocation.setVisible(false);
			SignUpview.tLocation.setText(" ");
			
		}else if(arg0.getActionCommand().equals("Hairdresser")) {
			SignUpview.PLocation.setVisible(true);
			
		}else if(arg0.getActionCommand().equals("Barber")) {
			SignUpview.PLocation.setVisible(true);
			
		}else if(arg0.getActionCommand().equals("Sign UP!")) {
			Email = SignUpview.tEmail.getText();
			Password = new String(SignUpview.tPassword.getPassword());
			RoleUser =""; //clean the variable in case was used in the login section
			Window="SignUp";
			if (SignUpview.Customer.isSelected()== true) {
				RoleUser = SignUpview.Customer.getText();
			}else if (SignUpview.Barber.isSelected()== true) {
				RoleUser = SignUpview.Barber.getText();
			}
			//db();
			
		}else if(arg0.getActionCommand().equals("Make a Booking")) {
			Bookingsview.lCustomerName.setText("Welcome: " + UserName);
			Customerview.setVisible(false);
			Bookingsview.setVisible(true);
			
		}
		
		
		
		
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getWindow() {
		return Window;
	}


	public void setWindow(String window) {
		Window = window;
	}

}
