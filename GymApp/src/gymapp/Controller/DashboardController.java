/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp.Controller;

import gymapp.Model.FactoryMethod.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ucmex
 */
public class DashboardController implements Initializable {

    @FXML
    private Accordion acordeon;
    @FXML
    private TitledPane paneDetalles, panePlan;
    @FXML
    private TextField txtIdUsuario, txtNombre, txtApPaterno, 
                      txtApMaterno, txtTelefono, txtCorreo;
    @FXML
    private DatePicker dteFeNacimiento;
    @FXML
    private ComboBox<String> cbxVerTipoUsuario, cbxTipoUsuario, cbxSexo;
    @FXML
    private Button btnElegirFoto, btnGenerarCedula;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbxVerTipoUsuario.getItems().addAll("Cliente", "Instructor");
        // cbxVerTipoUsuario.getSelectionModel().select("Cliente");
        cbxTipoUsuario.getItems().addAll("Cliente", "Instructor");
        cbxSexo.getItems().addAll("Femenino", "Masculino", "Otro");
    }    

    @FXML
    private void btnMostrarAgregar(MouseEvent event) {
        acordeon.setVisible(true);
        acordeon.setExpandedPane(paneDetalles);
        
        paneDetalles.setText("Registrar usuario");
        btnGenerarCedula.setVisible(false);
        
        panePlan.setVisible(false);
    }

    @FXML
    private void btnRegistrarUsuario(MouseEvent event) {
        UsuarioFactoryMethod factory = new UsuarioFactory();
        Usuario user = factory.createUsuario(cbxTipoUsuario.getSelectionModel().getSelectedItem(), 
                                             txtIdUsuario.getText(), 
                                             txtNombre.getText(), 
                                             txtApPaterno.getText(), 
                                             txtApMaterno.getText(), 
                                             cbxSexo.getSelectionModel().getSelectedItem(), 
                                             txtTelefono.getText(), 
                                             txtCorreo.getText(), 
                                             dteFeNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
                                             "");
        if(user.registrarUsuario()){
            // Mensaje de que salio todo chido
        } else {
            // Mensaje bad
        }
    }

    @FXML
    private void btnGenerarCredencial(MouseEvent event) {
    }
    
}
