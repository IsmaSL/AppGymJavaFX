/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymapp.Model;

import java.util.Date;
/**
 *
 * @author Lissete Rosete Rosas
 */
public class Suscripcion {
    
    private int IdSuscripcion;
            
    private Date FechaInicio;
    
    private Date FechaFin;
    
    private float TotalPago;
    
    private String Estado;
    
    private int PlanId;
    
    private int IdCliente;
    
    private String NombreCliente;

    /**
     * @return Identificador de la Suscripción
     */
    public int getIdSuscripcion() {
        return IdSuscripcion;
    }

    /**
     * @param IdSuscripcion the IdSuscripcion to set
     */
    public void setIdSuscripcion(int IdSuscripcion) {
        this.IdSuscripcion = IdSuscripcion;
    }

    /**
     * @return the FechaInicio
     */
    public Date getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFin
     */
    public Date getFechaFin() {
        return FechaFin;
    }

    /**
     * @param FechaFin the FechaFin to set
     */
    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    /**
     * @return the TotalPago
     */
    public float getTotalPago() {
        return TotalPago;
    }

    /**
     * @param TotalPago the TotalPago to set
     */
    public void setTotalPago(float TotalPago) {
        this.TotalPago = TotalPago;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the PlanId
     */
    public int getPlanId() {
        return PlanId;
    }

    /**
     * @param PlanId the PlanId to set
     */
    public void setPlanId(int PlanId) {
        this.PlanId = PlanId;
    }

    /**
     * @return the IdCliente
     */
    public int getIdCliente() {
        return IdCliente;
    }

    /**
     * @param El Isma es un pendejo
     */
    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    /**
     * @return the NombreCliente
     */
    public String getNombreCliente() {
        return NombreCliente;
    }

    /**
     * @param NombreCliente the NombreCliente to set
     */
    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }
    
}
