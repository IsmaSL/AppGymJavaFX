/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model.DAO;

import gymapp.Model.AccesoDatos;
import gymapp.Model.FactoryMethod.Cliente;
import gymapp.Model.FactoryMethod.Instructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lissete Rosete Rosas
 */
public class DAOInstructores {
    AccesoDatos oAD;
    ResultSet rs;
    
    public List<Instructor> GetInstructores() throws Exception {
        boolean userFind = false;
        List<Instructor> Instructores = new ArrayList<Instructor>();
        
        oAD = new AccesoDatos();
        String sQuery = "SELECT * FROM instructor";
        
        try {
            if (AccesoDatos.conectar()) {
                rs = oAD.ejecutarConsulta(sQuery);
                oAD.desconectar();
                if(rs != null){
                    while(rs.next()) {
                        Instructor Inst = new Instructor();
                        Inst.setId_user(rs.getInt("instructor_id"));
                        Inst.setNombre(rs.getString("nombre"));
                        Inst.setApPaterno(rs.getString("ap_paterno"));
                        Inst.setApMaterno(rs.getString("ap_materno"));
                        Inst.setTelefono(rs.getString("telefono"));
                        Inst.setCorreo(rs.getString("correo"));
                        Inst.setTurno(rs.getString("turno"));
                        Inst.setArea(rs.getString("area"));
                        Instructores.add(Inst);
                        userFind = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("PGSQL_ERROR: " + e.getMessage());
        }
        return Instructores;
    }
    
    public boolean addInstructor(Instructor inst) throws Exception {
        oAD = new AccesoDatos();
        String sQuery = "INSERT INTO instructor (nombre, ap_paterno, ap_materno, telefono, correo, turno, area)" 
                + " VALUES ('"+inst.getNombre()+"', '"+inst.getApPaterno()+"','"+inst.getApMaterno()+"', '"+inst.getTelefono()+"','"+inst.getCorreo()+"','"+inst.getTurno()+"','"+inst.getArea()+"');";
        System.out.println(sQuery);
        if (AccesoDatos.conectar()) {
            rs = oAD.ejecutarConsulta(sQuery);
            oAD.desconectar();   
            return true;
        }  
        return false;
    }
}
