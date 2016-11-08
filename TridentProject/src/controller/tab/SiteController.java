package controller.tab;

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
	
	@FXML private Label SerrormessageLB;
	@FXML private Label SsuccessmessageLB;
	
	
@FXML private void SInsertBTClicked(ActionEvent event){
		System.out.println("working");
		
	}
	
@FXML private void  SUpdateBTClicked(ActionEvent event){
	System.out.println("working");
		
	}

@FXML private void SDeleteBTClicked(ActionEvent event){
	System.out.println("working");
	
}

@FXML private void SClearBTClicked(ActionEvent event){
	System.out.println("working");
	
}

@FXML private void SSearchBTClicked(ActionEvent event){
	System.out.println("working");
	
}
}
