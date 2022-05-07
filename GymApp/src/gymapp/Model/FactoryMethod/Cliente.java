/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IsmaSL
 */
public class Cliente extends Usuario {

    private String fechaNac;
    private String urlFoto;

    public Cliente(String id_user, String nombre, String apPaterno, 
                   String apMaterno, String sexo, String telefono, 
                   String correo, String fechaNac, String urlFoto) {
        super(id_user, nombre, apPaterno, apMaterno, sexo, telefono, correo);
        this.fechaNac = fechaNac;
        this.urlFoto = urlFoto;
    }

    @Override
    public ArrayList<Cliente> consultarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario detallesUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    
}
