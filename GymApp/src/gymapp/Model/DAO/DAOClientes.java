/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model.DAO;
import gymapp.Model.AccesoDatos;
import gymapp.Model.FactoryMethod.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Lissete Rosete Rosas
 */
public class DAOClientes {
    AccesoDatos oAD;
    ResultSet rs;
    
    public List<Cliente> GetClientes() throws Exception {
        boolean userFind = false;
        List<Cliente> Clientes = new ArrayList<Cliente>();
        
        oAD = new AccesoDatos();
        String sQuery = "SELECT * FROM clientes";
        
        try {
            if (AccesoDatos.conectar()) {
                rs = oAD.ejecutarConsulta(sQuery);
                oAD.desconectar();
                if(rs != null){
                    while(rs.next()) {
                        Cliente Clie = new Cliente();
                        Clie.setId_user(rs.getInt("cliente_id"));
                        Clie.setNombre(rs.getString("nombre"));
                        Clie.setApPaterno(rs.getString("ap_paterno"));
                        Clie.setApMaterno(rs.getString("ap_materno"));
                        Clie.setFechaNac(rs.getString("fecha_nac"));
                        Clie.setTelefono(rs.getString("telefono"));
                        Clie.setCorreo(rs.getString("correo"));
                        Clie.setUrlFoto(rs.getString("foto"));
                        Clientes.add(Clie);
                        userFind = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("PGSQL_ERROR: " + e.getMessage());
        }
        return Clientes;
    }
    
    public boolean addClientes(Cliente clie) throws Exception {
        oAD = new AccesoDatos();
        String sQuery = "INSERT INTO clientes (nombre, ap_paterno, ap_materno, fecha_nac, telefono, correo, foto)" 
                + "VALUES ('"+clie.getNombre()+"', '"+clie.getApPaterno()+"','"+clie.getApMaterno()+"', '"+clie.getFechaNac()+"','"+clie.getTelefono()+"','"+clie.getCorreo()+"','"+clie.getUrlFoto()+"');";
        System.out.println(sQuery);
        if (AccesoDatos.conectar()) {
            rs = oAD.ejecutarConsulta(sQuery);
            oAD.desconectar();   
            return true;
        }  
        return false;
    }
}
