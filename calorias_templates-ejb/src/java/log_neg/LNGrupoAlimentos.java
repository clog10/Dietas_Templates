
package log_neg;

import acceso_datos.GrupoalimentosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Grupoalimentos;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
@LocalBean
public class LNGrupoAlimentos {

    @EJB
    private GrupoalimentosFacade grupoalimentosFacade;

    public List<Grupoalimentos> grupos(){
        return grupoalimentosFacade.findAll();
    }

}
