package controller.tab;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeController {
	@FXML private Button insertBT;
	@FXML private Button deleteBT;
	@FXML private Button updateBT;
	@FXML private Button clearBT;
	@FXML private Button searchBT;
	@FXML private Button credentialsBT;
	
	@FXML private TextField EmployeeIDTF;
	@FXML private TextField badgenumberTF;
	@FXML private TextField firstnameTF;
	@FXML private TextField lastnameTF;
	@FXML private TextField birthdateTF;
	@FXML private TextField streetnumTF;
	@FXML private TextField streetnameTF;
	@FXML private TextField cityTF;
	@FXML private TextField stateTF;
	@FXML private TextField zipcodeTF;
	@FXML private TextField phonenumberTF;
	@FXML private TextField emailTF;
	@FXML private TextField paydateTF;
	@FXML private TextField houryrateTF;
	@FXML private TextField salaryrateTF;
	@FXML private TextField vacationdaysTF;
	@FXML private TextField vacationstartTF;
	@FXML private TextField vacationendTF;
	

	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;

	@FXML private void InsertBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void DeleteBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void UpdateBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void ClearBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void SearchBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void CredentialsClicked(ActionEvent event) throws IOException{
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CredentialWindow.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1)); 
		stage.show();
		
	}
}
