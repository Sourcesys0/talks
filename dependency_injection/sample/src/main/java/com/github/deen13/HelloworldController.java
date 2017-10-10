package com.github.deen13;

import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@FXMLController
public class HelloworldController {

    @FXML
    private Label helloLabel;
  
    @FXML
    private TextField nameField;
    
    @Autowired
    private AwesomeActionService actionService;
    
    @FXML
    private void setHelloText(final Event event) {
       final String textToBeShown = actionService.processName(nameField.getText());
       helloLabel.setText(textToBeShown); 
    }
    
}
