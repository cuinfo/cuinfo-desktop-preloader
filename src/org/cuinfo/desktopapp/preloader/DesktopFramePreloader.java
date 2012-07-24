/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cuinfo.desktopapp.preloader;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.cuinfo.desktopapp.preloader.fxmls.loader.LoaderController;

/**
 * 预加载界面
 *
 * @author Administrator
 */
public class DesktopFramePreloader extends Preloader {

    Stage stage;
    LoaderController controller;

    private Scene createPreloaderScene() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/cuinfo/desktopapp/preloader/fxmls/loader/Loader.fxml"), ResourceBundle.getBundle("org.cuinfo.desktopapp.preloader.fxmls.loader.Loader"));
        AnchorPane context = (AnchorPane) fxmlLoader.load();
        controller = fxmlLoader.getController();
      

        return new Scene(context, 600, 300);
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(createPreloaderScene());
        stage.show();

    }
    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info != null) {
            if (info instanceof PreloaderMessageNotification) {
                controller.getMessageLabel().setText(((PreloaderMessageNotification) info).getMessage());
            } else if (info instanceof ProgressNotification) {
                controller.getProgressBar().setProgress(((ProgressNotification) info).getProgress());

            } else if (info instanceof ErrorNotification) {
                controller.getErrorLabel().setText(((ErrorNotification) info).getDetails());
                controller.getErrorLabel().setVisible(true);
                controller.getCloseButton().setVisible(true);
                
            } else if (info instanceof StateChangeNotification) {
                stage.hide();
            }

        }

    }
}
