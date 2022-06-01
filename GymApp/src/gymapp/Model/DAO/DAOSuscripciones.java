/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model.DAO;

import gymapp.Model.AccesoDatos;
import gymapp.Model.FactoryMethod.Cliente;
import gymapp.Model.Suscripcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lissete Rosete Rosas
 */
public class DAOSuscripciones {
    AccesoDatos oAD;
    ResultSet rs;
    public List<Suscripcion> GetSuscripciones() throws Exception {
        boolean userFind = false;
        List<Suscripcion> Suscripciones = new ArrayList<Suscripcion>();
        
        oAD = new AccesoDatos();
        String sQuery = "SELECT s.suscripcion_id, s.fecha_inicio, s.fecha_fin, "
                + "s.total_pago, s.estado, s.plan_id, s.id_cliente, "
                + "c.nombre || ' ' || c.ap_paterno || ' ' || c.ap_materno AS Nombre "
                + "FROM suscripcion AS s "
                + "INNER JOIN clientes AS c ON c.cliente_id = s.id_cliente";
        
        try {
            if (AccesoDatos.conectar()) {
                rs = oAD.ejecutarConsulta(sQuery);
                oAD.desconectar();
                if(rs != null){
                    while(rs.next()) {
                        Suscripcion Sus = new Suscripcion();
                        Sus.setIdSuscripcion(rs.getInt("suscripcion_id"));
                        Sus.setFechaInicio(rs.getDate("fecha_inicio"));
                        Sus.setFechaFin(rs.getDate("fecha_fin"));
                        Sus.setTotalPago(rs.getFloat("total_pago"));
                        Sus.setEstado(rs.getString("estado"));
                        Sus.setPlanId(rs.getInt("plan_id"));
                        Sus.setIdCliente(rs.getInt("id_cliente"));
                        Sus.setNombreCliente(rs.getString("Nombre"));
                        
                        Suscripciones.add(Sus);
                        userFind = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("PGSQL_ERROR: " + e.getMessage());
        }
        return Suscripciones;
    }
}
