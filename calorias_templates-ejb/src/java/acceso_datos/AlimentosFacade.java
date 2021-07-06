/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Alimentos;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
public class AlimentosFacade extends AbstractFacade<Alimentos> {

    @PersistenceContext(unitName = "calorias_templates-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlimentosFacade() {
        super(Alimentos.class);
    }

    public List<Alimentos> obtener(int id) {
        Query q = em.createNativeQuery("SELECT * FROM CARLOS.Alimentos WHERE Alimentos.GRUPOALIMENTOS = " + id, Alimentos.class);
        List<Alimentos> lst = q.getResultList();
        return lst;
    }

}
