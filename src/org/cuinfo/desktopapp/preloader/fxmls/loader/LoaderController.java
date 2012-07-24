/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cuinfo.desktopapp.preloader.fxmls.loader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class LoaderController implements Initializable{

    /**
     * 进度条
     */
    @FXML
    ProgressBar progressBar;
    /**
     * 信息框
     */
    @FXML
    Label messageLabel;
    /**
     * 退出按钮
     */
     @FXML
     Button closeButton;
     /**
     * 版权信息
     */
    @FXML
    Label copyRightLabel;
    @FXML
    Label errorLabel;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      EventHandler<ActionEvent> closeButtonEventHandler= new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
              Platform.exit();
            }
        };
       closeButton.setOnAction(closeButtonEventHandler);
       closeButton.setVisible(false);
       errorLabel.setVisible(false);
       
    }    

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Label getCopyRightLabel() {
        return copyRightLabel;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
    
    
}
