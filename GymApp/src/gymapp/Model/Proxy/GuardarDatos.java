/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymapp.Model.Proxy;

import gymapp.Model.AccesoDatos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IsmaSL
 */
public class GuardarDatos implements iGuardar {

    @Override
    public void save() {
        try
        {
            if(AccesoDatos.conectar())
                new GuardarLocal().save();
            else
                new GuardarRemoto().save();
        } catch (Exception ex)
        {
            Logger.getLogger(GuardarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
