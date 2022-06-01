package gymapp.Model.Adapter;

import java.util.ArrayList;

/**
 *
 * @author IsmaSL
 */
public interface iPlan {
    public Plan registrarPlan();
    public void editarPlan();
    public ArrayList<Plan> consultarPlanes();
    public void cambiarPreferencias();
    
    public String getTipo();
    public void setTipo();
    
    public Float getPrecio();
    public void setPrecio();
    
    public String getEstado();
    public void setEstado();
    
    public boolean getAccDesc();
    public void setAccDesc();
    
    public boolean getInstAsig();
    public void setInstAsig();
    
    public boolean getAccTotal();
    public void setAccTotal();
}
