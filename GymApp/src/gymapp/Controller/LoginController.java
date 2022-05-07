/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp.Controller;

import gymapp.Model.Singleton.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IsmaSL
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private ProgressIndicator load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public boolean validarCampos() {
        boolean sonVacios = false;
        load.setVisible(true);
        if(txtUser.getText().isEmpty() && txtPass.getText().isEmpty() || 
           txtUser.equals("") && txtPass.equals("")) {
            Alert msj;
            msj = new Alert(Alert.AlertType.ERROR);
            msj.setTitle("ERROR:");
            msj.setContentText("Uno o más campos incompletos.");
            msj.showAndWait();
            
            sonVacios = true;
        } 
        
        return sonVacios;
    }

    // Función para iniciar sesión
    @FXML
    private void btnIniciarSesion(javafx.event.ActionEvent event) throws Exception {
        Alert msj;
        if(!validarCampos()) {
            Logger login = Logger.getInstance(txtUser.getText(), txtPass.getText());
            if(login.getSesion()){
                msj = new Alert(Alert.AlertType.CONFIRMATION);
                msj.setTitle("Mensaje:");
                msj.setContentText("Bienvenido");
                msj.showAndWait();
                //----------------------------------------------
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/gymapp/View/Dashboard.fxml"));

                Scene escena = new Scene(root);
                stage.setScene(escena);
                stage.getIcons().add(new Image("/gymapp/View/images/icon.png"));
                stage.setMinWidth(1250);
                stage.setMinHeight(710);
                stage.setTitle("Inicio");
                stage.show();
                
                ((Node) (event.getSource())).getScene().getWindow().hide();
                //----------------------------------------------
            } else {
                msj = new Alert(Alert.AlertType.ERROR);
                msj.setTitle("Mensaje:");
                msj.setContentText("Usuario o Contraseña incorrecta.");
                msj.showAndWait();
                load.setVisible(false);
                login.closeInstance();
            }
        }
    }
}
