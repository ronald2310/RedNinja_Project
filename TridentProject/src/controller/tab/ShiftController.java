package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class ShiftController {
	@FXML private Button SHinsertBT;
	@FXML private Button SHdeleteBT;
	@FXML private Button SHupdateBT;
	@FXML private Button SHclearBT;
	@FXML private Button SHsearchBT;
	
	@FXML private TextField SHbadgenumberTF;
	@FXML private TextField SHemployeeidTF;
	@FXML private TextField SHofficertypeTF;
	@FXML private TextField SHsiteidTF;
	@FXML private TextField SHshiftidTF;
	@FXML private TextField SHshifttypeTF;
	@FXML private TextField SHdateTF;
	
	
	@FXML private TextArea SHofficerdescriptionTA;
	@FXML private TextArea SHshiftdescriptionTA;
	
	
	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;
	
	@FXML private void SHInsertBTClicked(ActionEvent event){
		System.out.println("working");
		
	}
	
@FXML private void  SHUpdateBTClicked(ActionEvent event){
	System.out.println("working");
		
	}

@FXML private void SHDeleteBTClicked(ActionEvent event){
	System.out.println("working");
	
}

@FXML private void SHClearBTClicked(ActionEvent event){
	System.out.println("working");
	
}

@FXML private void SHSearchBTClicked(ActionEvent event){
	System.out.println("working");
	
}
}


