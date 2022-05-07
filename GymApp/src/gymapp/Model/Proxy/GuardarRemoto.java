/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.Proxy;

/**
 *
 * @author IsmaSL
 */
public class GuardarRemoto implements iGuardar {

    @Override
    public void save() {
        System.out.println("Guardando datos remotamente...");
        // Aquí se modificarian los parametros de properties
        // para guardar los datos de forma remota en cuanto
        // detecte que no haya conexion en la forma local.
    }

}
