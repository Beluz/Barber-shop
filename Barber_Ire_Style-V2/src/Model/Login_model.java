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

public class Login_model extends JFrame{

	Login_controller controller;  //we are using this variable to call the controller class
	Login_view Loginview; //global variable type class Login_view
	
	
	public Login_model(Login_controller mlcontroller) {
		this.controller = mlcontroller;
		

	}
	
	
	/////////////////////////////////method to create a connection to database
	public void db() {
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/bh_system";
			String user = "root";
			String password = "";
			String query="";
			
			if (controller.Window == "Login") {
				query = "SELECT U_fName, U_Role FROM users where U_Email='"+ controller.getEmail() +"' and U_Password= '"+ controller.getPassword() +"'";			
			}else if(controller.Window=="SignUp") {
				//query = "INSERT INTO USERS VALUES('"+ Email +"','"+ Password +"','"+SignUpview.tFirstName.getText()+"','"+ SignUpview.tSecondName.getText()+"','"+ RoleUser  +"', '"+ SignUpview.tPhone.getText() +"','Pending','"+ SignUpview.tLocation.getText() +"')";
				
			}
			

			//object from my driver i get the connection
			//.getConnection is a static method
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			//statement is to say what do i want to do (queries)
			Statement stmt = conn.createStatement() ;

			if (controller.Window =="Login") {
				// Execute the query
				//resultset is a set of values because we usually get a group of values after execute a query from statement
				ResultSet rs = stmt.executeQuery(query) ;
				// Loop through the result set
				int i=0; //variable to loop the results
				while(rs.next()) {
					controller.logged = true; //if there is results of the query
					if (controller.Window == "Login") {
						controller.data[i][0] = rs.getString("U_fName");
						controller.UserName = rs.getString("U_fName").toString();
						System.out.println(""+ controller.UserName +"");
						controller.RoleUser = rs.getString("U_Role"); //get the user's role in Login page
						i++;	
					}else if (controller.Window == "SignUp") {
						System.out.println("inserted");
					}
				}
				rs.close() ;
			}else if(controller.Window=="SignUp") {
				stmt.executeUpdate(query) ;
				JOptionPane.showMessageDialog(this, "You have been Sign Up!");
			}
			
			

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
