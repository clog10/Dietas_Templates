
package log_neg;

import acceso_datos.AlimentosFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Alimentos;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
@LocalBean
public class LNAlimento {
    
    @EJB
    private AlimentosFacade alimentosFacade;

    public Alimentos buscar(int id){
        return alimentosFacade.find(id);
    }
}
