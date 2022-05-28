/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapp.Model;

import gymapp.Model.Proxy.GuardarDatos;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author IsmaSL
 */
public class AccesoDatos implements Serializable {

    private static String sUrl = null;      // sUrl de conexión
    private static String sUsr = null;      // Usuario
    private static String sPwd = null;      // Contraseña
    private static String sDriver = null;   // driver del gestor
    private static Connection oConexion = null;    // La conexión

    private static boolean hayConexion = false;

    public AccesoDatos() throws Exception {    
        Properties prop = new Properties();
        prop.load(AccesoDatos.class.getResourceAsStream("config/bdconfig.properties"));
        
        sUrl = prop.getProperty("urldb");
        sUsr = prop.getProperty("usrdb");
        sPwd = prop.getProperty("pwddb");
        sDriver = prop.getProperty("driverdb");
        
        hayConexion = true;
    }
    
    public static boolean hayconexion() {
        return hayConexion;
    }

    /**
     * Realiza la conexión a la base de datos.
     *
     * @return verdadero si pudo conectarse
     * @throws java.lang.Exception
     */
    public static boolean conectar() throws Exception {
        boolean bRet = false;
        try {
            Class.forName(sDriver).newInstance();
            oConexion = DriverManager.getConnection(sUrl, sUsr, sPwd);
            bRet = true;
        } catch (SQLException e) {
            System.out.print(e);
        }
        return bRet;
    }

    /**
     * Realiza la desconexión a la base de datos.
     *
     * @throws java.lang.Exception
     */
    public void desconectar() throws Exception {
        oConexion.close();
        hayConexion = false;
    }

    /**
     * Código que se ejecuta cuando este objeto es recolectado.
     *
     * @throws java.lang.Exception
     */
    @Override
    protected void finalize() throws Exception, Throwable {
        try {
            oConexion.close();
            oConexion = null;
        } finally {
            super.finalize();
        }
    }

    /**
     * Realiza una consulta a la base de datos y retorna un arreglo de arreglos
     * de objetos con los resultados.
     *
     * @param psQuery
     * @return
     * @throws java.lang.Exception
     */
    
    public synchronized ResultSet ejecutarConsulta(String psQuery) throws Exception {
    // public synchronized ArrayList ejecutarConsulta(String psQuery) throws Exception {
        Statement stmt = null;
        ResultSet rset = null;
        ArrayList vrset = null;
        ResultSet rsmd = null;
        // int nNumCols = 0;
        try {
            stmt = oConexion.createStatement();
            rset = stmt.executeQuery(psQuery);
            /*
            rsmd = rset.getMetaData();
            nNumCols = rsmd.getColumnCount();
            vrset = convierteALista(rset, rsmd, nNumCols);
            */
            
        } catch(SQLException e){
            System.out.println("Error:\n"+e+"\n-> Desde: AccesoDatos.ejecutarConsulta...");
        }
        
        /*finally {
            if (rset != null) {
                rset.close();
                if (stmt != null) {
                    stmt.close();
                }
            }
            rset = null;
            stmt = null;
        } */
        return rset;
    }

    /**
     * Realiza una petición de modificación de datos, retornando un entero con
     * el número de registros afectados.
     *
     * @param psStatement
     * @return
     * @throws java.lang.Exception
     */
    public synchronized int ejecutarComando(String psStatement) throws Exception {

        int ret = 0;
        ArrayList vTransaction = new ArrayList();

        vTransaction.add(psStatement);
        ret = ejecutarComando(vTransaction);

        return ret;
    }

    /**
     * Realiza una serie de peticiones de modificación de datos, retornando un
     * entero con el número de registros afectados. Estas peticiones se ejecutan
     * en una transacción.
     *
     * @param pvStatement
     * @return
     * @throws java.lang.Exception
     */
    public synchronized int ejecutarComando(ArrayList pvStatement) throws Exception {

        int ret = 0, i = 0;
        Statement stmt = null;
        String temp = "";

        try {
            oConexion.setAutoCommit(false);
            stmt = oConexion.createStatement();
            for (i = 0; i < pvStatement.size(); i++) {
                temp = (String) pvStatement.get(i);
                ret += stmt.executeUpdate(temp);
            }
            oConexion.commit();
        } catch (SQLException e) {
            oConexion.rollback();
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            stmt = null;
        }

        return ret;
    }
    
    /**
     * Recorre un result set y entrega el arreglo resultante.
     */
    private synchronized ArrayList convierteALista( ResultSet rset, 
                                              ResultSetMetaData rsmd,
                                              int nNumCols ) 
            throws Exception {
        ArrayList vrset = new ArrayList();
        ArrayList vrsettmp = null;
        int i=0;
        
        while (rset.next()) {
            vrsettmp = new ArrayList();
            for (i = 1; i <= nNumCols; i++) {            
                switch (rsmd.getColumnType(i)) {
                case Types.CHAR:
                case Types.VARCHAR:
                    String varchar = "" + doubleQuote(rset.getString(i));
                    vrsettmp.add(varchar);
                    break;
                case Types.INTEGER:
                    vrsettmp.add(new Double(rset.getLong(i)));
                    break;
                case Types.SMALLINT:
                    vrsettmp.add(new Double(rset.getInt(i)));             
                    break;
                case Types.BIGINT:
                case Types.NUMERIC:
                case Types.DECIMAL:
                case Types.FLOAT:
                case Types.DOUBLE:
                case Types.TINYINT:
                    vrsettmp.add(rset.getDouble(i));
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    vrsettmp.add((rset.getTimestamp(i)==null?
                            null:new Date(rset.getTimestamp(i).getTime())));
                    break;
               default:
                    String str = "" + rset.getString(i);
                    vrsettmp.add(str);
                } //switch  
            }  //for
            vrset.add(vrsettmp);
        } //while
        return vrset;
    }
    
    /**
     * Si la cadena contiene comillas en la base de datos, convierte a código.
     * @return String cadena sin las comillas internas.
     */
    private String doubleQuote(String psCadena){
    String sCadenaEntrada="";
    String sRet="";
        if(psCadena == null){
            psCadena = "";
        }
        switch (psCadena) {
            case "":
                sRet = psCadena;
                break;
            case "\"":
                sRet = "&quot;";
                break;
            default:
                int indice = -2;
                sCadenaEntrada=psCadena;
                while((indice = sCadenaEntrada.indexOf("\"",indice+2))!=-1)
                    sCadenaEntrada=sCadenaEntrada.substring(0,
                            sCadenaEntrada.indexOf("\"",indice))+"&quot;"+
                            sCadenaEntrada.substring(
                                    sCadenaEntrada.indexOf("\"",indice)+1);
                sRet = sCadenaEntrada;
                break;
        }
        return sRet;
    }
}
