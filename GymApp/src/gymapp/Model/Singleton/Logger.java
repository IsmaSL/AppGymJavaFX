/*
 * File: Logger.java
 * Description: Clase para la funcionalidad de Login, haciendo uso del patron
 *              Singleton.
 */

package gymapp.Model.Singleton;

import gymapp.Model.AccesoDatos;
import gymapp.Model.Proxy.GuardarDatos;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IsmaSL
 */
public class Logger {
    
    AccesoDatos oAD;
    private static Logger log;
    private String user;
    private String pass;
    
    private Logger(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public static synchronized Logger getInstance(String user, String pass){
        if(log == null)
            log = new Logger(user, pass);
        else
            System.out.println("-- La sesión ya existe. --");
        return log;
    }
    
    public void closeInstance() {
        log = null;
    }
    
    
    public boolean getSesion() throws Exception{
        boolean userFind = false;
        ResultSet rs;
        oAD = new AccesoDatos();
        String sQuery = "SELECT * FROM usuarios WHERE usr = '" + this.user + "' AND pas = '" + this.pass + "';";
        
        try {
            // PROXY: Se pregunta en donde se guardarán los datos
            GuardarDatos gd = new GuardarDatos();
            gd.save();
            // --------------------------------------------------
            if (AccesoDatos.conectar()) {
                rs = oAD.ejecutarConsulta(sQuery);
                oAD.desconectar();
                if(rs != null){
                    while(rs.next()) {
                        userFind = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("PGSQL_ERROR: " + e.getMessage());
        }
        
        return userFind;
    }
}
