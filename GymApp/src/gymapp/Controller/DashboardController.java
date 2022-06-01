/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp.Controller;

import gymapp.Model.DAO.DAOClientes;
import gymapp.Model.DAO.DAOInstructores;
import gymapp.Model.FactoryMethod.*;
import gymapp.Model.State.ControlState;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DashboardController implements Initializable {

    @FXML
    private Accordion acordeon;
    @FXML
    private TitledPane paneDetalles, panePlan;
    @FXML 
    private TableView<Usuario> tableView;
    @FXML 
    private TableColumn<Usuario, String> id_cliente;
    @FXML 
    private TableColumn<Usuario, String> nombre;
    @FXML 
    private TableColumn<Usuario, String> ap_paterno;
    @FXML 
    private TableColumn<Usuario, String> ap_materno;
    @FXML 
    private TableColumn<Usuario, String> inscripcion;
    @FXML 
    private TableColumn<Usuario, String> telefono;
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
        try {
            Actualizar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }    

    public void Actualizar() throws Exception{
        if(cbxVerTipoUsuario.getSelectionModel().getSelectedItem()=="Cliente"){
            DAOClientes DaoClientes = new DAOClientes();
            List<Cliente> Clientes = DaoClientes.GetClientes();
            id_cliente.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id_user"));
            nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
            ap_paterno.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apPaterno"));
            ap_materno.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apMaterno"));
            inscripcion.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo"));
            telefono.setCellValueFactory(new PropertyValueFactory<Usuario, String>("telefono"));

            tableView.getItems().setAll(Clientes);
        } if(cbxVerTipoUsuario.getSelectionModel().getSelectedItem()=="Instructor") {
            DAOInstructores DaoInstructores = new DAOInstructores();
            List<Instructor> Instructores = DaoInstructores.GetInstructores();
            id_cliente.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id_user"));
            nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
            ap_paterno.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apPaterno"));
            ap_materno.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apMaterno"));
            inscripcion.setCellValueFactory(new PropertyValueFactory<Usuario, String>("correo"));
            telefono.setCellValueFactory(new PropertyValueFactory<Usuario, String>("telefono"));
            tableView.getItems().setAll(Instructores);
        }
    }
    
    @FXML
    private void btnMostrarAgregar(javafx.event.ActionEvent event) {
        acordeon.setVisible(true);
        acordeon.setExpandedPane(paneDetalles);
        paneDetalles.setText("Registrar usuario");
        btnGenerarCedula.setVisible(false);
        panePlan.setVisible(false);
    }

    @FXML
    private void btnRegistrarUsuario(javafx.event.ActionEvent event) throws Exception {
        UsuarioFactoryMethod factory = new UsuarioFactory();

        Usuario user = factory.createUsuario(cbxTipoUsuario.getSelectionModel().getSelectedItem(), 
                                             "0", 
                                             txtNombre.getText(), 
                                             txtApPaterno.getText(), 
                                             txtApMaterno.getText(), 
                                             cbxSexo.getSelectionModel().getSelectedItem(), 
                                             txtTelefono.getText(), 
                                             txtCorreo.getText(), 
                                             dteFeNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
                                             "");
        if(user.registrarUsuario()){
            Alert msj = new Alert(Alert.AlertType.CONFIRMATION);
            msj.setTitle("Mensaje");
            msj.setContentText("Se guardo con éxito.");
            msj.showAndWait();
            Actualizar();
        } else {
            Alert msj = new Alert(Alert.AlertType.CONFIRMATION);
            msj.setTitle("Mensaje");
            msj.setContentText("No se guardo :C");
            msj.showAndWait();
        }
    }

    @FXML
    private void btnGenerarCredencial(MouseEvent event) {
    }
    
    @FXML
    private void btnActualizar(javafx.event.ActionEvent event) throws Exception {
        Actualizar();
    }
    
    @FXML
    private void btnSuscripciones(javafx.event.ActionEvent event) throws Exception {
        ControlState Controlito = new ControlState();
        String Mensaje = Controlito.ConsultStatus();
        System.out.println(Mensaje);
        Alert msj = new Alert(Alert.AlertType.INFORMATION);
        msj.setTitle("Mensaje");
        msj.setContentText(Mensaje);
        msj.show();
    }
}
