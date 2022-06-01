/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model.State;

import gymapp.Model.Suscripcion;
import java.util.List;

/**
 *
 * @author Lissete Rosete Rosas
 */
public class ControlState {
    
    public String ConsultStatus() throws Exception{
        String Mensaje = "";
        SuscripcionState Sus = new SuscripcionState();
        List<Suscripcion> Suscripciones = Sus.GetSuscriptions();
        for (int i = 0; i < Suscripciones.size(); i++){
            Mensaje += "|" + Suscripciones.get(i).getNombreCliente() + ", \n|Estado Suscripcion: ";
            Mensaje += Suscripciones.get(i).getEstado() + "\n\n";
        }
        return Mensaje;
    }
}
