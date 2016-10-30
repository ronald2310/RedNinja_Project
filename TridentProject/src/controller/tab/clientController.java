package controller.tab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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

	//Insert Client Information to database
	@FXML private void CInsertBTClicked(ActionEvent event){
		System.out.println("working");
		
	    
		
		//DbConnection connect = new DbConnection(); calling class example
		
	

	}
	// Update Client Information to database
	@FXML private void CUpdateBTTClicked(ActionEvent event){

	
			
			final String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=Demo-Database;user=user;password=Pass123456";
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement = "SELECT firstName FROM test";
				
				ResultSet result = stmt.executeQuery(sqlStatement);
				
				while (result.next())
				{
					System.out.println(result.getString("firstName"));
				}
				System.out.println("Connected");
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