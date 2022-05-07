/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.FactoryMethod;

/**
 *
 * @author IsmaSL
 */
public interface UsuarioFactoryMethod {
    public Usuario createUsuario(String tipo, String id, String nombre, String apPaterno, 
                                 String apMaterno, String sexo, String telefono, 
                                 String correo, String fec_tur, String url_area);
    
    public Usuario editUsuario(String tipo, String id, String nombre, String apPaterno, 
                                 String apMaterno, String sexo, String telefono, 
                                 String correo, String fec_tur, String url_area);
}
