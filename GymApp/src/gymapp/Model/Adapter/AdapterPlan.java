package gymapp.Model.Adapter;

import java.util.ArrayList;

/**
 *
 * @author IsmaSL
 */
public class AdapterPlan implements iPlan {
    
    private PlanBasico basico;
    
    public AdapterPlan(PlanBasico plan){
        this.basico = plan;
    }

    @Override
    public Plan registrarPlan() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void editarPlan() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Plan> consultarPlanes() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void cambiarPreferencias() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTipo() {
        return basico.tipo;
    }

    @Override
    public void setTipo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Float getPrecio() {
        return basico.precio;
    }

    @Override
    public void setPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getEstado() {
        return basico.estado;
    }

    @Override
    public void setEstado() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean getAccDesc() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAccDesc() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getInstAsig() {
        return basico.inst_asig;
    }

    @Override
    public void setInstAsig() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean getAccTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAccTotal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
