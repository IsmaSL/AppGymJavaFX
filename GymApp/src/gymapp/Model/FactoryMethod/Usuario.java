/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.FactoryMethod;

import java.util.ArrayList;

/**
 *
 * @author IsmaSL
 */
public abstract class Usuario {
    private String id_user;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String sexo;
    private String telefono;
    private String correo;

    public Usuario(String id_user, String nombre, String apPaterno, 
                   String apMaterno, String sexo, String telefono, 
                   String correo) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    public abstract ArrayList<?> consultarUsuario();
    
    public abstract boolean registrarUsuario();
    
    public abstract boolean editarUsuario();
    
    public abstract Usuario detallesUsuario();
    
    public abstract boolean eliminarUsuario();

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
