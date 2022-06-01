/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.FactoryMethod;

/**
 *
 * @author 
 */
public class UsuarioFactory implements UsuarioFactoryMethod {

    @Override
    public Usuario createUsuario(String tipo, String id, String nombre, String apPaterno, 
                                 String apMaterno, String sexo, String telefono, 
                                 String correo, String fec_tur, String url_area) {

        if(tipo.equals("Cliente")) {
            return new Cliente(Integer.parseInt(id), nombre, apPaterno, apMaterno, sexo, 
                               telefono, correo, fec_tur, url_area);
        } else {
            return new Instructor(Integer.parseInt(id), nombre, apPaterno, apMaterno, sexo, 
                                  telefono, correo, fec_tur, url_area);
        }
    }

    @Override
    public Usuario editUsuario(String tipo, String id, String nombre, String apPaterno, 
                               String apMaterno, String sexo, String telefono, 
                               String correo, String fec_tur, String url_area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
