package controller.tab;
import application.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class clientController {
	

	// Lets us use our buttons from our client tab in GUI
	@FXML private Button CInsertBT;
	@FXML private Button CUpdateBT;
	@FXML private Button CDeleteBT;
	@FXML private Button CClearBT;
	@FXML private Button CSearchBT;

	// Lets us use our TextFields from our client tab in GUI
	@FXML private TextField CClientNumTF;
	@FXML private TextField CFirstNTF;
	@FXML private TextField CLastNTF;
	@FXML private TextField CPhoneNumTF;
	@FXML private TextField CemailTF;
	@FXML private TextField CCompanyNTF;
	@FXML private TextField CCompanyTTF;
	@FXML private TextField CContactTTF;
	@FXML private TextField CStreetAdTF;
	@FXML private TextField CCityTF;
	@FXML private TextField CZipCodeTF;
	@FXML private TextField CStateTF;
	@FXML private TextField CConLNameTF;
	@FXML private TextField CConFNameTF;
	
	@FXML private Label MessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	

	//Insert Client Information to database
	@FXML private void CInsertBTClicked(ActionEvent event) throws SQLException, ClassNotFoundException{
		
		String clientNum = CClientNumTF.getText();
		String firstName =CFirstNTF.getText();
		String lastName = CLastNTF.getText();
		String phoneNumber =  CPhoneNumTF.getText();
		String email = CemailTF.getText();
		String companyName = CCompanyNTF.getText();
		String companyType = CCompanyTTF.getText();
		String contactTime = CContactTTF.getText();
		String streetAddress = CStreetAdTF.getText();
		String city =  CCityTF.getText();
		String zipCode = CZipCodeTF.getText();
		String state = CStateTF.getText();
		String contactFirstName = CConFNameTF.getText();
		String contactLastName = CConLNameTF.getText();
		
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement = "Insert INTO Client " +
						"(Client_ID, First_Name, Last_Name, Company_Name, Company_Type, Street_Address, City, "
						+ "State, Zip_Code, Contact_FName, Contact_LName, Email) " +
						"VALUES('" + clientNum + "', '" + firstName + "', '" + lastName + "', '" + companyName + "', '" + companyType + "', '" +  streetAddress  + "', '" + city + "', '" + state + "', '" + zipCode + "', '" + contactFirstName + "', '" + contactLastName + "', '" + email + "' )";
					
	        stmt.executeQuery(sqlStatement);
	        
	       // (Not Working for some reason) MessageLB.setText("Insert Succesful");
	        
	    
			
	        
			con.close();
		 
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
			  
	}
		

	
	// Update Client Information to database
	@FXML private void CUpdateBTTClicked(ActionEvent event){
		System.out.println("working");

		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		//final String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=TridentDB;user=user;password=Pass123456";
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement = "SELECT * FROM Client";
			
			ResultSet result = stmt.executeQuery(sqlStatement);
			
			while (result.next())
			{
				System.out.println(result.getString("Phone_Number"));
				System.out.println(result.getString("First_Name"));
			}
			//System.out.println("Connected");
			con.close();
			System.out.println("Connection Closed");
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}



	
	//Delete Client Information from database
	@FXML private void  CDeleteBTClicked(ActionEvent event){
		System.out.println("working");


	}
	//Clears everything in client GUI
	@FXML private void CClearBTClicked(ActionEvent event){
		System.out.println("working");

	}
	//Search for Client information using their CClientNunTF
	@FXML private void CSearchBTClicked(ActionEvent event){
		System.out.println("working");

	}
	
	
}
