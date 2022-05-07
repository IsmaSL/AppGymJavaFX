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
public class GuardarLocal implements iGuardar {

    @Override
    public void save() {
        System.out.println("Guardando datos localmente...");
    }

}
