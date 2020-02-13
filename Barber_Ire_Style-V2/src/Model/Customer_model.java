package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Login_controller;
import View.Login_view;

public class Customer_model extends JFrame {

	Login_controller controller;  //we are using this variable to call the controller class
	Customer_model Customermodel; //global variable type class Login_view
	
	public Customer_model(Login_controller Ccontroller) {
		this.controller = Ccontroller;
		
		
	}
	
	
	
///////////////////////////////method to create a connection to database
	public void db() {
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/bh_system";
			String user = "root";
			String password = "";
			String query="";
			
			if (controller.Window == "Customer") {
			query = "SELECT B_Id, B_Date, B_Time, B_Status, USERS_U_Email1 FROM BOOKINGS WHERE USERS_U_Email='"+ controller.getEmail() +"' AND B_Status<>'Cancel'";			
			}
			
			
			//object from my driver i get the connection
			//.getConnection is a static method
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;
			
			// Get a statement from the connection
			//statement is to say what do i want to do (queries)
			Statement stmt = conn.createStatement() ;
			
			
			// Execute the query
			//result set is a set of values because we usually get a group of values after execute a query from statement
			ResultSet rs = stmt.executeQuery(query) ;
			// Loop through the result set
			int i=0; //variable to loop the results
			while(rs.next()) {
				
					controller.dataBookings[i][0] = rs.getString("B_Id");
					controller.dataBookings[i][1] = rs.getString("B_Date");
					controller.dataBookings[i][2] = rs.getString("B_Time");
					controller.dataBookings[i][3] = rs.getString("B_Status");
					controller.dataBookings[i][4] = rs.getString("USERS_U_Email1");
					//controller.UserName = rs.getString("U_fName").toString();
					//System.out.println(""+ controller.UserName +"");
					//controller.RoleUser = rs.getString("U_Role"); //get the user's role in Login page
					i++;	
				
			}
				rs.close() ;
			
			
			
			// Close the result set, statement and the connection
			
			stmt.close() ;
			conn.close() ;
			}
			catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;
			
			// Loop through the SQL Exceptions
			while( se != null ){
			System.out.println( "State  : " + se.getSQLState()  ) ;
			System.out.println( "Message: " + se.getMessage()   ) ;
			System.out.println( "Error  : " + se.getErrorCode() ) ;
			
			se = se.getNextException() ;
			}
		}
		catch( Exception e ){
		System.out.println( e ) ;
		}
	
	
	
	}//end method db
	
	
}
