/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model.State;

import gymapp.Model.DAO.DAOSuscripciones;
import gymapp.Model.Suscripcion;
import java.util.List;
/**
 *
 * @author Lissete Rosete Rosas
 */
public class SuscripcionState {
    
    private List<Suscripcion> Suscripcion;
    
    public SuscripcionState() throws Exception{
        Suscripcion = SetSuscriptions();
    }
    
    public List<Suscripcion> SetSuscriptions() throws Exception{
        DAOSuscripciones Sus = new DAOSuscripciones();
        return Sus.GetSuscripciones();
    }
    
    public List<Suscripcion> GetSuscriptions(){
        return Suscripcion;
    }
}
