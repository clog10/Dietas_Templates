/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Grupoalimentos;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
public class GrupoalimentosFacade extends AbstractFacade<Grupoalimentos> {

    @PersistenceContext(unitName = "calorias_templates-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoalimentosFacade() {
        super(Grupoalimentos.class);
    }
    
}
