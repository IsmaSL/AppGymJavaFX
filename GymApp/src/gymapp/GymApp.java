/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author IsmaSL
 */
public class GymApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
         
        Parent root = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/gymapp/View/images/icon.png"));
        primaryStage.setWidth(330);
        primaryStage.setHeight(530);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Iniciar Sesión");
        primaryStage.show();
                
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}