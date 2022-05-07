/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.FactoryMethod;

import gymapp.Model.AccesoDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IsmaSL
 */
public class Instructor extends Usuario {
    
    private String turno;
    private String area;
    AccesoDatos oAD;
    
    public Instructor(String id_user, String nombre, String apPaterno, 
                      String apMaterno, String sexo, String telefono, 
                      String correo, String turno, String area) {
        super(id_user, nombre, apPaterno, apMaterno, sexo, telefono, correo);
        this.turno = turno;
        this.area = area;
    }

    @Override
    public ArrayList<Instructor> consultarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarUsuario() {
        boolean userAdd = false;
        int rs;
        
        try {
            oAD = new AccesoDatos();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        
        String sQuery = "INSERT INTO ...;";
        
        try {
            if (oAD.conectar()) {
                rs = oAD.ejecutarComando(sQuery);
                oAD.desconectar();
                if(rs >= 1){
                    userAdd = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("PGSQL_ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        
        return userAdd;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
