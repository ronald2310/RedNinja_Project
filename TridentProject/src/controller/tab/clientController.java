package controller.tab;

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
	@FXML private TextField CPhoneNumTF;
	@FXML private TextField CemailTF;
	@FXML private TextField CCompanyNTF;
	@FXML private TextField CCompanyTTF;
	@FXML private TextField CContactTTF;
	@FXML private TextField CCityTF;
	@FXML private TextField CZipCodeTF;
	@FXML private TextField CStateTF;
	@FXML private TextField CNameTF;
	@FXML private TextField CStreetNumTF;
	@FXML private TextField CStreetNameTF;
	@FXML private TextField CConNameTF;
	

	
	
	@FXML private Label MessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	//Insert Client Information to database
	@FXML private void CInsertBTClicked(ActionEvent event) throws SQLException, ClassNotFoundException{
		
	
		
		String clientNumText = CClientNumTF.getText();
		String phoneNumber =  CPhoneNumTF.getText();
		String email = CemailTF.getText();
		String companyName = CCompanyNTF.getText();
		String companyType = CCompanyTTF.getText();
		String contactTimeText = CContactTTF.getText();
		String city =  CCityTF.getText();
		String zipCode = CZipCodeTF.getText();
		String state = CStateTF.getText();
		String name = CNameTF.getText();
		String streetNum =  CStreetNumTF.getText();
		String streetName = CStreetNameTF.getText();
		String contactName= CConNameTF.getText();


		int clientNum  = Integer.parseInt(clientNumText);
		int contractTime = Integer.parseInt(contactTimeText);
	
		
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement = "Insert INTO Client " +
						"(ClientId, CompanyName, Name, Email, CompanyType, ContractLength, StreetNumber, StreetName, City, State, ZipCode, PhoneNumber, ContactName) " +
						"VALUES(" + clientNum + ",'" + companyName + "', '" + name +  "', '" + email + "', '" + companyType + "', " +  contractTime + ", '" + streetNum + "', '" + streetName + "','" + city + "', '" + state +  "', '" + zipCode + "','" + phoneNumber + "', '" + contactName + "')";
					
	        stmt.executeQuery(sqlStatement);
	         
			con.close();
	
			 
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
		 MessageLB.setText("Insert Succesful");
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
		String clientNumText = CClientNumTF.getText();
		int clientNum  = Integer.parseInt(clientNumText);
		
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement ="DELETE FROM Client " +
								 "WHERE ClientId = " + clientNum + "";
					
	        stmt.executeQuery(sqlStatement);
	         
			con.close();
			
		
		}
		
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
		 MessageLB.setText("Delete Succesful"); 


	}
	//Clears everything in client GUI
	@FXML private void CClearBTClicked(ActionEvent event){
		CClientNumTF.clear();
		CPhoneNumTF.clear();
		CemailTF.clear();
		CCompanyNTF.clear();
		CCompanyTTF.clear();
		CContactTTF.clear();
		CCityTF.clear();
		CZipCodeTF.clear();
		CStateTF.clear();
		CNameTF.clear();
		CStreetNumTF.clear();
		CStreetNameTF.clear();
		CConNameTF.clear(); 
	
		 MessageLB.setText("Clear Succesful");
		
		
	}
	//Search for Client information using their CClientNunTF
	@FXML private void CSearchBTClicked(ActionEvent event){
		 String clientNumText = CClientNumTF.getText();
			int clientNum  = Integer.parseInt(clientNumText);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Client WHERE ClientId = " + clientNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					CCompanyNTF.setText((result.getString("CompanyName")));
					CPhoneNumTF.setText((result.getString("PhoneNumber")));
					CemailTF.setText((result.getString("Email")));
					CCompanyTTF.setText((result.getString("CompanyType")));
					CContactTTF.setText((result.getString("ContractLength"))); // may have to change to int
					CCityTF.setText((result.getString("City")));
					CZipCodeTF.setText((result.getString("ZipCode")));
					CStateTF.setText((result.getString("State")));
					CNameTF.setText((result.getString("Name")));
					CStreetNumTF.setText((result.getString("StreetNumber")));
					CStreetNameTF.setText((result.getString("StreetName")));
					CConNameTF.setText((result.getString("ContactName"))); 
					
					 MessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				System.out.println("Error: " + ex.getMessage());
				// MessageLB.setText("Insert Failed");
			}
		
			
	
		     
		
	}
	
	
}