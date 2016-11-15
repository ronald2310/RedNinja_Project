package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SiteController {

	@FXML private Button SInsertBT;
	@FXML private Button SUpdateBT;
	@FXML private Button SDeleteBT;
	@FXML private Button SClearBT;
	@FXML private Button SSearchBT;
	
	@FXML private TextField SsiteIDTF;
	@FXML private TextField SsitenameTF;
	@FXML private TextField ScityTF;
	@FXML private TextField SstateTF;
	@FXML private TextField SzipcodeTF;
	@FXML private TextField SsitedescriptionTF;
	
	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;
	
	//Credentials for the database
		String DBName = "TridentDB";
		String user = "user";
		String password= "Pass123456";
	
	
@FXML private void SInsertBTClicked(ActionEvent event){

	MessageLB.setText("");
	ErrorMessageLB1.setText("");
	
	// Gets Text from TexFields and gives it to a String Variable
	String siteIDText = SsiteIDTF.getText();
	String siteName =  SsitenameTF.getText();
	String city = ScityTF.getText();
	String state = SstateTF.getText();
	String zipcode = SzipcodeTF.getText();
	String siteDescription = SsitedescriptionTF.getText();

	// Changes Text type data to Int type data to follow database rules
	int siteID  = Integer.parseInt(siteIDText);
	

	// Uses JDBC to establish connection
	String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;

	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		Statement stmt = con.createStatement();
		// Statement inserts Information from Text Field into Database
		String sqlStatement = "Insert INTO Site " +
					"(SiteId, SiteName, City, State, ZipCode, SiteDescription) " +
					"VALUES(" + siteID + ",'" + siteName + "', '" + city + "', '" + state +  "', '" + zipcode + "','" + siteDescription + "')";
		// Commits to database		
	stmt.execute(sqlStatement);
         // Closes connection
		con.close();

		// Shows Message for Feedback
		MessageLB.setText("Insert Succesful");
	} //Catches errors
	
	catch(Exception ex)
	{
		//Shows error message
		ErrorMessageLB1.setText("Error: " + ex.getMessage());
		// MessageLB.setText("Insert Failed");
	}		
	}
	
@FXML private void  SUpdateBTClicked(ActionEvent event){
	MessageLB.setText("");
	ErrorMessageLB1.setText("");
	
	// Gets Text from TexFields and gives it to a String Variable
	String siteIDText = SsiteIDTF.getText();
	String siteName =  SsitenameTF.getText();
	String city = ScityTF.getText();
	String state = SstateTF.getText();
	String zipcode = SzipcodeTF.getText();
	String siteDescription = SsitedescriptionTF.getText();

	// Changes Text type data to Int type data to follow database rules
	int siteID  = Integer.parseInt(siteIDText);
	

	// Uses JDBC to establish connection
	String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;

	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		Statement stmt = con.createStatement();
		// Statement inserts Information from Text Field into Database
		String sqlStatement = "UPDATE Site " +
                "SET SiteName = '" + siteName + "',"
                + " City = '" + city + "', State = '" + state + "', ZipCode = '" + zipcode + "', SiteDescription = '" + siteDescription + "'   "  +
                "WHERE  SiteId = " + siteID + " ";
		// Commits to database		
	stmt.execute(sqlStatement);
         // Closes connection
		con.close();

		// Shows Message for Feedback
		MessageLB.setText("Insert Succesful");
	} //Catches errors
	
	catch(Exception ex)
	{
		//Shows error message
		ErrorMessageLB1.setText("Error: " + ex.getMessage());
		// MessageLB.setText("Insert Failed");
	}		
		
	}

@FXML private void SDeleteBTClicked(ActionEvent event){
	MessageLB.setText("");
	ErrorMessageLB1.setText("");
	
	String siteIDText = SsiteIDTF.getText();
	int siteID  = Integer.parseInt(siteIDText);
	
	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;

	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		Statement stmt = con.createStatement();
		
		String sqlStatement ="DELETE FROM Site " +
							 "WHERE SiteId = " + siteID + "";
				
        stmt.execute(sqlStatement);
         
		con.close();
		
		 MessageLB.setText("Delete Succesful"); 
	}
	
	catch(Exception ex)
	{
		ErrorMessageLB1.setText(("Error: " + ex.getMessage() ));
		// MessageLB.setText("Insert Failed");
	}
	
	
}

@FXML private void SClearBTClicked(ActionEvent event){
	MessageLB.setText("");
	ErrorMessageLB1.setText("");
	
	SsiteIDTF.clear();
	SsitenameTF.clear();
	ScityTF.clear();
	ScityTF.clear();
	SzipcodeTF.clear();
	SstateTF.clear();
	SsitedescriptionTF.clear(); 

	 MessageLB.setText("Clear Succesful");
	
}

@FXML private void SSearchBTClicked(ActionEvent event){
	MessageLB.setText("");
	ErrorMessageLB1.setText("");
	
	 String siteIdText = SsiteIDTF.getText();
		int siteId  = Integer.parseInt(siteIdText);
		
	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement ="SELECT * FROM Site WHERE SiteId = " + siteId;
					
			ResultSet result = stmt.executeQuery(sqlStatement);
			
		 while (result.next())
		 {
			 
			 SsitenameTF.setText((result.getString("SiteName")));
			 ScityTF.setText((result.getString("City")));
				SzipcodeTF.setText((result.getString("ZipCode")));
				SstateTF.setText((result.getString("State")));
				SsitedescriptionTF.setText((result.getString("SiteDescription")));
				
				
				 MessageLB.setText("Search Succesful");
			
		 }
			con.close();
	
		
		}
		catch(Exception ex)
		{
			ErrorMessageLB1.setText(("Error: " + ex.getMessage() ));
			// MessageLB.setText("Insert Failed");
		}
	
}
}
